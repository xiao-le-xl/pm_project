package com.rvbs.pm.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.rvbs.pm.model.RequestBean;
import com.rvbs.pm.model.ResponseBean;
import com.rvbs.pm.model.TMenuviewInfo;
import com.rvbs.pm.model.TUserloginInfo;
//import com.rvbs.pm.model.UserInfo;
import com.rvbs.pm.model.login.LoginModel;
import com.rvbs.pm.service.interfaces.LoginInterface;
import com.rvbs.pm.service.interfaces.TUserloginInfoService;
import com.rvbs.pm.tool.DateUtil;
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
	
	@Resource
    private TUserloginInfoService tUserloginInfoService;
	
	private final Long MAX_TIME = 3600_000L;
	
	@PostMapping("/login")
	public ResponseBean<LoginModel> login(@RequestBody RequestBean<LoginModel> request){
		// 判断用户名或密码是否为空
		if(StringUtils.isBlank(request.getBody().getPassWd()) || StringUtils.isBlank(request.getBody().getUserId())) {
			return ResultTool.genFailResult(request,"loginfaled01","用户id或密码为空，登录失败!");
		}
		// 查询登录信息
//		LoginModel loginModel = loginInterface.getById(request.getBody().getUserId());
		LoginModel loginModel = loginInterface.selectLoginModel(request.getBody());
		if(loginModel == null) { // 如登录信息为空，则为用户名或密码错误
			return ResultTool.genFailResult(request,loginModel,"loginfaled02","密码错误登录失败!");
		}
		
		// 获取token数据，并赋予返回对象中
		loginModel.setToken(getToken(loginModel.getUserId(), "普通员工")); 
		
		// 更新用户状态以及登录时间
		TUserloginInfo t=new TUserloginInfo();
		t.setUserid(request.getBody().getUserId());
		boolean result = updateLoginStatus(t); // 注明：在此还可以登记失败次数等操作,后续可以考虑是否追加
		if(result) { // 更新成功
			ResponseBean<LoginModel> resBean = ResultTool.genSuccessResult(request,loginModel);
			resBean.getApp_head().setRoleId(loginModel.getRoleId());
			return resBean;
		}else {
			return ResultTool.genFailResult(request,loginModel,"Us003","更新用户状态失败，请联系管理员或重新登录!");
		}
	}
	
	@PostMapping("/usercheck")
	public ResponseBean<TUserloginInfo> userCheck(@RequestBody RequestBean<TUserloginInfo> request){
		if (StringUtils.isBlank(request.getBody().getUserid())) {
			return ResultTool.genFailResult(request,"usernotfind01","用户名不能为空!");
		}
		QueryWrapper<TUserloginInfo> queryWrapper = new QueryWrapper<TUserloginInfo>();
		queryWrapper.select("userid");
		Map<String, String> params=new HashMap<String,String>();
		params.put("userid", request.getBody().getUserid());
		queryWrapper.allEq(params);
		TUserloginInfo one = tUserloginInfoService.getOne(queryWrapper);
//		TUserloginInfo selectByMultiId = tUserloginInfoService.getById(request.getBody().getUserid());
		if (one == null ) {
			return ResultTool.genFailResult(request,"usernotfind02","用户名不存在");
		}
		return ResultTool.genSuccessResult(request);
	}
	
	
	
	
	
	
	@PostMapping("/exit")
	public ResponseBean<LoginModel> exit(@RequestBody RequestBean<LoginModel> request){
		UpdateWrapper<TUserloginInfo> updateLoginWrapper = new UpdateWrapper<TUserloginInfo>();		
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", request.getBody().getUserId());
		updateLoginWrapper.allEq(map);
		updateLoginWrapper.set("loginstatus", "0");
//		System.out.println("kchgasjd");
		boolean update = tUserloginInfoService.update(updateLoginWrapper);
		if (!update) {
			return ResultTool.genFailResult(request,"exitfaled","更新用户状态失败，请联系管理员或重新签退!");
		}
		return ResultTool.genSuccessResult(request);
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
	public boolean updateLoginStatus(TUserloginInfo loginModel) {
		// TODO 默认方法生成，如需改动自行修改
		String time = DateUtil.currentDate(DateUtil.yyyyMMddHHmmss);
		UpdateWrapper<TUserloginInfo> updateLoginWrapper = new UpdateWrapper<TUserloginInfo>();		
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", loginModel.getUserid());
		updateLoginWrapper.allEq(map);
		updateLoginWrapper.set("loginstatus", "1");
		updateLoginWrapper.set("recentlogintime", time);
//		System.out.println("kchgasjd");
		return tUserloginInfoService.update(updateLoginWrapper);
//		UserInfo userInfo = new UserInfo();
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
//		return true;
	}
}
