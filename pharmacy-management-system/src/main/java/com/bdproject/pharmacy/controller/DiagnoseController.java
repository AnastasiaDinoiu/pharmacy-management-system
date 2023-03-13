package com.bdproject.pharmacy.controller;

import com.bdproject.pharmacy.model.DiagnoseEntity;
import com.bdproject.pharmacy.service.DiagnosesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DiagnoseController {

    private final DiagnosesService diagnosesService;

    @PostMapping(path = "pharmacy/diagnoses")
    public ResponseEntity<DiagnoseEntity> createDiagnose(@Valid @RequestParam String numeDiagnostic) {
        return ResponseEntity.ok(diagnosesService.createDiagnose(numeDiagnostic));
    }

    @PutMapping(path = "pharmacy/diagnoses")
    public ResponseEntity<DiagnoseEntity> updateDiagnose(@Valid @RequestBody DiagnoseEntity diagnose) {
        return ResponseEntity.ok(diagnosesService.updateDiagnose(diagnose));
    }

    @DeleteMapping(path = "pharmacy/diagnoses/{id}")
    public void deleteDiagnose(@PathVariable Integer id) {
        diagnosesService.deleteDiagnose(id);
    }

    @GetMapping(path = "pharmacy/diagnoses/{id}")
    public ResponseEntity<DiagnoseEntity> getDiagnoseById(@PathVariable Integer id) {
        return ResponseEntity.ok(diagnosesService.getDiagnoseById(id));
    }

    @GetMapping(path = "pharmacy/diagnoses")
    public ResponseEntity<List<DiagnoseEntity>> getDiagnoses() {
        return ResponseEntity.ok(diagnosesService.getDiagnoses());
    }
}
