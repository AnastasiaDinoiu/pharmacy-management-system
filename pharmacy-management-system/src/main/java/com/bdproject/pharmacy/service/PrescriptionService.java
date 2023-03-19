package com.bdproject.pharmacy.service;

import com.bdproject.pharmacy.dto.request.PrescriptionRequest;
import com.bdproject.pharmacy.model.PrescriptionEntity;

import java.util.List;

public interface PrescriptionService {

    Integer createPrescription(PrescriptionRequest request);

    Integer updatePrescription(Integer idProducator, PrescriptionRequest request);

    void deletePrescription(Integer idProducator);

    PrescriptionEntity getPrescriptionById(Integer idProducator);

    List<PrescriptionEntity> getPrescriptions();
}
