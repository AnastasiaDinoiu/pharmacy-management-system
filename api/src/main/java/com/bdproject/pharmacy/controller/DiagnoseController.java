package com.bdproject.pharmacy.controller;

import com.bdproject.pharmacy.model.DiagnoseEntity;
import com.bdproject.pharmacy.service.DiagnoseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DiagnoseController {

    private final DiagnoseService diagnoseService;

    @PostMapping(path = "pharmacy/diagnoses")
    public ResponseEntity<Integer> createDiagnose(@Valid @RequestParam String numeDiagnostic) {
        return ResponseEntity.ok(diagnoseService.createDiagnose(numeDiagnostic));
    }

    @PutMapping(path = "pharmacy/diagnoses/{id}")
    public ResponseEntity<Integer> updateDiagnose(@PathVariable Integer id, @Valid @RequestParam String numeDiagnostic) {
        return ResponseEntity.ok(diagnoseService.updateDiagnose(id, numeDiagnostic));
    }

    @DeleteMapping(path = "pharmacy/diagnoses/{id}")
    public void deleteDiagnose(@PathVariable Integer id) {
        diagnoseService.deleteDiagnose(id);
    }

    @GetMapping(path = "pharmacy/diagnoses/{id}")
    public ResponseEntity<DiagnoseEntity> getDiagnoseById(@PathVariable Integer id) {
        return ResponseEntity.ok(diagnoseService.getDiagnoseById(id));
    }

    @GetMapping(path = "pharmacy/diagnoses")
    public ResponseEntity<List<DiagnoseEntity>> getDiagnoses() {
        return ResponseEntity.ok(diagnoseService.getDiagnoses());
    }
}
