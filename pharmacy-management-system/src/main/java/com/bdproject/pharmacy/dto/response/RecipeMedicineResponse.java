package com.bdproject.pharmacy.dto.response;

import lombok.Setter;

import java.util.List;

@Setter
public class RecipeMedicineResponse {

    List<Integer> savedMedicines;
    List<Integer> unsavedMedicines;
}
