package com.bdproject.pharmacy.service;

import com.bdproject.pharmacy.model.DiagnoseEntity;

import java.util.List;

public interface DiagnoseService {

    Integer createDiagnose(String numeDiagnostic);

    Integer updateDiagnose(Integer idDiagnostic, String numeDiagnostic);

    void deleteDiagnose(Integer idDiagnostic);

    DiagnoseEntity getDiagnoseById(Integer idDiagnostic);

    List<DiagnoseEntity> getDiagnoses();
}
