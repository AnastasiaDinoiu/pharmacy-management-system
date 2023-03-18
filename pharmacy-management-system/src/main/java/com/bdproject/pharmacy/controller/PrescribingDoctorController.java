package com.bdproject.pharmacy.controller;

import com.bdproject.pharmacy.dto.request.DoctorRequest;
import com.bdproject.pharmacy.model.PrescribingDoctorEntity;
import com.bdproject.pharmacy.service.PrescribingDoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PrescribingDoctorController {

    private final PrescribingDoctorService doctorService;

    @PostMapping(path = "pharmacy/doctors")
    public ResponseEntity<Integer> createDoctor(@Valid @RequestBody DoctorRequest request) {
        return ResponseEntity.ok(doctorService.createDoctor(request));
    }

    @PutMapping(path = "pharmacy/doctors/{id}")
    public ResponseEntity<Integer> updateDoctor(@PathVariable Integer id, @Valid @RequestBody DoctorRequest request) {
        return ResponseEntity.ok(doctorService.updateDoctor(id, request));
    }

    @DeleteMapping(path = "pharmacy/doctors/{id}")
    public void deleteDoctor(@PathVariable Integer id) {
        doctorService.deleteDoctor(id);
    }

    @GetMapping(path = "pharmacy/doctors/{id}")
    public ResponseEntity<PrescribingDoctorEntity> getDoctorById(@PathVariable Integer id) {
        return ResponseEntity.ok(doctorService.getDoctorById(id));
    }

    @GetMapping(path = "pharmacy/doctors")
    public ResponseEntity<List<PrescribingDoctorEntity>> getDoctors() {
        return ResponseEntity.ok(doctorService.getDoctors());
    }
}
