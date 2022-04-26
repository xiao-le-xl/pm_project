package ${basePackage}.web;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${basePackage}.core.RequestBean;
import ${basePackage}.core.ResponseBean;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.interfaces.${modelNameUpperCamel}Service;
import ${basePackage}.tool.ResultTool;



/**
* Created by ${author} on ${date}.
*/
@RestController
@RequestMapping("/api${baseRequestMapping}")
public class ${modelNameUpperCamel}Web {
    @Resource
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @PostMapping("/add")
    public ResponseBean<${modelNameUpperCamel}> add(@RequestBody RequestBean<${modelNameUpperCamel}> requestBean) {
    	// TODO 默认方法生成，如需改动自行修改
        ${modelNameLowerCamel}Service.save(requestBean.getBody());
        return ResultTool.genSuccessResult(requestBean);
    }

    @PostMapping("/delete")
    public ResponseBean<String> delete(@RequestBody RequestBean<String> requestBean) {
    	// TODO 默认方法生成，如需改动自行修改
        ${modelNameLowerCamel}Service.removeById(requestBean.getBody());
        return ResultTool.genSuccessResult(requestBean);
    }

    @PostMapping("/update")
    public ResponseBean<${modelNameUpperCamel}> update(@RequestBody RequestBean<${modelNameUpperCamel}> requestBean) {
    	// TODO 默认方法生成，如需改动自行修改
        ${modelNameLowerCamel}Service.updateById(requestBean.getBody());
        return ResultTool.genSuccessResult(requestBean);
    }

    @PostMapping("/detail")
    public ResponseBean<${modelNameUpperCamel}> detail(@RequestBody RequestBean<String> requestBean) {
    	// TODO 默认方法生成，如需改动自行修改
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.getById(requestBean.getBody());
        return ResultTool.genSuccessResult(requestBean,${modelNameLowerCamel});
    }

    @PostMapping("/list")
    public ResponseBean<List<${modelNameUpperCamel}>> list(@RequestBody RequestBean<${modelNameUpperCamel}> requestBean) {
        // TODO 默认方法生成，如需改动自行修改
		IPage<${modelNameUpperCamel}> page = ${modelNameLowerCamel}Service.page(new Page<${modelNameUpperCamel}>());
        return ResultTool.genSuccessResult(requestBean,page.getRecords());
    }
    
    
}
