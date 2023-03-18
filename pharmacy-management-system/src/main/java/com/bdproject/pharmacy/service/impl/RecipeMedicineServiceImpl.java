package com.bdproject.pharmacy.service.impl;

import com.bdproject.pharmacy.dto.request.RecipeMedicineRequest;
import com.bdproject.pharmacy.dto.response.RecipeMedicineResponse;
import com.bdproject.pharmacy.exception.ErrorCodes;
import com.bdproject.pharmacy.exception.ServiceException;
import com.bdproject.pharmacy.model.MedicineEntity;
import com.bdproject.pharmacy.model.RecipeMedicineEntity;
import com.bdproject.pharmacy.repository.MedicineRepository;
import com.bdproject.pharmacy.repository.RecipeMedicineRepository;
import com.bdproject.pharmacy.repository.RecipeRepository;
import com.bdproject.pharmacy.service.RecipeMedicineService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class RecipeMedicineServiceImpl implements RecipeMedicineService {
    @Autowired
    RecipeMedicineRepository recipeMedicineRepository;
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    MedicineRepository medicineRepository;

    @Override
    public RecipeMedicineResponse insertMedicinesInRecipe(Integer idReteta, List<RecipeMedicineRequest> request) {
        validateRecipeId(idReteta);
        var response = new RecipeMedicineResponse();
        var medicines = request.stream()
                .map(RecipeMedicineRequest::getIdMedicament)
                .toList();
        var savedMedicines = new ArrayList<Integer>();
        var unsavedMedicines = new ArrayList<Integer>();

        medicines.forEach(idMedicament -> {
            if (validateMedicineId(idMedicament)) {
                savedMedicines.add(idMedicament);
                recipeMedicineRepository.save(recipeMedicineRequestToEntity(idReteta, request.stream()
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
    public List<MedicineEntity> getMedicinesByRecipeId(Integer idReteta) {
        validateRecipeId(idReteta);
        List<MedicineEntity> medicines = new ArrayList<>();
        var recipe = recipeRepository.findById(idReteta);
        if (recipe.isPresent()) {
            medicines = recipeMedicineRepository.findByReteta(recipe.get())
                    .stream()
                    .map(RecipeMedicineEntity::getMedicament)
                    .toList();
        }
        return medicines;
    }

    private void validateRecipeId(Integer idReteta) {
        recipeRepository.findById(idReteta).orElseThrow(() -> {
            log.error("idReteta {} is invalid", idReteta);
            throw new ServiceException(ErrorCodes.INVALID_PARAMETER,
                    MessageFormat.format(ErrorCodes.INVALID_PARAMETER.getErrorMessage(), "idReteta"));
        });
    }

    private boolean validateMedicineId(Integer idMedicament) {
        return medicineRepository.findById(idMedicament).isPresent();
    }

    private RecipeMedicineEntity recipeMedicineRequestToEntity(int idReteta, RecipeMedicineRequest request) {
        var response = new RecipeMedicineEntity();

        var medicine = medicineRepository.findById(request.getIdMedicament());
        medicine.ifPresent(response::setMedicament);
        var recipe = recipeRepository.findById(idReteta);
        recipe.ifPresent(response::setReteta);
        response.setNumarMedicamente(request.getNrMedicamente());

        return response;
    }
}
