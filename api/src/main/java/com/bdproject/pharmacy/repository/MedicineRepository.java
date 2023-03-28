package com.bdproject.pharmacy.repository;

import com.bdproject.pharmacy.model.MedicineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<MedicineEntity, Integer> {
}
