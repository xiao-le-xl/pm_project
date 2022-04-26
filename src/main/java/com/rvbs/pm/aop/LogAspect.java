package com.rvbs.pm.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.rvbs.pm.tool.ServletHandTool;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class  LogAspect {
	private final Logger log = LoggerFactory.getLogger(LogAspect.class);
	
	 @Pointcut("execution(public * com.rvbs.pm.web.*.*(..))")
	    public void log() {}
	 @Before("log()")
	    public void doBefore(JoinPoint joinPoint){
	        // 接收到请求，记录请求内容
	        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	        HttpServletRequest request = attributes.getRequest();
	        // 记录下请求内容
	        log.info("《*****************请求内容*****************************》");
	        log.info("请求地址Url : " + request.getRequestURL().toString());
	        log.info("请求方法Method : " + request.getMethod());
	        log.info("客户端IP : " + request.getRemoteAddr());
	        log.info("客户端IPHost : " + request.getRemoteHost());
	        log.info("jar包对象 : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
	        log.info("参数 : " + ServletHandTool.getBody(request));
	    }
	 @AfterReturning(returning = "ret", pointcut = "log()")
	    public void doAfterReturning(Object ret){
	        // 处理完请求，返回内容
	        log.info("返回内容 : " + JSON.toJSONString(ret));
	        log.info("《*****************返回内容*****************************》");
	    }
}
