package com.rvbs.pm.web;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rvbs.pm.model.RequestBean;
import com.rvbs.pm.model.ResponseBean;
import com.rvbs.pm.model.TMenuviewInfo;
import com.rvbs.pm.model.TMenuviewroleRlt;
import com.rvbs.pm.service.interfaces.TMenuviewInfoService;
import com.rvbs.pm.tool.ResultTool;



/**
* Created by CodeGenerator on 2022/04/25.
*/
@RestController
@RequestMapping("/api/t/menuview/info")
public class TMenuviewInfoWeb {
    @Resource
    private TMenuviewInfoService tMenuviewInfoService;

    @PostMapping("/add")
    public ResponseBean<TMenuviewInfo> add(@RequestBody RequestBean<TMenuviewInfo> requestBean) {
    	// TODO 默认方法生成，如需改动自行修改
    	if (StringUtils.isBlank(requestBean.getBody().getMenunum()) || StringUtils.isBlank(requestBean.getBody().getMenuname()) || 
    			StringUtils.isBlank(requestBean.getBody().getMenuviewname()) || StringUtils.isBlank(requestBean.getBody().getParentmenunum()) || StringUtils.isBlank(requestBean.getBody().getIsvisible())) {
    		return ResultTool.genFailResult(requestBean,"adderror01","插入数据不能为空!");
		}
    	//插入数据
        boolean save = tMenuviewInfoService.save(requestBean.getBody());
        if (!save) {
        	return ResultTool.genFailResult(requestBean,"adderror02","数据插入失败!");
		}
        return ResultTool.genSuccessResult(requestBean);
    }
    
    

    @PostMapping("/delete")
    public ResponseBean<String> delete(@RequestBody RequestBean<TMenuviewInfo> requestBean) {
    	// TODO 默认方法生成，如需改动自行修改
    	if (StringUtils.isBlank(""+requestBean.getBody().getMenuviewnum()) || StringUtils.isBlank(requestBean.getBody().getMenunum())){
    		return ResultTool.genFailResult(requestBean,"deleteerroe01","删 除的 主键不能 为空！");
    	}
        boolean deleteByMultiId = tMenuviewInfoService.deleteByMultiId(requestBean.getBody());
        if (!deleteByMultiId) {
        	return ResultTool.genFailResult(requestBean,"deleteerroe02","删除失败！");
		}
        return ResultTool.genSuccessResult(requestBean);
    }
    
    
    @PostMapping("/deletes")
    public ResponseBean<String> deletes(@RequestBody RequestBean<List<TMenuviewInfo>> requestBean) {
    	// TODO 默认方法生成，如需改动自行修改
    	List<TMenuviewInfo> body = requestBean.getBody();
    	boolean deleteByMultiId = false;
    	for (TMenuviewInfo tMenuviewInfo : body) {
    		boolean b = tMenuviewInfoService.deleteByMultiId(tMenuviewInfo);
    		if (b) {
    			deleteByMultiId = true;
			}
		}
        if (!deleteByMultiId) {
        	return ResultTool.genFailResult(requestBean,"deleteerroe02","删除失败！");
		}
        return ResultTool.genSuccessResult(requestBean);
    }

    @PostMapping("/update")
    public ResponseBean<TMenuviewInfo> update(@RequestBody RequestBean<TMenuviewInfo> requestBean) {
    	// TODO 默认方法生成，如需改动自行修改
    	if (StringUtils.isBlank(""+requestBean.getBody().getMenuviewnum()) || StringUtils.isBlank(requestBean.getBody().getMenunum())){
    		return ResultTool.genFailResult(requestBean,"updateerroe01","修改的主键不能为空！");
    	}
    	boolean updateByMultiId = tMenuviewInfoService.updateByMultiId(requestBean.getBody());
    	if (!updateByMultiId) {
    		return ResultTool.genFailResult(requestBean,"updateerroe01","修改失 败！");
		}
        return ResultTool.genSuccessResult(requestBean);
    }

    @PostMapping("/detail")
    public ResponseBean<List<TMenuviewInfo>> detail(@RequestBody RequestBean<TMenuviewInfo> requestBean) {
    	// TODO 默认方法生成，如需改动自行修改
    	List<TMenuviewInfo> result =new ArrayList<TMenuviewInfo>();
    	if (requestBean.getBody().getMenunum() != null && requestBean.getBody().getMenuviewnum()!=null) {
    		 TMenuviewInfo selectByMultiId = tMenuviewInfoService.selectByMultiId(requestBean.getBody());
    		if (selectByMultiId==null) {
    			return ResultTool.genFailResult(requestBean,"selecterror","查询无匹配条件");
    		}
    		result.add(selectByMultiId);
    		return ResultTool.genSuccessResult(requestBean,result);
    	}else {
			QueryWrapper<TMenuviewInfo> menuWrapp = new QueryWrapper<TMenuviewInfo>(requestBean.getBody());
			Map<String, String> map = new HashMap<String, String>();
			map.put("menuviewnum", requestBean.getBody().getMenunum());
//			menuWrapp.select("roleid");
			menuWrapp.allEq(map, false);
	    	result= tMenuviewInfoService.list(menuWrapp);
//			 List<TMenuviewroleRlt> list = tMenuviewroleRltService.list(menuWrapp);
	    	if (result.size() == 0) {
    			return ResultTool.genFailResult(requestBean,"selecterror","查询无  配条件");
    		}
	    	return ResultTool.genSuccessResult(requestBean, result);
		}
    }

    @PostMapping("/list")
    public ResponseBean<List<TMenuviewInfo>> list(@RequestBody RequestBean<TMenuviewInfo> requestBean) {
        // TODO 默认方法生成，如需改动自行修改
		IPage<TMenuviewInfo> page = tMenuviewInfoService.page(new Page<TMenuviewInfo>());
        return ResultTool.genSuccessResult(requestBean,page.getRecords());
    }
    
    
}
