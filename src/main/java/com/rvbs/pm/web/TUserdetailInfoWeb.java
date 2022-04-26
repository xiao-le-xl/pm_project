package com.rvbs.pm.web;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.rvbs.pm.model.RequestBean;
import com.rvbs.pm.model.ResponseBean;
import com.rvbs.pm.model.TUserdetailInfo;
import com.rvbs.pm.service.interfaces.TUserdetailInfoService;
import com.rvbs.pm.tool.ResultTool;



/**
* Created by CodeGenerator on 2022/04/24.
*/
@RestController
@RequestMapping("/api/t/userdetail/info")
public class TUserdetailInfoWeb {
    @Resource
    private TUserdetailInfoService tUserdetailInfoService;

    @PostMapping("/add")
    public ResponseBean<TUserdetailInfo> add(@RequestBody RequestBean<TUserdetailInfo> requestBean) {
    	// 判断用户名或用户名是否为空
		if(StringUtils.isBlank(requestBean.getBody().getUserid()) || StringUtils.isBlank(requestBean.getBody().getUsername()) || StringUtils.isBlank(requestBean.getBody().getLevelcompy()) || StringUtils.isBlank(requestBean.getBody().getDepartment()) ) {
			return ResultTool.genFailResult(requestBean,"Us001","用户id或用户名或员工级别或所属部门为空，插入失败!");
		}
		System.out.println("数据不为空"+tUserdetailInfoService);
		//插入一条数据
		boolean save = tUserdetailInfoService.save(requestBean.getBody());
		if (!save) {
			return ResultTool.genFailResult(requestBean,"Us002","插入失败!");
		}
		return ResultTool.genFailResult(requestBean,"success","插入成功!");
    }

    /**
	 * 批量新增
	 * @param request
	 * @return
	 */
	@PostMapping("/insertusers")
	public ResponseBean<TUserdetailInfo> addUserDetails(@RequestBody RequestBean<List<TUserdetailInfo>> request){
		System.out.println("方法开始执行");
		System.out.println("数据不为空"+tUserdetailInfoService);
		//
		System.out.println(request.getBody());
		boolean saveBatch = tUserdetailInfoService.saveBatch(request.getBody());
		if (!saveBatch) {
			return ResultTool.genFailResult(request,"Us002","插入失败!");
		}
		return ResultTool.genFailResult(request,"success","插入成功!");
	}
    
    @PostMapping("/delete")
    public ResponseBean<String> delete(@RequestBody RequestBean<TUserdetailInfo> requestBean) {
    	// 判断id是否为空
		if(StringUtils.isBlank(requestBean.getBody().getUserid())) {
			return ResultTool.genFailResult(requestBean,"dlUs001","用户id不能为空，删除失败!");
		}
    	// TODO 默认方法生成，如需改动自行修改
        boolean removeById = tUserdetailInfoService.removeById(requestBean.getBody().getUserid());
        if (!removeById) {
        	return ResultTool.genFailResult(requestBean, "deleterror", "删除失败，无匹配内容");
		}
        System.out.println(removeById);
        return ResultTool.genSuccessResult(requestBean);
    }
    
    /***
   	 * 批量删除
   	 * @param request
   	 * @return
   	 */
   	@PostMapping("/deleteuserbyids")
   	public ResponseBean<String> deltUserDetailByIds(@RequestBody RequestBean<TUserdetailInfo> request){
   		// 判断id是否为空
   		
   		if(StringUtils.isBlank(request.getBody().getUserid())) {
   			return ResultTool.genFailResult(request,"seldlUs001","用户id不能为空，查询失败!");
   		}
   		 boolean removeByIds = tUserdetailInfoService.removeByIds(Arrays.asList(request.getBody().getUserid().split(",")));
   		if (!removeByIds) {
   			return ResultTool.genFailResult(request, "deleterror", "删除失败，无匹配内容");
   		}
   		return ResultTool.genSuccessResult(request);
   	}

    @PostMapping("/update")
    public ResponseBean<TUserdetailInfo> update(@RequestBody RequestBean<TUserdetailInfo> request) {
    	// 判断id是否为空
		if(StringUtils.isBlank(request.getBody().getUserid())) {
			return ResultTool.genFailResult(request,"uplUs001","用户id不能为空，更新失败!");
		}
		 boolean updateById = tUserdetailInfoService.updateById(request.getBody());
		if (!updateById) {
			return ResultTool.genFailResult(request,"upUs002","更新失败");
		}
		return ResultTool.genSuccessResult(request);
    }

    @PostMapping("/detail")
    public ResponseBean<TUserdetailInfo> detail(@RequestBody RequestBean<TUserdetailInfo> requestBean) {
    	// TODO 默认方法生成，如需改动自行修改
        TUserdetailInfo tUserdetailInfo = tUserdetailInfoService.getById(requestBean.getBody());
        return ResultTool.genSuccessResult(requestBean,tUserdetailInfo);
    }

    @PostMapping("/list")
    public ResponseBean<List<TUserdetailInfo>> list(@RequestBody RequestBean<TUserdetailInfo> requestBean) {
    	int pageNum = Integer.parseInt(requestBean.getApp_head().getPageNum());
        int pageSize=Integer.parseInt(requestBean.getApp_head().getPageSize());
        System.out.println(pageNum+"    "+pageSize);
        System.out.println(requestBean.getBody());
		System.out.println("====");
	//	有参数
		Page<TUserdetailInfo> page2 = new Page<TUserdetailInfo>(pageNum,pageSize);
		System.out.println(page2.getSize());
		IPage<TUserdetailInfo> page = tUserdetailInfoService.page(page2,new QueryWrapper<TUserdetailInfo>(requestBean.getBody()) );
	//      if (pageSize != 0 ) {
	//      	page.setSize(pageSize);
	//      }
		System.out.println("多少条"+page.getRecords().size());
	       // TODO 默认方法生成，如需改动自行修改
	       return ResultTool.genSuccessResult(requestBean,page.getRecords());
    }
    
    
}
