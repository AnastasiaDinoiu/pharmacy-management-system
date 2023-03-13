package com.bdproject.pharmacy.service;

import com.bdproject.pharmacy.model.DiagnoseEntity;

import java.util.List;

public interface DiagnosesService {

    DiagnoseEntity createDiagnose(String numeDiagnostic);

    DiagnoseEntity updateDiagnose(DiagnoseEntity diagnoseRequest);

    void deleteDiagnose(Integer idDiagnostic);

    DiagnoseEntity getDiagnoseById(Integer idDiagnostic);

    List<DiagnoseEntity> getDiagnoses();
}
