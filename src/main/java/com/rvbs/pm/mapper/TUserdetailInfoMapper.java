package com.rvbs.pm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.rvbs.pm.core.BaseDefaultMapper;
import com.rvbs.pm.model.TUserdetailInfo;
import com.rvbs.pm.model.UserInfo;

public interface TUserdetailInfoMapper extends BaseDefaultMapper<TUserdetailInfo> {
	
	
	@Select("select l.USERID ,d.USERNAME,l.ROLEID,l.LOGINSTATUS,l.RECENTLOGINTIME,l.USERSTATUS,d.LEVELCOMPY,d.DEPARTMENT,d.BANKOFEMPLOYEE,d.PROJECTGROUP,d.BANKUSERID,d.LEVELBANK,d.EDUCATIONINFO,d.PHOTOPATH FROM t_userlogin_info as l,t_userdetail_info as d where l.USERID =d.USERID limit #{page},#{count}")
	UserInfo selectUserInfo(UserInfo u ,int page,int count);
	
	
//	@SelectProvider(type = BeanDataUtil.class,method = "sql")
//	List<UserInfo> selectUserInfos(@Param("data")UserInfo data ,@Param("page")int page,@Param("size")int size,@Param("tables")String... tables);
//	@SelectProvider(type = UserInfo.class,method = "selectById()")
//	 public static String selectById() {
//	    return "SELECT id, name FROM users WHERE id = #{id}";
//	  }
	
}