package com.rvbs.pm.model;

import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import com.rvbs.pm.core.BaseBean;
import javax.persistence.*;

@Table(name = "t_menuview_info")
public class TMenuviewInfo extends BaseBean {
    /**
     * 菜单视图编号(自增)
     */
    @MppMultiId
    @Column(name = "MENUVIEWNUM")
    private Integer menuviewnum;

    /**
     * 菜单编号
     */
    @MppMultiId
    @Column(name = "MENUNUM")
    private String menunum;

    /**
     * 菜单视图名称
     */
    @Column(name = "MENUVIEWNAME")
    private String menuviewname;

    /**
     * 菜单名称
     */
    @Column(name = "MENUNAME")
    private String menuname;

    /**
     * 父菜单编号（如无则为0）
     */
    @Column(name = "PARENTMENUNUM")
    private String parentmenunum;

    /**
     * 是否可见（0-不可见，1-可见）
     */
    @Column(name = "ISVISIBLE")
    private String isvisible;

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
     * 获取菜单视图编号(自增)
     *
     * @return MENUVIEWNUM - 菜单视图编号(自增)
     */
    public Integer getMenuviewnum() {
        return menuviewnum;
    }

    /**
     * 设置菜单视图编号(自增)
     *
     * @param menuviewnum 菜单视图编号(自增)
     */
    public void setMenuviewnum(Integer menuviewnum) {
        this.menuviewnum = menuviewnum;
    }

    /**
     * 获取菜单编号
     *
     * @return MENUNUM - 菜单编号
     */
    public String getMenunum() {
        return menunum;
    }

    /**
     * 设置菜单编号
     *
     * @param menunum 菜单编号
     */
    public void setMenunum(String menunum) {
        this.menunum = menunum;
    }

    /**
     * 获取菜单视图名称
     *
     * @return MENUVIEWNAME - 菜单视图名称
     */
    public String getMenuviewname() {
        return menuviewname;
    }

    /**
     * 设置菜单视图名称
     *
     * @param menuviewname 菜单视图名称
     */
    public void setMenuviewname(String menuviewname) {
        this.menuviewname = menuviewname;
    }

    /**
     * 获取菜单名称
     *
     * @return MENUNAME - 菜单名称
     */
    public String getMenuname() {
        return menuname;
    }

    /**
     * 设置菜单名称
     *
     * @param menuname 菜单名称
     */
    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    /**
     * 获取父菜单编号（如无则为0）
     *
     * @return PARENTMENUNUM - 父菜单编号（如无则为0）
     */
    public String getParentmenunum() {
        return parentmenunum;
    }

    /**
     * 设置父菜单编号（如无则为0）
     *
     * @param parentmenunum 父菜单编号（如无则为0）
     */
    public void setParentmenunum(String parentmenunum) {
        this.parentmenunum = parentmenunum;
    }

    /**
     * 获取是否可见（0-不可见，1-可见）
     *
     * @return ISVISIBLE - 是否可见（0-不可见，1-可见）
     */
    public String getIsvisible() {
        return isvisible;
    }

    /**
     * 设置是否可见（0-不可见，1-可见）
     *
     * @param isvisible 是否可见（0-不可见，1-可见）
     */
    public void setIsvisible(String isvisible) {
        this.isvisible = isvisible;
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