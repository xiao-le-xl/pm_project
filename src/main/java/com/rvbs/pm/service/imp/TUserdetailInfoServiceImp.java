package com.rvbs.pm.service.imp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rvbs.pm.core.AbstractService;
import com.rvbs.pm.mapper.TUserdetailInfoMapper;
import com.rvbs.pm.model.TUserdetailInfo;
import com.rvbs.pm.service.interfaces.TUserdetailInfoService;


/**
 * Created by CodeGenerator on 2022/04/24.
 */
@Service
@Transactional
public class TUserdetailInfoServiceImp extends AbstractService<TUserdetailInfoMapper,TUserdetailInfo> implements TUserdetailInfoService {

}
