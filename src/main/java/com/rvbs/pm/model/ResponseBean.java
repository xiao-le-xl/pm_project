package com.rvbs.pm.model;

import com.rvbs.pm.core.BaseBean;
import com.rvbs.pm.core.HeadBaseBean;

/**
 * 响应对象
 * @author xiaole
 *
 * @param <T> 实际对象
 */
public class ResponseBean<T> extends HeadBaseBean<AppHead, SysHead>{

	/** 序列号 */
	private static final long serialVersionUID = 1L;
	/** 系统体 */
	private T body;
	
	public T getBody() {
		return body;
	}
	public ResponseBean<T> setBody(T body) {
		this.body = body;
		return this;
	}
}
