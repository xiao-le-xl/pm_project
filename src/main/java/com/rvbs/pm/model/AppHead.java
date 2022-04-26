package com.rvbs.pm.model;
/**
 * 应用头信息
 * @author xiaole
 *
 */
public class AppHead {
	/** 用户ID */
	private String userId;
	/** 角色ID */
	private String roleId;
	/** 页数 */
	private String pageNum;
	/** 每页查询数 */
	private String pageSize;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	
	
}
