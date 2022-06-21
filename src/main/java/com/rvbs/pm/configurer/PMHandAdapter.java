package com.rvbs.pm.configurer;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;
import com.rvbs.pm.core.ResultCode;
import com.rvbs.pm.tool.JwtsUtil;
import com.rvbs.pm.tool.ResultTool;
import com.rvbs.pm.tool.ServletHandTool;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class PMHandAdapter extends HandlerInterceptorAdapter{
	private final Logger logger = LoggerFactory.getLogger(PMHandAdapter.class);
	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("请求方式："+request.getMethod());
		// TODO Auto-generated method stub
		if("OPTIONS".equals(request.getMethod())) { // aiso通讯需要增加OPTIONS校验
			ServletHandTool.responseCorsResult(response, "OPTIONS");
			return false;
		}
		
		String token = request.getHeader("Authorization"); // 获取密钥
		
		
		if (StringUtils.isBlank(token)) {
			ServletHandTool.responseResult(response, ResultTool.genFailResult(request, ResultCode.AUTHORIZEDISNULL.code(), ResultCode.AUTHORIZEDISNULL.msg()));
			return false;
		}
		// 获取body数据
		Map<String, Object> body = (Map<String, Object>)JSON.parse(ServletHandTool.getBody(request));
		String uid = ((Map<String, String>)body.get("app_head")).get("userId"); // 请求数据：用户id
		Map<String, Object> tokenMap = null;
		try {
			tokenMap = JwtsUtil.unSign(token.replaceFirst("Bearer", "")); // 解密token
			if (tokenMap == null || StringUtils.isBlank((String) tokenMap.get("userId"))) {
				ServletHandTool.responseResult(response, ResultTool.genFailResult(request, ResultCode.AUTHORIZEDISERROR.code(), ResultCode.AUTHORIZEDISERROR.msg()));
				return false;
			}else if(!((String) tokenMap.get("userId")).equals(uid)) {
				logger.error(ServletHandTool.getBody(request));
				ServletHandTool.responseResult(response, ResultTool.genFailResult(request, ResultCode.AUTHORIZEDISNULL.code(), ResultCode.AUTHORIZEDISNULL.msg()));
				return false;
			}
		} catch (Exception e) {
			logger.error("解密token异常：",e);
			ServletHandTool.responseResult(response, ResultTool.genFailResult(request, ResultCode.AUTHORIZEDISNULL.code(), ResultCode.AUTHORIZEDISNULL.msg()));
			return false;
		}
		return true;
	}
}
