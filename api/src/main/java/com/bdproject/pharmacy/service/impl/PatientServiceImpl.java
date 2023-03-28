package com.bdproject.pharmacy.service.impl;

import com.bdproject.pharmacy.dto.request.PatientRequest;
import com.bdproject.pharmacy.exception.ErrorCodes;
import com.bdproject.pharmacy.exception.ServiceException;
import com.bdproject.pharmacy.model.PatientEntity;
import com.bdproject.pharmacy.repository.PatientRepository;
import com.bdproject.pharmacy.service.PatientService;
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
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public Integer createPatient(PatientRequest request) {
        validateParameters(request);

        return patientRepository.save(patientRequestToEntity(request)).getIdPacient();
    }

    @Override
    public Integer updatePatient(Integer idPacient, PatientRequest request) {
        validateId(idPacient);
        validateParameters(request);
        var updatedPatient = patientRequestToEntity(request);
        updatedPatient.setIdPacient(idPacient);

        return patientRepository.save(updatedPatient).getIdPacient();
    }

    @Override
    public void deletePatient(Integer idPacient) {
        validateId(idPacient);
        patientRepository.deleteById(idPacient);
    }

    @Override
    @Transactional(readOnly = true)
    public PatientEntity getPatientById(Integer idPacient) {
        return patientRepository.findById(idPacient).orElseThrow(() -> {
            log.error("idPacient {} is invalid", idPacient);
            throw new ServiceException(ErrorCodes.INVALID_PARAMETER,
                    MessageFormat.format(ErrorCodes.INVALID_PARAMETER.getErrorMessage(), "idPacient"));
        });
    }

    @Override
    @Transactional(readOnly = true)
    public List<PatientEntity> getPatients() {
        return patientRepository.findAll();
    }

    private void validateParameters(PatientRequest request) {
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
    }

    private PatientEntity patientRequestToEntity(PatientRequest request) {
        PatientEntity response = new PatientEntity();

        response.setNumePacient(request.getNume());
        response.setPrenumePacient(request.getPrenume());
        response.setCnpPacient(request.getCnp());

        return response;
    }

    private void validateId(Integer idPacient) {
        patientRepository.findById(idPacient).orElseThrow(() -> {
            log.error("idPacient {} is invalid", idPacient);
            throw new ServiceException(ErrorCodes.INVALID_PARAMETER,
                    MessageFormat.format(ErrorCodes.INVALID_PARAMETER.getErrorMessage(), "idPacient"));
        });
    }
}
