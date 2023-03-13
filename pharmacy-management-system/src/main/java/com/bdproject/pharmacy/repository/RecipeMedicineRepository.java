package com.bdproject.pharmacy.repository;

import com.bdproject.pharmacy.model.RecipeMedicineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeMedicineRepository extends JpaRepository<RecipeMedicineEntity, Long> {
}
