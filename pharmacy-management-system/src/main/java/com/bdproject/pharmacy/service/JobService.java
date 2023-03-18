package com.bdproject.pharmacy.service;

import com.bdproject.pharmacy.model.JobEntity;

import java.util.List;

public interface JobService {

    Integer createJob(String numePost, Integer salariu);

    Integer updateJob(Integer idPost, String numePost, Integer salariu);

    void deleteJob(Integer idPost);

    JobEntity getJobById(Integer idPost);

    List<JobEntity> getJobs();
}
