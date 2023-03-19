package com.bdproject.pharmacy.controller;

import com.bdproject.pharmacy.dto.request.PrescriptionMedicineRequest;
import com.bdproject.pharmacy.dto.response.PrescriptionMedicineResponse;
import com.bdproject.pharmacy.model.MedicineEntity;
import com.bdproject.pharmacy.service.PrescriptionMedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PrescriptionMedicineController {

    private final PrescriptionMedicineService prescriptionMedicineService;

    @PostMapping(path = "pharmacy/prescriptions/{id}/medicines")
    public ResponseEntity<PrescriptionMedicineResponse> insertMedicinesInPrescription(@PathVariable Integer id, @Valid @RequestBody List<PrescriptionMedicineRequest> request) {
        return ResponseEntity.ok(prescriptionMedicineService.insertMedicinesInPrescription(id, request));
    }

    @GetMapping(path = "pharmacy/prescriptions/{id}/medicines")
    public ResponseEntity<List<MedicineEntity>> getMedicinesByPrescriptionId(@PathVariable Integer id) {
        return ResponseEntity.ok(prescriptionMedicineService.getMedicinesByPrescriptionId(id));
    }
}
