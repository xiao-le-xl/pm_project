package ${basePackage}.service.imp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${basePackage}.core.AbstractService;
import ${basePackage}.mapper.${modelNameUpperCamel}Mapper;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.interfaces.${modelNameUpperCamel}Service;


/**
 * Created by ${author} on ${date}.
 */
@Service
@Transactional
public class ${modelNameUpperCamel}ServiceImp extends AbstractService<${modelNameUpperCamel}Mapper,${modelNameUpperCamel}> implements ${modelNameUpperCamel}Service {

}
