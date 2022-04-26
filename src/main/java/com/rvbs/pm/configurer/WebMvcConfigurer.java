package com.rvbs.pm.configurer;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.rvbs.pm.core.ResultCode;
import com.rvbs.pm.core.ServiceException;
import com.rvbs.pm.filter.RequestBodyReaderFilter;
import com.rvbs.pm.tool.ResultTool;
import com.rvbs.pm.tool.ServletHandTool;

import lombok.extern.slf4j.Slf4j;

/**
 * Spring MVC 配置
 */
@Slf4j
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurationSupport {

    private final Logger logger = LoggerFactory.getLogger(WebMvcConfigurer.class);
    @Value("${spring.profiles.active}")
    private String env;//当前激活的配置文件
    
    //使用阿里 FastJson 作为JSON MessageConverter
    @SuppressWarnings("deprecation")
	@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(SerializerFeature.WriteMapNullValue);//保留空的字段
        //SerializerFeature.WriteNullStringAsEmpty,//String null -> ""
        //SerializerFeature.WriteNullNumberAsZero//Number null -> 0
        // 按需配置，更多参考FastJson文档哈

        converter.setFastJsonConfig(config);
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
        converters.add(converter);
    }


    //统一异常处理
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        exceptionResolvers.add(new HandlerExceptionResolver() {
            public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
//                Result result = new Result();
            		Map<String, Object> map = null;
                if (e instanceof ServiceException) {//业务失败的异常，如“账号或密码错误”
                	map = ResultTool.genFailResult(request, ResultCode.FAIL.code(), ResultCode.FAIL.msg());
                    logger.info(e.getMessage());
                } else if (e instanceof NoHandlerFoundException) {
                	map = ResultTool.genFailResult(request, ResultCode.NOT_FOUND.code(), "接口 ["+request.getRequestURI() + "] 不存在");
                } else if (e instanceof ServletException) {
                	map = ResultTool.genFailResult(request, ResultCode.FAIL.code(), e.getMessage());
                } else {
                	map = ResultTool.genFailResult(request, ResultCode.INTERNAL_SERVER_ERROR.code(), "接口 [" + request.getRequestURI() + "] 内部错误，请联系管理员");
                    String message;
                    if (handler instanceof HandlerMethod) {
                        HandlerMethod handlerMethod = (HandlerMethod) handler;
                        message = String.format("接口 [%s] 出现异常，方法：%s.%s，异常摘要：%s",
                                request.getRequestURI(),
                                handlerMethod.getBean().getClass().getName(),
                                handlerMethod.getMethod().getName(),
                                e.getMessage());
                    } else {
                        message = e.getMessage();
                    }
                    logger.error(message, e);
                }
                ServletHandTool.responseResult(response, map);
                return new ModelAndView();
            }

        });
    }

  

    //解决跨域问题
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	logger.info("注册拦截器");
    	registry.addInterceptor(new PMHandAdapter()).addPathPatterns("/api/**");
    }
    @Bean
    public FilterRegistrationBean<RequestBodyReaderFilter> Filters() {
    	FilterRegistrationBean<RequestBodyReaderFilter> registrationBean = new FilterRegistrationBean<RequestBodyReaderFilter>();
    	registrationBean.setFilter(new RequestBodyReaderFilter());
    	registrationBean.addUrlPatterns("/*");
    	registrationBean.setName("koalaSignFilter");
    	return registrationBean;
    }
}
