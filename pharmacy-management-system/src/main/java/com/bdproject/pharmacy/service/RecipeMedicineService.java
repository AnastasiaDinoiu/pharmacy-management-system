package com.bdproject.pharmacy.service;

import com.bdproject.pharmacy.dto.request.RecipeMedicineRequest;
import com.bdproject.pharmacy.dto.response.RecipeMedicineResponse;
import com.bdproject.pharmacy.model.MedicineEntity;

import java.util.List;

public interface RecipeMedicineService {

    RecipeMedicineResponse insertMedicinesInRecipe(Integer idReteta, List<RecipeMedicineRequest> request);

    List<MedicineEntity> getMedicinesByRecipeId(Integer idReteta);
}
