package com.bdproject.pharmacy.controller;

import com.bdproject.pharmacy.dto.request.PrescriptionRequest;
import com.bdproject.pharmacy.model.PrescriptionEntity;
import com.bdproject.pharmacy.service.PrescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PrescriptionController {
    
    private final PrescriptionService prescriptionService;

    @PostMapping(path = "pharmacy/prescriptions")
    public ResponseEntity<Integer> createPrescription(@Valid @RequestBody PrescriptionRequest request) {
        return ResponseEntity.ok(prescriptionService.createPrescription(request));
    }

    @PutMapping(path = "pharmacy/prescriptions/{id}")
    public ResponseEntity<Integer> updatePrescription(@PathVariable Integer id, @Valid @RequestBody PrescriptionRequest request) {
        return ResponseEntity.ok(prescriptionService.updatePrescription(id, request));
    }

    @DeleteMapping(path = "pharmacy/prescriptions/{id}")
    public void deletePrescription(@PathVariable Integer id) {
        prescriptionService.deletePrescription(id);
    }

    @GetMapping(path = "pharmacy/prescriptions/{id}")
    public ResponseEntity<PrescriptionEntity> getPrescriptionById(@PathVariable Integer id) {
        return ResponseEntity.ok(prescriptionService.getPrescriptionById(id));
    }

    @GetMapping(path = "pharmacy/prescriptions")
    public ResponseEntity<List<PrescriptionEntity>> getPrescriptions() {
        return ResponseEntity.ok(prescriptionService.getPrescriptions());
    }
}
