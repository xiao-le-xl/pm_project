package com.rvbs.pm.service.imp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rvbs.pm.core.AbstractService;
import com.rvbs.pm.mapper.TUserloginInfoMapper;
import com.rvbs.pm.model.TUserloginInfo;
import com.rvbs.pm.service.interfaces.TUserloginInfoService;


/**
 * Created by CodeGenerator on 2022/04/27.
 */
@Service
@Transactional
public class TUserloginInfoServiceImp extends AbstractService<TUserloginInfoMapper,TUserloginInfo> implements TUserloginInfoService {

}
