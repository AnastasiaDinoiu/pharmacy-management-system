package com.bdproject.pharmacy.service;

import com.bdproject.pharmacy.dto.request.EmployeeRequest;
import com.bdproject.pharmacy.model.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    Integer createEmployee(EmployeeRequest request);

    Integer updateEmployee(Integer idAngajat, EmployeeRequest request);

    void deleteEmployee(Integer idAngajat);

    EmployeeEntity getEmployeeById(Integer idAngajat);

    List<EmployeeEntity> getEmployees();
}
