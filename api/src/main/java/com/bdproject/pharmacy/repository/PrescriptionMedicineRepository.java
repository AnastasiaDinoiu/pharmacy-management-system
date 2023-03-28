package com.bdproject.pharmacy.repository;

import com.bdproject.pharmacy.model.PrescriptionEntity;
import com.bdproject.pharmacy.model.PrescriptionMedicineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionMedicineRepository extends JpaRepository<PrescriptionMedicineEntity, Integer> {

    List<PrescriptionMedicineEntity> findByPrescriptie(PrescriptionEntity prescription);
}
