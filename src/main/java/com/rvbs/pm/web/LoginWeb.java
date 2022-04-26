package com.rvbs.pm.web;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rvbs.pm.model.RequestBean;
import com.rvbs.pm.model.ResponseBean;
//import com.rvbs.pm.model.UserInfo;
import com.rvbs.pm.model.login.LoginModel;
import com.rvbs.pm.service.interfaces.LoginInterface;
import com.rvbs.pm.tool.JwtsUtil;
import com.rvbs.pm.tool.ResultTool;

/**
 * 用户登录
 * @author xiaole
 *
 */
@RestController
@RequestMapping("/user")
public class LoginWeb {
	@Autowired
	private LoginInterface loginInterface;
	
//	@Autowired
//	private UserinfoInterface userInterface;
	
	private final Long MAX_TIME = 3600_000L;
	
	@PostMapping("/login")
	public ResponseBean<LoginModel> login(@RequestBody RequestBean<LoginModel> request){
		// 判断用户名或密码是否为空
		if(StringUtils.isBlank(request.getBody().getPassWd()) || StringUtils.isBlank(request.getBody().getUserId())) {
			return ResultTool.genFailResult(request,"Us001","用户id或密码为空，登录失败!");
		}
		// 查询登录信息
//		LoginModel loginModel = loginInterface.getById(request.getBody().getUserId());
		LoginModel loginModel = loginInterface.selectLoginModel(request.getBody());
		if(loginModel == null) { // 如登录信息为空，则为用户名或密码错误
			return ResultTool.genFailResult(request,loginModel,"Us002","密码错误登录失败!");
		}
		
		// 获取token数据，并赋予返回对象中
		loginModel.setToken(getToken(loginModel.getUserId(), "普通员工")); 
		
		// 更新用户状态以及登录时间
		boolean result = updateLoginStatus(loginModel); // 注明：在此还可以登记失败次数等操作,后续可以考虑是否追加
		if(result) { // 更新成功
			ResponseBean<LoginModel> resBean = ResultTool.genSuccessResult(request,loginModel);
			resBean.getApp_head().setRoleId(loginModel.getRoleId());
			return resBean;
		}else {
			return ResultTool.genFailResult(request,loginModel,"Us003","更新用户状态失败，请联系管理员或重新登录!");
		}
	}
	
	/**
	 * 获取token
	 * @param userId 用户ID
	 * @param userName 用户名称
	 * @return token
	 */
	private String getToken(String userId, String userName) {
		Map<String, Object> tokenMap = new HashMap<String,Object>();
		tokenMap.put("userId", userId);
		tokenMap.put("userName", userName);
		return JwtsUtil.getToken(tokenMap,userId,userName, MAX_TIME);
	}
	
	/**
	 * 更新用户状态
	 * @return
	 */
	public boolean updateLoginStatus(LoginModel loginModel) {
//		UserInfo userInfo = new UserInfo();
//		String time = DateUtil.currentDate(DateUtil.yyyyMMddHHmmss);
//		userInfo.setLoginStatus("1");
//		userInfo.setRecentLoginTime(time);
//		loginModel.setLoginStatus("1");
//		loginModel.setRecentLoginTime(time);
//		userInfo.setUserId(loginModel.getUserId());
//		UpdateWrapper<UserInfo> updateWrapper = new UpdateWrapper<UserInfo>();
//		UpdateWrapper<LoginModel> updateLoginWrapper = new UpdateWrapper<LoginModel>();
//		updateLoginWrapper.setEntity(loginModel);
//		updateWrapper.setEntity(userInfo);
//		
//		loginInterface.update(loginModel, updateLoginWrapper);
//		return userInterface.update(userInfo,updateWrapper);
		return true;
	}
}
