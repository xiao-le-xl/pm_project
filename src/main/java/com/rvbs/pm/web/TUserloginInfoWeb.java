package com.rvbs.pm.web;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rvbs.pm.model.RequestBean;
import com.rvbs.pm.model.ResponseBean;
import com.rvbs.pm.model.TUserloginInfo;
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

    @PostMapping("/add")
    public ResponseBean<TUserloginInfo> add(@RequestBody RequestBean<TUserloginInfo> requestBean) {
    	// TODO 默认方法生成，如需改动自行修改
        tUserloginInfoService.save(requestBean.getBody());
        return ResultTool.genSuccessResult(requestBean);
    }

    
    
    @PostMapping("/loginstatus")
    public Boolean changestate(@RequestBody RequestBean<TUserloginInfo> requestBean) {
    	// TODO 默认方法生成，如需改动自行修改
    	TUserloginInfo body = requestBean.getBody();
    	body.setLoginstatus("1");
    	return tUserloginInfoService.updateById(body);
        
    }
    
    @PostMapping("/delete")
    public ResponseBean<String> delete(@RequestBody RequestBean<String> requestBean) {
    	// TODO 默认方法生成，如需改动自行修改
        tUserloginInfoService.removeById(requestBean.getBody());
        return ResultTool.genSuccessResult(requestBean);
    }

    @PostMapping("/update")
    public ResponseBean<TUserloginInfo> update(@RequestBody RequestBean<TUserloginInfo> requestBean) {
    	// TODO 默认方法生成，如需改动自行修改
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
