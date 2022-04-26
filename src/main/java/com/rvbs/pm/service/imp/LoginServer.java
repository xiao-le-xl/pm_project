package com.rvbs.pm.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rvbs.pm.core.AbstractService;
import com.rvbs.pm.core.BaseDefaultMapper;
import com.rvbs.pm.mapper.LoginMapper;
import com.rvbs.pm.model.login.LoginModel;
import com.rvbs.pm.service.interfaces.LoginInterface;


/**
 * 登录server层实现
 * @author xiaole
 *
 */
@Service
@Transactional
public class LoginServer extends AbstractService<LoginMapper, LoginModel> implements LoginInterface{

	@Override
	public LoginModel selectLoginModel(LoginModel model) {
		// TODO Auto-generated method stub
		return this.getBaseMapper().selectLoginModel(model);
	}

}
