package com.rvbs.pm.model;

import com.rvbs.pm.core.BaseBean;
import com.rvbs.pm.core.HeadBaseBean;

/**
 * 请求信息
 * @author xiaole
 *
 * @param <T> 实际对象
 */
public class RequestBean<T> extends HeadBaseBean<AppHead, SysHead>{
	/**  序列号 */
	private static final long serialVersionUID = 1L;
	/** 系统体 */
	private T body;
	
	public T getBody() {
		return body;
	}
	public void setBody(T body) {
		this.body = body;
	}
	
}
