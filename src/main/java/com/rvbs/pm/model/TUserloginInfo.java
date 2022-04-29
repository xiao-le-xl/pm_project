package com.rvbs.pm.model;

import com.rvbs.pm.core.BaseBean;
import javax.persistence.*;

@Table(name = "t_userlogin_info")
public class TUserloginInfo extends BaseBean {
    /**
     * 工号(公司工号)
     */
    @Id
    @Column(name = "USERID")
    private String userid;

    /**
     * 用户登录密码
     */
    @Column(name = "PASSWD")
    private String passwd;

    /**
     * 用户角色id(01系统管理员,02总监,03项目经理,04普通员工)
     */
    @Column(name = "ROLEID")
    private String roleid;

    /**
     * 用户登录状态 0-离线 1-在线
     */
    @Column(name = "LOGINSTATUS")
    private String loginstatus;

    /**
     * 用户最近一次登入时间yyyyMMddhhmmss
     */
    @Column(name = "RECENTLOGINTIME")
    private String recentlogintime;

    /**
     * 用户状态:N-正常，L-注销，LK-锁定，H-休假
     */
    @Column(name = "USERSTATUS")
    private String userstatus;

    /**
     * 初始密码标识：0-是，1-否
     */
    @Column(name = "INITPWDFLAG")
    private String initpwdflag;

    /**
     * 初始密码标识：0-是，1-否
     */
    @Column(name = "NUMMISPPWD")
    private String nummisppwd;

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
     * 获取工号(公司工号)
     *
     * @return USERID - 工号(公司工号)
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置工号(公司工号)
     *
     * @param userid 工号(公司工号)
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 获取用户登录密码
     *
     * @return PASSWD - 用户登录密码
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * 设置用户登录密码
     *
     * @param passwd 用户登录密码
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     * 获取用户角色id(01系统管理员,02总监,03项目经理,04普通员工)
     *
     * @return ROLEID - 用户角色id(01系统管理员,02总监,03项目经理,04普通员工)
     */
    public String getRoleid() {
        return roleid;
    }

    /**
     * 设置用户角色id(01系统管理员,02总监,03项目经理,04普通员工)
     *
     * @param roleid 用户角色id(01系统管理员,02总监,03项目经理,04普通员工)
     */
    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    /**
     * 获取用户登录状态 0-离线 1-在线
     *
     * @return LOGINSTATUS - 用户登录状态 0-离线 1-在线
     */
    public String getLoginstatus() {
        return loginstatus;
    }

    /**
     * 设置用户登录状态 0-离线 1-在线
     *
     * @param loginstatus 用户登录状态 0-离线 1-在线
     */
    public void setLoginstatus(String loginstatus) {
        this.loginstatus = loginstatus;
    }

    /**
     * 获取用户最近一次登入时间yyyyMMddhhmmss
     *
     * @return RECENTLOGINTIME - 用户最近一次登入时间yyyyMMddhhmmss
     */
    public String getRecentlogintime() {
        return recentlogintime;
    }

    /**
     * 设置用户最近一次登入时间yyyyMMddhhmmss
     *
     * @param recentlogintime 用户最近一次登入时间yyyyMMddhhmmss
     */
    public void setRecentlogintime(String recentlogintime) {
        this.recentlogintime = recentlogintime;
    }

    /**
     * 获取用户状态:N-正常，L-注销，LK-锁定，H-休假
     *
     * @return USERSTATUS - 用户状态:N-正常，L-注销，LK-锁定，H-休假
     */
    public String getUserstatus() {
        return userstatus;
    }

    /**
     * 设置用户状态:N-正常，L-注销，LK-锁定，H-休假
     *
     * @param userstatus 用户状态:N-正常，L-注销，LK-锁定，H-休假
     */
    public void setUserstatus(String userstatus) {
        this.userstatus = userstatus;
    }

    /**
     * 获取初始密码标识：0-是，1-否
     *
     * @return INITPWDFLAG - 初始密码标识：0-是，1-否
     */
    public String getInitpwdflag() {
        return initpwdflag;
    }

    /**
     * 设置初始密码标识：0-是，1-否
     *
     * @param initpwdflag 初始密码标识：0-是，1-否
     */
    public void setInitpwdflag(String initpwdflag) {
        this.initpwdflag = initpwdflag;
    }

    /**
     * 获取初始密码标识：0-是，1-否
     *
     * @return NUMMISPPWD - 初始密码标识：0-是，1-否
     */
    public String getNummisppwd() {
        return nummisppwd;
    }

    /**
     * 设置初始密码标识：0-是，1-否
     *
     * @param nummisppwd 初始密码标识：0-是，1-否
     */
    public void setNummisppwd(String nummisppwd) {
        this.nummisppwd = nummisppwd;
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