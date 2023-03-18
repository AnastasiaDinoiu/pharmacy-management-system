package com.bdproject.pharmacy.controller;

import com.bdproject.pharmacy.dto.request.RecipeMedicineRequest;
import com.bdproject.pharmacy.dto.response.RecipeMedicineResponse;
import com.bdproject.pharmacy.model.MedicineEntity;
import com.bdproject.pharmacy.service.RecipeMedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecipeMedicineController {

    private final RecipeMedicineService recipeMedicineService;

    @PostMapping(path = "pharmacy/recipes/{id}/medicines")
    public ResponseEntity<RecipeMedicineResponse> insertMedicinesInRecipe(@PathVariable Integer id, @Valid @RequestBody List<RecipeMedicineRequest> request) {
        return ResponseEntity.ok(recipeMedicineService.insertMedicinesInRecipe(id, request));
    }

    @GetMapping(path = "pharmacy/recipes/{id}/medicines")
    public ResponseEntity<List<MedicineEntity>> getMedicinesByRecipeId(@PathVariable Integer id) {
        return ResponseEntity.ok(recipeMedicineService.getMedicinesByRecipeId(id));
    }
}
