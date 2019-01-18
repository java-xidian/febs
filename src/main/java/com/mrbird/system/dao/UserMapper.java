package com.mrbird.system.dao;

import java.util.List;

import com.mrbird.common.config.MyMapper;
import com.mrbird.system.domain.User;
import com.mrbird.system.domain.UserWithRole;

public interface UserMapper extends MyMapper<User> {

	List<User> findUserWithDept(User user);
	
	List<UserWithRole> findUserWithRole(Long userId);
	
	User findUserProfile(User user);
}