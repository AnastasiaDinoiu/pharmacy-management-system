package com.bdproject.pharmacy.controller;

import com.bdproject.pharmacy.dto.request.JobRequest;
import com.bdproject.pharmacy.model.JobEntity;
import com.bdproject.pharmacy.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @PostMapping(path = "pharmacy/jobs")
    public ResponseEntity<Integer> createJob(@Valid @RequestBody JobRequest request) {
        return ResponseEntity.ok(jobService.createJob(request));
    }

    @PutMapping(path = "pharmacy/jobs/{id}")
    public ResponseEntity<Integer> updateJob(@PathVariable Integer id, @Valid @RequestBody JobRequest request) {
        return ResponseEntity.ok(jobService.updateJob(id, request));
    }

    @DeleteMapping(path = "pharmacy/jobs/{id}")
    public void deleteJob(@PathVariable Integer id) {
        jobService.deleteJob(id);
    }

    @GetMapping(path = "pharmacy/jobs/{id}")
    public ResponseEntity<JobEntity> getJobById(@PathVariable Integer id) {
        return ResponseEntity.ok(jobService.getJobById(id));
    }

    @GetMapping(path = "pharmacy/jobs")
    public ResponseEntity<List<JobEntity>> getJobs() {
        return ResponseEntity.ok(jobService.getJobs());
    }
}
