package com.mrbird.system.dao;

import java.util.List;

import com.mrbird.common.config.MyMapper;
import com.mrbird.system.domain.Role;
import com.mrbird.system.domain.RoleWithMenu;

public interface RoleMapper extends MyMapper<Role> {
	
	List<Role> findUserRole(String userName);
	
	List<RoleWithMenu> findById(Long roleId);
}