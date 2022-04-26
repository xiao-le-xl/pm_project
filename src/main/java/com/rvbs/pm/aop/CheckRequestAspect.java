package com.rvbs.pm.aop;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.rvbs.pm.tool.ResultTool;
import com.rvbs.pm.tool.ServletHandTool;

//@Aspect
//@Component
//@Slf4j
public class CheckRequestAspect {
	private final Logger logger = LoggerFactory.getLogger(CheckRequestAspect.class);
	@Resource
//	private InterfaceService mapper;
	
	@Pointcut("execution(public * com.rvbs.pm.web..*.*(..))")
	public void checkRequest() {}
	
	@Around("checkRequest()")
    public void checkAround(ProceedingJoinPoint joinPoint){
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		// 获取request对象
		HttpServletRequest request = attributes.getRequest();
		// 获取response对象
		HttpServletResponse response = attributes.getResponse();
		
		try {
			checkServerCodeIsNull(request, response, joinPoint);
			checkFieldMust(request, response, joinPoint);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			logger.error("checkAround终止出现异常：",e);
			
		}
		
    }
	
	@SuppressWarnings("unchecked")
	/**
	 * 校验服务码是否必输
	 * @param request
	 * @param response
	 * @param joinPoint
	 * @throws Throwable
	 */
	private void checkServerCodeIsNull(HttpServletRequest request,HttpServletResponse response,ProceedingJoinPoint joinPoint) throws Throwable {
		// 请求体数据
        Map<String, Object> json =  (Map<String, Object>)JSON.parse(ServletHandTool.getBody(request));
        // 系统头数据
        Map<String, String> sysHead = (Map<String, String>)json.get("sys_head");
    	if(StringUtils.isBlank(sysHead.get("serviceCode"))) { // 校验服务码是否上送
    		ServletHandTool.responseResult(response, ResultTool.genFailResult(request, "SYS001","服务码未上送"));
        	joinPoint.proceed();
        }
        
	}
	
	@SuppressWarnings("unchecked")
	/**
	 * 校验字段是否必输
	 * @param request
	 * @param response
	 * @param joinPoint
	 * @throws Throwable
	 */
	private void checkFieldMust(HttpServletRequest request,HttpServletResponse response,ProceedingJoinPoint joinPoint) throws Throwable {
		// 请求体数据
		Map<String, Object> json =  (Map<String, Object>)JSON.parse(ServletHandTool.getBody(request));
        // 系统头数据
        Map<String, String> body = (Map<String, String>)json.get("body");
//		InterfaceModel model = new InterfaceModel();
//		model.setServiceCode("user");
//		
//		List<InterfaceModel> list = mapper.list();
//		
//		if(list == null || list.isEmpty()) { // 校验服务码是否上送
//    		ServletHandTool.responseResult(response, ResultTool.genFailResult(request, "SYS001","服务码未上送"));
//        	joinPoint.proceed();
//        }
//		for (InterfaceModel interfaceModel : list) {
//			if("Y".equals(interfaceModel.getColmust())) {
//				if(StringUtils.isBlank(body.get(interfaceModel.getColName()))) {
//					ServletHandTool.responseResult(response, ResultTool.genFailResult(request, "SYS001",String.format("字段名[{}]必输", interfaceModel.getColName())));
//		        	joinPoint.proceed();
//				}
//			}
//		}
	}
}
