package com.bdproject.pharmacy.repository;

import com.bdproject.pharmacy.model.DiagnoseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnoseRepository extends JpaRepository<DiagnoseEntity, Integer> {
}
