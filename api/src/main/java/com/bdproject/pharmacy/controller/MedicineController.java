package com.bdproject.pharmacy.controller;

import com.bdproject.pharmacy.dto.request.MedicineRequest;
import com.bdproject.pharmacy.model.MedicineEntity;
import com.bdproject.pharmacy.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MedicineController {

    private final MedicineService medicineService;

    @PostMapping(path = "pharmacy/medicines")
    public ResponseEntity<Integer> createMedicine(@Valid @RequestBody MedicineRequest request) {
        return ResponseEntity.ok(medicineService.createMedicine(request));
    }

    @PutMapping(path = "pharmacy/medicines/{id}")
    public ResponseEntity<Integer> updateMedicine(@PathVariable Integer id, @Valid @RequestBody MedicineRequest request) {
        return ResponseEntity.ok(medicineService.updateMedicine(id, request));
    }

    @DeleteMapping(path = "pharmacy/medicines/{id}")
    public void deleteMedicine(@PathVariable Integer id) {
        medicineService.deleteMedicine(id);
    }

    @GetMapping(path = "pharmacy/medicines/{id}")
    public ResponseEntity<MedicineEntity> getMedicineById(@PathVariable Integer id) {
        return ResponseEntity.ok(medicineService.getMedicineById(id));
    }

    @GetMapping(path = "pharmacy/medicines")
    public ResponseEntity<List<MedicineEntity>> getMedicines() {
        return ResponseEntity.ok(medicineService.getMedicines());
    }
}
