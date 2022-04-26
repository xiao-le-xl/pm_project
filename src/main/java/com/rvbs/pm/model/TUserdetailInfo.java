package com.rvbs.pm.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.rvbs.pm.core.BaseBean;
import javax.persistence.*;

@Table(name = "t_userdetail_info")
public class TUserdetailInfo extends BaseBean {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 员工工号(公司工号)
     */
	@TableId
    @Column(name = "USERID")
    private String userid;

    /**
     * 员工姓名
     */
    @Column(name = "USERNAME")
    private String username;

    /**
     * 员工在公司的级别
     */
    @Column(name = "LEVELCOMPY")
    private String levelcompy;

    /**
     * 所属部门
     */
    @Column(name = "DEPARTMENT")
    private String department;

    /**
     * 员工所属银行
     */
    @Column(name = "BANKOFEMPLOYEE")
    private String bankofemployee;

    /**
     * 员工所属项目组
     */
    @Column(name = "PROJECTGROUP")
    private String projectgroup;

    /**
     * 员工银行工号
     */
    @Column(name = "BANKUSERID")
    private String bankuserid;

    /**
     * 人员在银行的级别
     */
    @Column(name = "LEVELBANK")
    private String levelbank;

    @Override
	public String toString() {
		return "TUserdetailInfo [userid=" + userid + ", username=" + username + ", levelcompy=" + levelcompy
				+ ", department=" + department + ", bankofemployee=" + bankofemployee + ", projectgroup=" + projectgroup
				+ ", bankuserid=" + bankuserid + ", levelbank=" + levelbank + ", educationinfo=" + educationinfo
				+ ", photopath=" + photopath + ", remark1=" + remark1 + ", remark2=" + remark2 + ", remark3=" + remark3
				+ "]";
	}

	/**
     * 学历信息
     */
    @Column(name = "EDUCATIONINFO")
    private String educationinfo;

    /**
     * 个人主页照片路径
     */
    @Column(name = "PHOTOPATH")
    private String photopath;

    /**
     * 备用字段1
     */
    @Column(name = "REMARK1")
    private String remark1;

    /**
     * 备用字段2
     */
    @Column(name = "REMARK2")
    private String remark2;

    /**
     * 备用字段3
     */
    @Column(name = "REMARK3")
    private String remark3;

    /**
     * 获取员工工号(公司工号)
     *
     * @return USERID - 员工工号(公司工号)
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置员工工号(公司工号)
     *
     * @param userid 员工工号(公司工号)
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 获取员工姓名
     *
     * @return USERNAME - 员工姓名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置员工姓名
     *
     * @param username 员工姓名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取员工在公司的级别
     *
     * @return LEVELCOMPY - 员工在公司的级别
     */
    public String getLevelcompy() {
        return levelcompy;
    }

    /**
     * 设置员工在公司的级别
     *
     * @param levelcompy 员工在公司的级别
     */
    public void setLevelcompy(String levelcompy) {
        this.levelcompy = levelcompy;
    }

    /**
     * 获取所属部门
     *
     * @return DEPARTMENT - 所属部门
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 设置所属部门
     *
     * @param department 所属部门
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * 获取员工所属银行
     *
     * @return BANKOFEMPLOYEE - 员工所属银行
     */
    public String getBankofemployee() {
        return bankofemployee;
    }

    /**
     * 设置员工所属银行
     *
     * @param bankofemployee 员工所属银行
     */
    public void setBankofemployee(String bankofemployee) {
        this.bankofemployee = bankofemployee;
    }

    /**
     * 获取员工所属项目组
     *
     * @return PROJECTGROUP - 员工所属项目组
     */
    public String getProjectgroup() {
        return projectgroup;
    }

    /**
     * 设置员工所属项目组
     *
     * @param projectgroup 员工所属项目组
     */
    public void setProjectgroup(String projectgroup) {
        this.projectgroup = projectgroup;
    }

    /**
     * 获取员工银行工号
     *
     * @return BANKUSERID - 员工银行工号
     */
    public String getBankuserid() {
        return bankuserid;
    }

    /**
     * 设置员工银行工号
     *
     * @param bankuserid 员工银行工号
     */
    public void setBankuserid(String bankuserid) {
        this.bankuserid = bankuserid;
    }

    /**
     * 获取人员在银行的级别
     *
     * @return LEVELBANK - 人员在银行的级别
     */
    public String getLevelbank() {
        return levelbank;
    }

    /**
     * 设置人员在银行的级别
     *
     * @param levelbank 人员在银行的级别
     */
    public void setLevelbank(String levelbank) {
        this.levelbank = levelbank;
    }

    /**
     * 获取学历信息
     *
     * @return EDUCATIONINFO - 学历信息
     */
    public String getEducationinfo() {
        return educationinfo;
    }

    /**
     * 设置学历信息
     *
     * @param educationinfo 学历信息
     */
    public void setEducationinfo(String educationinfo) {
        this.educationinfo = educationinfo;
    }

    /**
     * 获取个人主页照片路径
     *
     * @return PHOTOPATH - 个人主页照片路径
     */
    public String getPhotopath() {
        return photopath;
    }

    /**
     * 设置个人主页照片路径
     *
     * @param photopath 个人主页照片路径
     */
    public void setPhotopath(String photopath) {
        this.photopath = photopath;
    }

    /**
     * 获取备用字段1
     *
     * @return REMARK1 - 备用字段1
     */
    public String getRemark1() {
        return remark1;
    }

    /**
     * 设置备用字段1
     *
     * @param remark1 备用字段1
     */
    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    /**
     * 获取备用字段2
     *
     * @return REMARK2 - 备用字段2
     */
    public String getRemark2() {
        return remark2;
    }

    /**
     * 设置备用字段2
     *
     * @param remark2 备用字段2
     */
    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    /**
     * 获取备用字段3
     *
     * @return REMARK3 - 备用字段3
     */
    public String getRemark3() {
        return remark3;
    }

    /**
     * 设置备用字段3
     *
     * @param remark3 备用字段3
     */
    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }
}