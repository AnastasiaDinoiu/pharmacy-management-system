package com.bdproject.pharmacy.dto.request;

import lombok.Getter;

@Getter
public class MedicineRequest {

    private String dci;
    private String denumireComerciala;
    private String formaFarmaceutica;
    private String concentratie;
    private Integer idProducator;
}
