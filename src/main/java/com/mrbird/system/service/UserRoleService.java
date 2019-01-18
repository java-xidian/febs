package com.mrbird.system.service;

import com.mrbird.common.service.IService;
import com.mrbird.system.domain.UserRole;

public interface UserRoleService extends IService<UserRole> {

	void deleteUserRolesByRoleId(String roleIds);

	void deleteUserRolesByUserId(String userIds);
}
