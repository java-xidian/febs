package com.mrbird.system.service;

import java.util.List;

import com.mrbird.common.domain.Tree;
import com.mrbird.common.service.IService;
import com.mrbird.system.domain.Dept;

public interface DeptService extends IService<Dept> {

	Tree<Dept> getDeptTree();

	List<Dept> findAllDepts(Dept dept);

	Dept findByName(String deptName);

	Dept findById(Long deptId);
	
	void addDept(Dept dept);
	
	void updateDept(Dept dept);

	void deleteDepts(String deptIds);
}
