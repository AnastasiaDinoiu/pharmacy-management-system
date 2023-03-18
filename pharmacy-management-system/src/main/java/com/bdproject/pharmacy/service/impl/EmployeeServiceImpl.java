package com.bdproject.pharmacy.service.impl;

import com.bdproject.pharmacy.dto.request.EmployeeRequest;
import com.bdproject.pharmacy.exception.ErrorCodes;
import com.bdproject.pharmacy.exception.ServiceException;
import com.bdproject.pharmacy.model.EmployeeEntity;
import com.bdproject.pharmacy.repository.EmployeeRepository;
import com.bdproject.pharmacy.repository.JobRepository;
import com.bdproject.pharmacy.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final JobRepository jobRepository;

    @Override
    public Integer createEmployee(EmployeeRequest request) {
        validateParameters(request);

        return employeeRepository.save(employeeRequestToEntity(request)).getIdAngajat();
    }

    @Override
    public Integer updateEmployee(Integer idAngajat, EmployeeRequest request) {
        validateId(idAngajat);
        validateParameters(request);
        var updatedEmployee = employeeRequestToEntity(request);
        updatedEmployee.setIdAngajat(idAngajat);

        return employeeRepository.save(updatedEmployee).getIdAngajat();
    }

    @Override
    public void deleteEmployee(Integer idAngajat) {
        validateId(idAngajat);
        employeeRepository.deleteById(idAngajat);
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeEntity getEmployeeById(Integer idAngajat) {
        return employeeRepository.findById(idAngajat).orElseThrow(() -> {
            log.error("idAngajat {} is invalid", idAngajat);
            throw new ServiceException(ErrorCodes.INVALID_PARAMETER,
                    MessageFormat.format(ErrorCodes.INVALID_PARAMETER.getErrorMessage(), "idAngajat"));
        });
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeEntity> getEmployees() {
        return employeeRepository.findAll();
    }

    private void validateParameters(EmployeeRequest request) {
        if (Objects.isNull(request.getNume())) {
            log.error("nume is not set on request");
            throw new ServiceException(ErrorCodes.MISSING_PARAMETER,
                    MessageFormat.format(ErrorCodes.MISSING_PARAMETER.getErrorMessage(), "nume"));
        }
        if (Objects.isNull(request.getPrenume())) {
            log.error("prenume is not set on request");
            throw new ServiceException(ErrorCodes.MISSING_PARAMETER,
                    MessageFormat.format(ErrorCodes.MISSING_PARAMETER.getErrorMessage(), "prenume"));
        }
        if (Objects.isNull(request.getCnp())) {
            log.error("cnp is not set on request");
            throw new ServiceException(ErrorCodes.MISSING_PARAMETER,
                    MessageFormat.format(ErrorCodes.MISSING_PARAMETER.getErrorMessage(), "cnp"));
        }
        if (Objects.isNull(request.getIdPost())) {
            log.error("idPost is not set on request");
            throw new ServiceException(ErrorCodes.MISSING_PARAMETER,
                    MessageFormat.format(ErrorCodes.MISSING_PARAMETER.getErrorMessage(), "idPost"));
        }
        jobRepository.findById(request.getIdPost()).orElseThrow(() -> {
            log.error("idPost {} is invalid", request.getIdPost());
            throw new ServiceException(ErrorCodes.INVALID_PARAMETER,
                    MessageFormat.format(ErrorCodes.INVALID_PARAMETER.getErrorMessage(), "idPost"));
        });
        if (Objects.isNull(request.getEmail())) {
            log.error("email is not set on request");
            throw new ServiceException(ErrorCodes.MISSING_PARAMETER,
                    MessageFormat.format(ErrorCodes.MISSING_PARAMETER.getErrorMessage(), "email"));
        }
        if (Objects.isNull(request.getTelefon())) {
            log.error("telefon is not set on request");
            throw new ServiceException(ErrorCodes.MISSING_PARAMETER,
                    MessageFormat.format(ErrorCodes.MISSING_PARAMETER.getErrorMessage(), "telefon"));
        }
    }

    private EmployeeEntity employeeRequestToEntity(EmployeeRequest request) {
        EmployeeEntity response = new EmployeeEntity();

        response.setNumeAngajat(request.getNume());
        response.setPrenumeAngajat(request.getPrenume());
        response.setCnpAngajat(request.getCnp());
        var job = jobRepository.findById(request.getIdPost());
        job.ifPresent(response::setPost);
        response.setEmailAngajat(request.getEmail());
        response.setTelefonAngajat(request.getTelefon());

        return response;
    }

    private void validateId(Integer idAngajat) {
        employeeRepository.findById(idAngajat).orElseThrow(() -> {
            log.error("idAngajat {} is invalid", idAngajat);
            throw new ServiceException(ErrorCodes.INVALID_PARAMETER,
                    MessageFormat.format(ErrorCodes.INVALID_PARAMETER.getErrorMessage(), "idAngajat"));
        });
    }
}
