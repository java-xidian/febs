package com.mrbird.job.service;

import com.mrbird.common.service.IService;
import com.mrbird.job.domain.Job;
import org.springframework.cache.annotation.CacheConfig;

import java.util.List;

@CacheConfig(cacheNames = "JobService")
public interface JobService extends IService<Job> {

    Job findJob(Long jobId);

    List<Job> findAllJobs(Job job);

    void addJob(Job job);

    void updateJob(Job job);

    void deleteBatch(String jobIds);

    int updateBatch(String jobIds, String status);

    void run(String jobIds);

    void pause(String jobIds);

    void resume(String jobIds);


    /**
     * add by lcq 2018加入缓存已注释掉
     *
     * @Cacheable(key = "#p0")
     */
    List<Job> getSysCronClazz(Job job);
}
