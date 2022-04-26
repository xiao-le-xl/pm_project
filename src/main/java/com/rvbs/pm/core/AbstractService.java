package com.rvbs.pm.core;


import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import com.github.jeffreyning.mybatisplus.service.MppServiceImpl;


/**
 * 基于通用MyBatis Mapper插件的Service接口的实现
 */
public abstract class AbstractService<M extends MppBaseMapper<T>,T> extends MppServiceImpl<M, T>{
	
}
