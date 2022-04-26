package com.rvbs.pm.model;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.rvbs.pm.core.BaseBean;

public class HeadModel extends BaseBean{
	@ExcelIgnore
	private static final long serialVersionUID = 1L;
//	@Column(name = "userName")
	@ExcelProperty(value="用户id",index = 0)
	private String userId;
//	@Column(name = "userId")
	@ExcelProperty(value="密码",index = 1)
	private String passWd;
	@ExcelProperty(value="角色id",index = 2)
	private String roleId;
}
