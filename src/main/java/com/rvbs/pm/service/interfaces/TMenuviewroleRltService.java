package com.rvbs.pm.service.interfaces;
import com.rvbs.pm.model.TMenuviewroleRlt;

import java.util.List;
import java.util.Map;

import com.rvbs.pm.core.Service;


/**
 * Created by CodeGenerator on 2022/04/24.
 */
public interface TMenuviewroleRltService extends Service<TMenuviewroleRlt> {
	
	public List<Map<String, String>> findAllMenu(String roleid);
	
	public Boolean updateEnabelFlag(String roleid);
}
