package com.bdproject.pharmacy.service;

import com.bdproject.pharmacy.dto.request.PatientRequest;
import com.bdproject.pharmacy.model.PatientEntity;

import java.util.List;

public interface PatientService {

    Integer createPatient(PatientRequest request);

    Integer updatePatient(Integer idPacient, PatientRequest request);

    void deletePatient(Integer idPacient);

    PatientEntity getPatientById(Integer idPacient);

    List<PatientEntity> getPatients();
}
