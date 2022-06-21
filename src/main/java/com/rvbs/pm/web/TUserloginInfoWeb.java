package com.rvbs.pm.web;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rvbs.pm.model.RequestBean;
import com.rvbs.pm.model.ResponseBean;
import com.rvbs.pm.model.TUserloginInfo;
import com.rvbs.pm.service.interfaces.TUserdetailInfoService;
import com.rvbs.pm.service.interfaces.TUserloginInfoService;
import com.rvbs.pm.tool.ResultTool;



/**
* Created by CodeGenerator on 2022/04/27.
*/
@RestController
@RequestMapping("/api/t/userlogin/info")
public class TUserloginInfoWeb {
    @Resource
    private TUserloginInfoService tUserloginInfoService;
    
    @Resource
    private TUserdetailInfoService tUserdetailInfoService;

    @PostMapping("/add")
    public ResponseBean<TUserloginInfo> add(@RequestBody RequestBean<TUserloginInfo> requestBean) {
    	// TODO 默认方法生成，如需改动自行修改
    	if(StringUtils.isBlank(requestBean.getBody().getRoleid()) || StringUtils.isBlank(requestBean.getBody().getUserid()) || StringUtils.isBlank(requestBean.getBody().getPasswd()) || StringUtils.isBlank(requestBean.getBody().getUserstatus())  ) {
			return ResultTool.genFailResult(requestBean,"useradderror","工号密码角色以及用户状态不能为空");
		}
        boolean save = tUserloginInfoService.save(requestBean.getBody());
        if (!save) {
        	return ResultTool.genFailResult(requestBean,"useradderror02","插入失败");
		}
        return ResultTool.genSuccessResult(requestBean);
    }

    

    
    @PostMapping("/delete")
    public ResponseBean<String> delete(@RequestBody RequestBean<List<TUserloginInfo>> requestBean) {
    	// TODO 默认方法生成，如需改动自行修改
    	boolean removeById = false;
    	for (TUserloginInfo iterable_element : requestBean.getBody()) {
			if (StringUtils.isBlank(iterable_element.getUserid())) {
				return ResultTool.genFailResult(requestBean,"deleteerror01","工号不能为空");
			}
			if(!tUserloginInfoService.removeById(iterable_element.getUserid())) {
				removeById = true;
			}
			if (!tUserdetailInfoService.removeById(iterable_element.getUserid())) {
				removeById = true;
			}
		}
//        boolean removeByIds = tUserloginInfoService.removeByIds(requestBean.getBody());
        if (removeById) {
        	return ResultTool.genFailResult(requestBean,"delleterror02","删除失败");
		}
        return ResultTool.genSuccessResult(requestBean);
    }

    @PostMapping("/update")
    public ResponseBean<TUserloginInfo> update(@RequestBody RequestBean<TUserloginInfo> requestBean) {
    	// TODO 默认方法生成，如需改动自行修改
    	if(StringUtils.isBlank(requestBean.getBody().getUserid())  ) {
			return ResultTool.genFailResult(requestBean,"updateerror","工号不能为空");
		}
//    	如果对于密码有修改则将初始密码的标识设置为否
    	if (StringUtils.isBlank(requestBean.getBody().getPasswd())) {
    		requestBean.getBody().setInitpwdflag("1");
		}
        tUserloginInfoService.updateById(requestBean.getBody());
        return ResultTool.genSuccessResult(requestBean);
    }

    @PostMapping("/detail")
    public ResponseBean<TUserloginInfo> detail(@RequestBody RequestBean<String> requestBean) {
    	// TODO 默认方法生成，如需改动自行修改
        TUserloginInfo tUserloginInfo = tUserloginInfoService.getById(requestBean.getBody());
        return ResultTool.genSuccessResult(requestBean,tUserloginInfo);
    }

    @PostMapping("/list")
    public ResponseBean<List<TUserloginInfo>> list(@RequestBody RequestBean<TUserloginInfo> requestBean) {
        // TODO 默认方法生成，如需改动自行修改
		IPage<TUserloginInfo> page = tUserloginInfoService.page(new Page<TUserloginInfo>());
        return ResultTool.genSuccessResult(requestBean,page.getRecords());
    }
    
    
}
