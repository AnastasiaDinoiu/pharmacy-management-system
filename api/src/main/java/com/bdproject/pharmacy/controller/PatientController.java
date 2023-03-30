package com.bdproject.Pacientpharmacy.controller;

import com.bdproject.pharmacy.dto.request.PatientRequest;
import com.bdproject.pharmacy.model.PatientEntity;
import com.bdproject.pharmacy.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping(path = "pharmacy/patients")
    public ResponseEntity<Integer> createPatient(@Valid @RequestBody PatientRequest request) {
        return ResponseEntity.ok(patientService.createPatient(request));
    }

    @PutMapping(path = "pharmacy/patients/{id}")
    public ResponseEntity<Integer> updatePatient(@PathVariable Integer id, @Valid @RequestBody PatientRequest request) {
        return ResponseEntity.ok(patientService.updatePatient(id, request));
    }

    @DeleteMapping(path = "pharmacy/patients/{id}")
    public void deletePatient(@PathVariable Integer id) {
        patientService.deletePatient(id);
    }

    @GetMapping(path = "pharmacy/patients/{id}")
    public ResponseEntity<PatientEntity> getPatientById(@PathVariable Integer id) {
        return ResponseEntity.ok(patientService.getPatientById(id));
    }

    @GetMapping(path = "pharmacy/patients")
    public ResponseEntity<List<PatientEntity>> getpatients() {
        return ResponseEntity.ok(patientService.getPatients());
    }
}
