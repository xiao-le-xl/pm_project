package com.rvbs.pm.core;

/**
 *	头部数据Bean封装
 * @author xiaole
 * @param <A> 应用头
 * @param <S> 系统头
 */
public abstract class HeadBaseBean<A,S> extends BaseBean{
	/** 序列号 */
	private static final long serialVersionUID = 1L;
	/** 应用头 */
	private A app_head;
	/** 系统头 */
	private S sys_head;
	
	public A getApp_head() {
		return app_head;
	}
	public void setApp_head(A app_head) {
		this.app_head = app_head;
	}
	public S getSys_head() {
		return sys_head;
	}
	public void setSys_head(S sys_head) {
		this.sys_head = sys_head;
	}
	
}
