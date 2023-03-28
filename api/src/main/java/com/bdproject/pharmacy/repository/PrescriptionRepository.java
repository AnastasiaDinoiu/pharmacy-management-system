package com.bdproject.pharmacy.repository;

import com.bdproject.pharmacy.model.PrescriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends JpaRepository<PrescriptionEntity, Integer> {
}
