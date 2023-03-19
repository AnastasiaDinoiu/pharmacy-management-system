package com.bdproject.pharmacy.service;

import com.bdproject.pharmacy.dto.request.PrescriptionMedicineRequest;
import com.bdproject.pharmacy.dto.response.PrescriptionMedicineResponse;
import com.bdproject.pharmacy.model.MedicineEntity;

import java.util.List;

public interface PrescriptionMedicineService {

    PrescriptionMedicineResponse insertMedicinesInPrescription(Integer idPrescriptie, List<PrescriptionMedicineRequest> request);

    List<MedicineEntity> getMedicinesByPrescriptionId(Integer idPrescriptie);
}
