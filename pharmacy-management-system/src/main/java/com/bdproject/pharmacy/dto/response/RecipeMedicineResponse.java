package com.bdproject.pharmacy.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RecipeMedicineResponse {

    List<Integer> savedMedicines;
    List<Integer> unsavedMedicines;
}
