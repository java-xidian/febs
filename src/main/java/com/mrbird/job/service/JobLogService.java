package com.mrbird.job.service;

import java.util.List;

import com.mrbird.common.service.IService;
import com.mrbird.job.domain.JobLog;

public interface JobLogService extends IService<JobLog> {

	List<JobLog> findAllJobLogs(JobLog jobLog);

	void saveJobLog(JobLog log);
	
	void deleteBatch(String jobLogIds);
}
