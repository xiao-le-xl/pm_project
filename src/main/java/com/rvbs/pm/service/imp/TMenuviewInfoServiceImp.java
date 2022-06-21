package com.rvbs.pm.service.imp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rvbs.pm.core.AbstractService;
import com.rvbs.pm.mapper.TMenuviewInfoMapper;
import com.rvbs.pm.model.TMenuviewInfo;
import com.rvbs.pm.service.interfaces.TMenuviewInfoService;


/**
 * Created by CodeGenerator on 2022/05/05.
 */
@Service
@Transactional
public class TMenuviewInfoServiceImp extends AbstractService<TMenuviewInfoMapper,TMenuviewInfo> implements TMenuviewInfoService {

}
