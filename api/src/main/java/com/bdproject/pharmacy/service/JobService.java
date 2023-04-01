package com.bdproject.pharmacy.service;

import com.bdproject.pharmacy.dto.request.JobRequest;
import com.bdproject.pharmacy.model.JobEntity;

import java.util.List;

public interface JobService {

    Integer createJob(JobRequest request);

    Integer updateJob(Integer idPost, JobRequest request);

    void deleteJob(Integer idPost);

    JobEntity getJobById(Integer idPost);

    List<JobEntity> getJobs();
}
