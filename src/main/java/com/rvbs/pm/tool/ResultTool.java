package com.rvbs.pm.tool;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.rvbs.pm.core.ResultCode;
import com.rvbs.pm.model.RequestBean;
import com.rvbs.pm.model.ResponseBean;

public class ResultTool {
	
	
	/**
	 *	只返回默认成功，不返回具体body对象
	 * @param <T> 实际请求对象
	 * @param <K> 实际响应对象
	 * @param reqestBean 请求数据
	 * @return 返回响应对象
	 */
    public static <T,K> ResponseBean<K> genSuccessResult(RequestBean<T> reqestBean) {
        return genSuccessResult(reqestBean,null);
    }
    
    /**
	 *	使用默认成功码，返回具体body对象
	 * @param <T> 实际请求对象
	 * @param <K> 实际响应对象
	 * @param reqestBean 请求对象
	 * @param body 响应对象
	 * @return 返回响应对象
	 */
    public static <T,K> ResponseBean<K> genSuccessResult(RequestBean<T> reqestBean,K body) {
    	ResponseBean<K> bean = new ResponseBean<K>();
    	bean.setSys_head(reqestBean.getSys_head());
    	bean.setApp_head(reqestBean.getApp_head());
    	bean.setBody(body);
    	bean.getSys_head().setReturnCode(ResultCode.SUCCESS.code()).setReturnMsg(ResultCode.SUCCESS.msg());
    	bean.getSys_head().setRequestData(DateUtil.currentDate(DateUtil.yyyyMMdd));
    	bean.getSys_head().setRequestTime(DateUtil.currentDate(DateUtil.HHmmss));
    	return bean;
    }
    
    
    /**
	 *	使用默认失败码，不返回失败body对象
	 * @param <T> 实际请求对象
	 * @param <K> 实际响应对象
	 * @param reqestBean 请求对象
	 * @return 返回响应对象
	 */
    public static <T,K> ResponseBean<K> genFailResult(RequestBean<T> reqestBean) {
    	return genFailResult(reqestBean, ResultCode.FAIL.code(), ResultCode.FAIL.msg());
    }
	
    /**
	 *	使用自定义错误码，不返回失败body对象
	 * @param <T> 实际请求对象
	 * @param <K> 实际响应对象
	 * @param reqestBean 请求对象
	 * @param returnCode 错误码
	 * @param returnMsg 错误信息
	 * @return 返回响应对象
	 */
    public static <T,K> ResponseBean<K> genFailResult(RequestBean<T> reqestBean,String returnCode,String returnMsg) {
    	return genFailResult(reqestBean, null, returnCode, returnMsg);
    }
    
    /**
	 *	使用自定义错误码，返回失败body对象
	 * @param <T> 实际请求对象
	 * @param <K> 实际响应对象
	 * @param reqestBean 请求对象
	 * @param body 响应对象
	 * @param returnCode 错误码
	 * @param returnMsg 错误信息
	 * @return 返回响应对象
	 */
    public static <T,K> ResponseBean<K> genFailResult(RequestBean<T> reqestBean,K body,String returnCode,String returnMsg) {
    	ResponseBean<K> bean = new ResponseBean<K>();
    	bean.setSys_head(reqestBean.getSys_head());
    	bean.setApp_head(reqestBean.getApp_head());
    	bean.getSys_head().setReturnCode(returnCode).setReturnMsg(returnMsg);
    	bean.setBody(body);
    	bean.getSys_head().setRequestData(DateUtil.currentDate(DateUtil.yyyyMMdd));
    	bean.getSys_head().setRequestTime(DateUtil.currentDate(DateUtil.HHmmss));
    	return bean;
    }

    /**
     * 	通过request对象获取body数据，并设置自定义错误信息
     * @param request 请求数据
     * @param returnCode 错误码
     * @param returnMsg 错误信息
     * @return 响应数据
     */
    @SuppressWarnings("unchecked")
	public static Map<String, Object> genFailResult(HttpServletRequest request, String returnCode,String returnMsg){
    	Map<String, Object> map = (Map<String, Object>)JSON.parse(ServletHandTool.getBody(request));
    	((Map<String,String>)map.get("sys_head")).put("returnCode", returnCode);
    	((Map<String,String>)map.get("sys_head")).put("returnMsg", returnMsg);
    	((Map<String,String>)map.get("sys_head")).put("requestTime", DateUtil.currentDate(DateUtil.HHmmss));
    	map.put("body", new Object());
    	return map;
    }
}
