package com.rvbs.pm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.rvbs.pm.core.BaseDefaultMapper;
import com.rvbs.pm.model.login.LoginModel;
/**
 *  登录数据操作类
 * @author xiaole
 *
 */
@Mapper
public interface LoginMapper extends BaseDefaultMapper<LoginModel>{
	
	
	@Select("select a.USERID,a.LOGINSTATUS,a.ROLEID,b.BANKOFEMPLOYEE,b.USERNAME,b.BANKUSERID,b.DEPARTMENT,b.EDUCATIONINFO,b.LEVELBANK,b.LEVELCOMPY,b.PHOTOPATH,b.PROJECTGROUP " + 
			" from t_userlogin_info a,t_userdetail_info b where a.USERID = b.USERID and a.USERID = #{loginModel.userId} and a.PASSWD = #{loginModel.passWd} ")
	LoginModel selectLoginModel(@Param("loginModel")LoginModel loginModel) ;
	
	
}
