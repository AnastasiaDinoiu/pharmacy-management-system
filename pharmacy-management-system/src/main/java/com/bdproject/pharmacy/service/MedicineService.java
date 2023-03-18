package com.bdproject.pharmacy.service;

import com.bdproject.pharmacy.dto.request.MedicineRequest;
import com.bdproject.pharmacy.model.MedicineEntity;

import java.util.List;

public interface MedicineService {

    Integer createMedicine(MedicineRequest request);

    Integer updateMedicine(Integer idMedicament, MedicineRequest request);

    void deleteMedicine(Integer idMedicament);

    MedicineEntity getMedicineById(Integer idMedicament);

    List<MedicineEntity> getMedicines();
}
