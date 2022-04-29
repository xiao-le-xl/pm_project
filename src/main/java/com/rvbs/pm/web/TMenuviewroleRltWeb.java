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
import com.rvbs.pm.model.TMenuviewroleRlt;
import com.rvbs.pm.model.TUserdetailInfo;
import com.rvbs.pm.service.interfaces.TMenuviewroleRltService;
import com.rvbs.pm.tool.ResultTool;



/**
* Created by CodeGenerator on 2022/04/24.
*/
@RestController
@RequestMapping("/api/t/menuviewrole/rlt")
public class TMenuviewroleRltWeb {
    @Resource
    private TMenuviewroleRltService tMenuviewroleRltService;

    @PostMapping("/add")
    public ResponseBean<TMenuviewroleRlt> add(@RequestBody RequestBean<TMenuviewroleRlt> requestBean) {
    	// TODO 默认方法生成，如需改动自行修改
    	// 判断用户名或菜单用户名是否为空
    	if(StringUtils.isBlank(requestBean.getBody().getRoleid()) || StringUtils.isBlank(requestBean.getBody().getMenuviewnum()) ) {
    		return ResultTool.genFailResult(requestBean,"Us001","用户id或用户名或菜单视图编号门为空，插入失败!");
    	}
        boolean save = tMenuviewroleRltService.save(requestBean.getBody());
        if (!save) {
        	return ResultTool.genFailResult(requestBean,"adderror","插入失败!");
		}
        return ResultTool.genSuccessResult(requestBean);
    }

    @PostMapping("/delete")
    public ResponseBean<String> delete(@RequestBody RequestBean<TMenuviewroleRlt> requestBean) {
    	// TODO 默认方法生成，如需改动自行修改
    	if(StringUtils.isBlank(requestBean.getBody().getRoleid()) || StringUtils.isBlank(requestBean.getBody().getMenuviewnum()) ) {
    		return ResultTool.genFailResult(requestBean,"Us001","用户id或用户名或菜单视图编号门为空，插入失败!");
    	}
    	//删除单个
        boolean deleteByMultiId = tMenuviewroleRltService.deleteByMultiId(requestBean.getBody());
        if (!deleteByMultiId) {
        	return ResultTool.genFailResult(requestBean,"delteerror","删除失败!");
		}
        return ResultTool.genSuccessResult(requestBean);
    }
    
    
    @PostMapping("/deletes")
    public ResponseBean<String> deletes(@RequestBody RequestBean<List<TMenuviewroleRlt>> requestBean) {
    	// TODO 默认方法生成，如需改动自行修改
    	List<TMenuviewroleRlt> body = requestBean.getBody();
    	boolean deleteByMultiId =false;
    	for (TMenuviewroleRlt tMenuviewroleRlt : body) {
    		boolean d = tMenuviewroleRltService.deleteByMultiId(tMenuviewroleRlt);
    		if (d) {
    			deleteByMultiId = true;
			}
		}
        if (!deleteByMultiId) {
        	return ResultTool.genFailResult(requestBean,"delteerror","删除失败!");
		}
        return ResultTool.genSuccessResult(requestBean);
    }
    

    @PostMapping("/update")
    public ResponseBean<TMenuviewroleRlt> update(@RequestBody RequestBean<TMenuviewroleRlt> requestBean) {
    	// TODO 默认方法生成，如需改动自行修改
    	// 判断用户名或菜单是否为空
    	if(StringUtils.isBlank(requestBean.getBody().getRoleid()) || StringUtils.isBlank(requestBean.getBody().getMenuviewnum()) ) {
    		return ResultTool.genFailResult(requestBean,"uperr01","修改失败!");
    	}
        boolean updateByMultiId = tMenuviewroleRltService.updateByMultiId(requestBean.getBody());
        if (!updateByMultiId) {
        	return ResultTool.genFailResult(requestBean,"uperr02","修改失败!");
		}
        return ResultTool.genSuccessResult(requestBean);
    }

    @PostMapping("/detail")
    public ResponseBean<List<TMenuviewroleRlt>> detail(@RequestBody RequestBean<TMenuviewroleRlt> requestBean) {
    	// TODO 默认方法生成，如需改动自行修改
    	System.out.println(requestBean.getBody().getMenuviewnum());
    	List<TMenuviewroleRlt> result =new ArrayList<TMenuviewroleRlt>();
    	if (requestBean.getBody().getRoleid() != null && requestBean.getBody().getMenuviewnum()!=null) {
    	
    		
    		TMenuviewroleRlt tMenuviewroleRlt = tMenuviewroleRltService.selectByMultiId(requestBean.getBody());
    		if (tMenuviewroleRlt==null) {
    			return ResultTool.genFailResult(requestBean,"selecterror","查询无匹配条件");
    		}
    		result.add(tMenuviewroleRlt);
    		return ResultTool.genSuccessResult(requestBean,result);
		}else {
//			TMenuviewroleRlt byId = tMenuviewroleRltService.getByMultiId(requestBean.getBody());
//			if (byId==null) {
//    			return ResultTool.genFailResult(requestBean,"selecterror","查询无匹配条件");
//    		}
//    		return ResultTool.genSuccessResult(requestBean,byId);
	    	int pageNum = Integer.parseInt(requestBean.getApp_head().getPageNum());
	        int pageSize=Integer.parseInt(requestBean.getApp_head().getPageSize());
	        System.out.println(pageNum+"    "+pageSize);
			System.out.println("====");
		//	有参数
			Page<TMenuviewroleRlt> page2 = new Page<TMenuviewroleRlt>(pageNum,pageSize);
			QueryWrapper<TMenuviewroleRlt> menuWrapp = new QueryWrapper<TMenuviewroleRlt>(requestBean.getBody());
			Map<String, String> map = new HashMap<String, String>();
			map.put("roleid", requestBean.getBody().getRoleid());
//			menuWrapp.select("roleid");
			menuWrapp.allEq(map);
	    	result= tMenuviewroleRltService.list(menuWrapp);
//			 List<TMenuviewroleRlt> list = tMenuviewroleRltService.list(menuWrapp);
	    	if (result.size() == 0) {
    			return ResultTool.genFailResult(requestBean,"selecterror","查询无匹配条件");
    		}
	    	return ResultTool.genSuccessResult(requestBean, result);
		}
    }

    @PostMapping("/allmeun")
    public ResponseBean<List<Map<String, String>>> list(@RequestBody RequestBean<TMenuviewroleRlt> requestBean) {
        // TODO 默认方法生成，如需改动自行修改
		 return ResultTool.genSuccessResult(requestBean, tMenuviewroleRltService.findAllMenu());
    }
    
    
}
