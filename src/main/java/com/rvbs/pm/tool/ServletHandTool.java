package com.rvbs.pm.tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.rvbs.pm.core.ResultCode;

import lombok.extern.slf4j.Slf4j;

/**
 * 	通讯处理类
 * @author xiaole
 *
 */
@Slf4j
public class ServletHandTool {
	/** 日志对象 */
	private final static Logger logger = LoggerFactory.getLogger(ServletHandTool.class);
	/**
     * 	获取body对象
     * @param request 请求对象
     * @return
     */
    public static String getBody(HttpServletRequest request) {
    	String body = (String)request.getAttribute("request_body");
    	if(StringUtils.isNotBlank(body)) {
    		return body;
    	}
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		String line = null;
        try {
        	InputStreamReader inputStreamReader = new InputStreamReader(request.getInputStream(), "UTF-8");
            br = new BufferedReader(inputStreamReader);
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            request.setAttribute("request_body", sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
		}
        return (String)request.getAttribute("request_body");
        
	}
    
    
    /**
	 * 	返回响应数据
	 * @param <T>
	 * @param response 响应对象
	 * @param result 结果
	 */
	public static <T> void  responseResult(HttpServletResponse response, T result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json; charset=UTF-8");
        response.setStatus(Integer.parseInt(ResultCode.CONNECT.code()));
        try {
            response.getWriter().write(JSON.toJSONString(result));
        } catch (IOException ex) {
            logger.error("写入响应数据异常：",ex.getMessage());
        }
    }
	
	/**
	 * 解决aiso通讯需要增加OPTIONS校验
	 * @param <T>
	 * @param response 响应对象
	 * @param result 结果
	 */
	public static <T> void responseCorsResult(HttpServletResponse response, T result) {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "application/json; charset=UTF-8");
		response.setStatus(Integer.parseInt(ResultCode.CONNECT.code()));
		response.setHeader("Access-Control-Allow-Origin", "*"); // 响应所有域访问
		response.setHeader("Access-Control-Allow-Headers", "*"); // 响应所有头 请求类型
		response.setHeader("Access-Control-Allow-Methods", "*"); // 响应所有请求方法
		response.setHeader("Access-Control-Allow-Credentials", "true"); // 是否支持Cookie
		try {
			response.getWriter().write(JSON.toJSONString(result)); // 返回数据
		} catch (IOException ex) {
			logger.error("写入响应数据异常：", ex.getMessage());
		}
	}
	
}
