package com.rvbs.pm.model;

import javax.persistence.Column;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.rvbs.pm.core.FieldColumn;

public class UserInfo {
	
	

	@TableId
	@Column(name = "USERID")
	private String userid;
	
	@Column(name = "PASSWD")
	private String passwd;
	
	
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "ROLEID")
	private String roleid;
	
//	@Column(name = "LOGINSTATUS")
	@FieldColumn(name = "LOGINSTATUS",fieldTableName = "t_userlogin_info")
	private String loginstatus;
	
	@Column(name = "RECENTLOGINTIME")
	private String recentlogintime;
	
	@Column(name = "USERSTATUS")
	private String userstatus;
	
	@Column(name = "LEVELCOMPY")
	private String levelcompy;
	
	@Column(name = "DEPARTMENT")
	private String department;
	
	@Column(name = "BANKOFEMPLOYEE")
	private String bankofemployee;
	
	@Column(name = "PROJECTGROUP")
	private String projectgroup;
	
	@Column(name = "INITPWDFLAG")
	private String initpwdflag;
	
	@Column(name = "BANKUSERID")
	private String bankuserid;
	
	@Column(name = "LEVELBANK")
	private String levelbank;
	
	@Column(name = "EDUCATIONINFO")
	private String educationinfo;
	
	@Column(name = "PHOTOPATH")
	private String photopath;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPasswd() {
		return passwd;
	}

	public String getInitpwdflag() {
		return initpwdflag;
	}

	public void setInitpwdflag(String initpwdflag) {
		this.initpwdflag = initpwdflag;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getLoginstatus() {
		return loginstatus;
	}
	
	
	

	public void setLoginstatus(String loginstatus) {
		this.loginstatus = loginstatus;
	}

	public String getRecentlogintime() {
		return recentlogintime;
	}

	public void setRecentlogintime(String recentlogintime) {
		this.recentlogintime = recentlogintime;
	}

	public String getUserstatus() {
		return userstatus;
	}

	public void setUserstatus(String userstatus) {
		this.userstatus = userstatus;
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

	public String getLevelbank() {
		return levelbank;
	}

	public void setLevelbank(String levelbank) {
		this.levelbank = levelbank;
	}

	public String getEducationinfo() {
		return educationinfo;
	}

	public void setEducationinfo(String educationinfo) {
		this.educationinfo = educationinfo;
	}

	public String getPhotopath() {
		return photopath;
	}

	public void setPhotopath(String photopath) {
		this.photopath = photopath;
	}
	
	
	

}
