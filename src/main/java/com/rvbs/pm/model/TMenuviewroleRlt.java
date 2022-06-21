package com.rvbs.pm.model;

import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import com.rvbs.pm.core.BaseBean;

import lombok.Data;

import javax.persistence.*;

@Table(name = "t_menuviewrole_rlt")
@Data
public class TMenuviewroleRlt extends BaseBean {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 角色编号
     */
    @MppMultiId
    @Column(name = "ROLEID")
    private String roleid;

    /**
     * 菜单视图编号
     */
    @MppMultiId
    @Column(name = "MENUVIEWNUM")
    private String menuviewnum;

    /**
     * 是否启用（默认为null未启用，1-启用，关闭需将该字段重新置为null）
     */
    @Column(name = "ENABLEFLAG")
    private String enableflag;

    @Override
	public String toString() {
		return "TMenuviewroleRlt [roleid=" + roleid + ", menuviewnum=" + menuviewnum + ", enableflag=" + enableflag
				+ ", remark1=" + remark1 + ", remark2=" + remark2 + ", remark3=" + remark3 + "]";
	}

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
     * 获取角色编号
     *
     * @return ROLEID - 角色编号
     */
    public String getRoleid() {
        return roleid;
    }

    /**
     * 设置角色编号
     *
     * @param roleid 角色编号
     */
    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    /**
     * 获取菜单视图编号
     *
     * @return MENUVIEWNUM - 菜单视图编号
     */
    public String getMenuviewnum() {
        return menuviewnum;
    }

    /**
     * 设置菜单视图编号
     *
     * @param menuviewnum 菜单视图编号
     */
    public void setMenuviewnum(String menuviewnum) {
        this.menuviewnum = menuviewnum;
    }

    /**
     * 获取是否启用（默认为null未启用，1-启用，关闭需将该字段重新置为null）
     *
     * @return ENABLEFLAG - 是否启用（默认为null未启用，1-启用，关闭需将该字段重新置为null）
     */
    public String getEnableflag() {
        return enableflag;
    }

    /**
     * 设置是否启用（默认为null未启用，1-启用，关闭需将该字段重新置为null）
     *
     * @param enableflag 是否启用（默认为null未启用，1-启用，关闭需将该字段重新置为null）
     */
    public void setEnableflag(String enableflag) {
        this.enableflag = enableflag;
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