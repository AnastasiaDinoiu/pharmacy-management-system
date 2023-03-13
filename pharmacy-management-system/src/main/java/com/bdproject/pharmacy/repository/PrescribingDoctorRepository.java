package com.bdproject.pharmacy.repository;

import com.bdproject.pharmacy.model.PrescribingDoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescribingDoctorRepository extends JpaRepository<PrescribingDoctorEntity, Integer> {
}
