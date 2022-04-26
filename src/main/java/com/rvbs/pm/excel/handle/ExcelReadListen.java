package com.rvbs.pm.excel.handle;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rvbs.pm.core.BaseBean;
import com.rvbs.pm.excel.ExcelAbstractReadListen;
import com.rvbs.pm.model.login.LoginModel;

public class ExcelReadListen extends ExcelAbstractReadListen<LoginModel>{
	/** 日志对象 */
	private final Logger logger = LoggerFactory.getLogger(ExcelReadListen.class);
	@Override
	protected boolean dataCheck(LoginModel data) {
		if(StringUtils.isBlank(data.getUserId())) {
			logger.info("----用户id为空不插入数据库！");
		}
		return true;
	}

	@Override
	protected void dataHandle(LoginModel data) {
		// TODO Auto-generated method stub
//		UserDetailInfo userDetailInfo = new UserDetailInfo();
//		userDetailInfo.setUserId(data.getUserId());
//		userDetailInfo.setUsername(data.getUsername());
//		userDetailInfo.setBankofemployee(data.getBankofemployee());
//		userDetailInfo.setBankuserid(data.getBankuserid());
//		userDetailInfo.setDepartment(data.getDepartment());
//		userDetailInfo.setLevelcompy(data.getLevelcompy());
//		userDetailInfo.setProjectgroup(data.getProjectgroup());
//		UserInfoIn userInfoIn =new UserInfoIn();
//		userInfoIn.setUserId(data.getUserId());
//		userInfoIn.setPassWd(data.getPassWd());
//		userInfoIn.setRoleId(data.getRoleId());
//		this.addCashData("userDetailInfo", userDetailInfo);
//		this.addCashData("userInfoIn", userInfoIn);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected void bathInsert(Map<String, List<BaseBean>> totalCacheDataMap) {
		// TODO Auto-generated method stub
//		((UserinfoInterface)this.getMappersy()[0]).saveDeatil(totalCacheDataMap.get("userDetailInfo"));
//		((UserinfoInterface) this.getMappersy()[0]).saveDeatil((List)totalCacheDataMap.get("UserInfo"));
//		((UserinfoInterface)this.getMappersy()[0]).saveLogin((List)totalCacheDataMap.get("userInfoIn"));
//		((UserinfoInterface)this.getMappersy()[0]).saveDeatil((List)totalCacheDataMap.get("userDetailInfo"));
//		UserinfoInterface service = (UserinfoInterface)this.getMappersy()[0];
//		service.saveBatch((List)totalCacheDataMap.get("userDetailInfo"));
	}

}
