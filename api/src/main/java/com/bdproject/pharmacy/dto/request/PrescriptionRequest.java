package com.bdproject.pharmacy.dto.request;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PrescriptionRequest {

    private Integer idPacient;
    private Integer idDiagnostic;
    private Integer idAngajat;
    private Integer idMedicPrescriptor;
    private String tipTratament;
    private LocalDate dataPrescriere;
}
