package com.rvbs.pm.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rvbs.pm.core.AbstractService;
import com.rvbs.pm.mapper.TMenuviewroleRltMapper;
import com.rvbs.pm.model.TMenuviewroleRlt;
import com.rvbs.pm.service.interfaces.TMenuviewroleRltService;


/**
 * Created by CodeGenerator on 2022/04/24.
 */
@Service
@Transactional
public class TMenuviewroleRltServiceImp extends AbstractService<TMenuviewroleRltMapper,TMenuviewroleRlt> implements TMenuviewroleRltService {

	public List<Map<String, String>> findAllMenu(){
		return this.getBaseMapper().findAllMenu();
	}
}
