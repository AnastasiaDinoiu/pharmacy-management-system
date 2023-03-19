package com.bdproject.pharmacy.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PrescriptionMedicineResponse {

    List<Integer> savedMedicines;
    List<Integer> unsavedMedicines;
}
