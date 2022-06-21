package com.rvbs.pm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.rvbs.pm.core.BaseDefaultMapper;
import com.rvbs.pm.model.TMenuviewroleRlt;
import com.rvbs.pm.model.login.LoginModel;

public interface TMenuviewroleRltMapper extends BaseDefaultMapper<TMenuviewroleRlt> {
	
	
	@Select("select t.ROLEID,t.MENUVIEWNUM,t.ENABLEFLAG,i.MENUVIEWNAME,i.MENUNAME,i.MENUNUM,i.PARENTMENUNUM,i.ISVISIBLE from t_menuview_info i,t_menuviewrole_rlt t where i.MENUVIEWNUM=t.MENUVIEWNUM and t.ROLEID = #{roleid} and t.ENABLEFLAG = '1' and i.ISVISIBLE = '1'")
	List<Map<String, String>> findAllMenu(String roleid) ;
	
	@Select("update t_menuviewrole_rlt set ENABLEFLAG = '0' where ROLEID = #{roleid}")
	Boolean updateEnabelFlag(String roleid);
	
	
	
	
}