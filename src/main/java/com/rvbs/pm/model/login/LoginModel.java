package com.rvbs.pm.model.login;

import javax.persistence.Id;

import com.rvbs.pm.core.BaseBean;

/**
 * 登录Bean
 * @author xiaole
 *
 */
public class LoginModel extends BaseBean{
	/** 序列号 */
	private static final long serialVersionUID = 1L;
	
	
	@Id /** 用户ID*/
	private String userId; 
	/** 用户密码 */
	private String passWd;
	/** 用户角色 */
	private String roleId;
	/** 登录状态 */
	private String loginStatus;
	/** 登录时间 */
	private String recentLoginTime;
	/** 用户名称 */
	private String username;
	/** 公司等级 */
	private String levelcompy;
	/** 部门 */
	private String department;
	/** 员工所属银行 */
	private String bankofemployee;
	/** 项目组 */
	private String projectgroup;
	/** 银行用户号 */
	private String bankuserid;
	/** token */
	private String token;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassWd() {
		return passWd;
	}
	public void setPassWd(String passWd) {
		this.passWd = passWd;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
	public String getRecentLoginTime() {
		return recentLoginTime;
	}
	public void setRecentLoginTime(String recentLoginTime) {
		this.recentLoginTime = recentLoginTime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLevelcompy() {
		return levelcompy;
	}
	public void setLevelcompy(String levelcompy) {
		this.levelcompy = levelcompy;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getBankofemployee() {
		return bankofemployee;
	}
	public void setBankofemployee(String bankofemployee) {
		this.bankofemployee = bankofemployee;
	}
	public String getProjectgroup() {
		return projectgroup;
	}
	public void setProjectgroup(String projectgroup) {
		this.projectgroup = projectgroup;
	}
	public String getBankuserid() {
		return bankuserid;
	}
	public void setBankuserid(String bankuserid) {
		this.bankuserid = bankuserid;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
