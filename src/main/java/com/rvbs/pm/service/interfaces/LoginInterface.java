package com.rvbs.pm.service.interfaces;

import com.rvbs.pm.core.Service;
import com.rvbs.pm.model.login.LoginModel;

/**
 * 登录服务接口
 * @author xiaole
 *
 */
public interface LoginInterface extends Service<LoginModel>{
	
	/** 查询登录用户 */
	LoginModel selectLoginModel(LoginModel model);
	
}
