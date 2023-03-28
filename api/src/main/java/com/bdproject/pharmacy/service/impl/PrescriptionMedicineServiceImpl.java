package com.bdproject.pharmacy.service.impl;

import com.bdproject.pharmacy.dto.request.PrescriptionMedicineRequest;
import com.bdproject.pharmacy.dto.response.PrescriptionMedicineResponse;
import com.bdproject.pharmacy.exception.ErrorCodes;
import com.bdproject.pharmacy.exception.ServiceException;
import com.bdproject.pharmacy.model.MedicineEntity;
import com.bdproject.pharmacy.model.PrescriptionMedicineEntity;
import com.bdproject.pharmacy.repository.MedicineRepository;
import com.bdproject.pharmacy.repository.PrescriptionMedicineRepository;
import com.bdproject.pharmacy.repository.PrescriptionRepository;
import com.bdproject.pharmacy.service.PrescriptionMedicineService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PrescriptionMedicineServiceImpl implements PrescriptionMedicineService {

    private final PrescriptionMedicineRepository prescriptionMedicineRepository;
    private final PrescriptionRepository prescriptionRepository;
    private final MedicineRepository medicineRepository;

    @Override
    public PrescriptionMedicineResponse insertMedicinesInPrescription(Integer idPrescriptie, List<PrescriptionMedicineRequest> request) {
        validatePrescriptionId(idPrescriptie);
        var response = new PrescriptionMedicineResponse();
        var medicines = request.stream()
                .map(PrescriptionMedicineRequest::getIdMedicament)
                .toList();
        var savedMedicines = new ArrayList<Integer>();
        var unsavedMedicines = new ArrayList<Integer>();

        medicines.forEach(idMedicament -> {
            if (validateMedicineId(idMedicament)) {
                savedMedicines.add(idMedicament);
                prescriptionMedicineRepository.save(prescriptionMedicineRequestToEntity(idPrescriptie, request.stream()
                        .filter(item -> item.getIdMedicament().equals(idMedicament))
                        .findFirst()
                        .orElseThrow()));
            } else {
                unsavedMedicines.add(idMedicament);
            }
        });

        response.setSavedMedicines(savedMedicines);
        response.setUnsavedMedicines(unsavedMedicines);

        return response;
    }

    @Override
    @Transactional(readOnly = true)
    public List<MedicineEntity> getMedicinesByPrescriptionId(Integer idPrescriptie) {
        validatePrescriptionId(idPrescriptie);
        List<MedicineEntity> medicines = new ArrayList<>();
        var prescription = prescriptionRepository.findById(idPrescriptie);
        if (prescription.isPresent()) {
            medicines = prescriptionMedicineRepository.findByPrescriptie(prescription.get())
                    .stream()
                    .map(PrescriptionMedicineEntity::getMedicament)
                    .toList();
        }
        return medicines;
    }

    private void validatePrescriptionId(Integer idPrescriptie) {
        prescriptionRepository.findById(idPrescriptie).orElseThrow(() -> {
            log.error("idPrescriptie {} is invalid", idPrescriptie);
            throw new ServiceException(ErrorCodes.INVALID_PARAMETER,
                    MessageFormat.format(ErrorCodes.INVALID_PARAMETER.getErrorMessage(), "idPrescriptie"));
        });
    }

    private boolean validateMedicineId(Integer idMedicament) {
        return medicineRepository.findById(idMedicament).isPresent();
    }

    private PrescriptionMedicineEntity prescriptionMedicineRequestToEntity(int idPrescriptie, PrescriptionMedicineRequest request) {
        var response = new PrescriptionMedicineEntity();

        var medicine = medicineRepository.findById(request.getIdMedicament());
        medicine.ifPresent(response::setMedicament);
        var prescription = prescriptionRepository.findById(idPrescriptie);
        prescription.ifPresent(response::setPrescriptie);
        response.setNumarMedicamente(request.getNrMedicamente());

        return response;
    }
}
