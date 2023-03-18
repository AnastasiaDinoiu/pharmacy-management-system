package com.bdproject.pharmacy.controller;

import com.bdproject.pharmacy.model.ProducerEntity;
import com.bdproject.pharmacy.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProducerController {
    
    private final ProducerService producerService;

    @PostMapping(path = "pharmacy/producers")
    public ResponseEntity<Integer> createProducer(@Valid @RequestParam String producator, @Valid @RequestParam String tara) {
        return ResponseEntity.ok(producerService.createProducer(producator, tara));
    }

    @PutMapping(path = "pharmacy/producers/{id}")
    public ResponseEntity<Integer> updateProducer(@PathVariable Integer id, @Valid @RequestParam String producator, @Valid @RequestParam String tara) {
        return ResponseEntity.ok(producerService.updateProducer(id, producator, tara));
    }

    @DeleteMapping(path = "pharmacy/producers/{id}")
    public void deleteProducer(@PathVariable Integer id) {
        producerService.deleteProducer(id);
    }

    @GetMapping(path = "pharmacy/producers/{id}")
    public ResponseEntity<ProducerEntity> getProducerById(@PathVariable Integer id) {
        return ResponseEntity.ok(producerService.getProducerById(id));
    }

    @GetMapping(path = "pharmacy/producers")
    public ResponseEntity<List<ProducerEntity>> getProducers() {
        return ResponseEntity.ok(producerService.getProducers());
    }
}
