package com.bdproject.pharmacy.repository;

import com.bdproject.pharmacy.model.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<JobEntity, Integer> {
}
