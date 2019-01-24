package com.mrbird.job.dao;

import java.util.List;

import com.mrbird.common.config.MyMapper;
import com.mrbird.job.domain.Job;
import org.springframework.stereotype.Repository;

@Repository
public interface JobMapper extends MyMapper<Job> {
	
	List<Job> queryList();
}