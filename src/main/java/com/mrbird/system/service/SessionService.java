package com.mrbird.system.service;

import java.util.List;

import com.mrbird.system.domain.UserOnline;

public interface SessionService {

	List<UserOnline> list();

	boolean forceLogout(String sessionId);
}
