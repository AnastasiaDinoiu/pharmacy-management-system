package com.bdproject.pharmacy.controller;

import com.bdproject.pharmacy.dto.request.EmployeeRequest;
import com.bdproject.pharmacy.model.EmployeeEntity;
import com.bdproject.pharmacy.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    
    private final EmployeeService employeeService;

    @PostMapping(path = "pharmacy/employees")
    public ResponseEntity<Integer> createEmployee(@Valid @RequestBody EmployeeRequest request) {
        return ResponseEntity.ok(employeeService.createEmployee(request));
    }

    @PutMapping(path = "pharmacy/employees/{id}")
    public ResponseEntity<Integer> updateEmployee(@PathVariable Integer id, @Valid @RequestBody EmployeeRequest request) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, request));
    }

    @DeleteMapping(path = "pharmacy/employees/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping(path = "pharmacy/employees/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable Integer id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping(path = "pharmacy/employees")
    public ResponseEntity<List<EmployeeEntity>> getEmployees() {
        return ResponseEntity.ok(employeeService.getEmployees());
    }
}
