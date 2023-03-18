package com.bdproject.pharmacy.service.impl;

import com.bdproject.pharmacy.dto.request.RecipeRequest;
import com.bdproject.pharmacy.exception.ErrorCodes;
import com.bdproject.pharmacy.exception.ServiceException;
import com.bdproject.pharmacy.model.RecipeEntity;
import com.bdproject.pharmacy.repository.*;
import com.bdproject.pharmacy.service.RecipeService;
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
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final EmployeeRepository employeeRepository;
    private final PatientRepository patientRepository;
    private final PrescribingDoctorRepository doctorRepository;
    private final DiagnoseRepository diagnoseRepository;

    @Override
    public Integer createRecipe(RecipeRequest request) {
        validateParameters(request);

        return recipeRepository.save(recipeRequestToEntity(request)).getIdReteta();
    }

    @Override
    public Integer updateRecipe(Integer idReteta, RecipeRequest request) {
        validateId(idReteta);
        validateParameters(request);
        var updatedRecipe = recipeRequestToEntity(request);
        updatedRecipe.setIdReteta(idReteta);

        return recipeRepository.save(updatedRecipe).getIdReteta();
    }

    @Override
    public void deleteRecipe(Integer idReteta) {
        validateId(idReteta);
        recipeRepository.deleteById(idReteta);
    }

    @Override
    @Transactional(readOnly = true)
    public RecipeEntity getRecipeById(Integer idReteta) {
        return recipeRepository.findById(idReteta).orElseThrow(() -> {
            log.error("idReteta {} is invalid", idReteta);
            throw new ServiceException(ErrorCodes.INVALID_PARAMETER,
                    MessageFormat.format(ErrorCodes.INVALID_PARAMETER.getErrorMessage(), "idReteta"));
        });
    }

    @Override
    @Transactional(readOnly = true)
    public List<RecipeEntity> getRecipes() {
        return recipeRepository.findAll();
    }

    private void validateParameters(RecipeRequest request) {
        if (Objects.isNull(request.getIdPacient())) {
            log.error("idPacient is not set on request");
            throw new ServiceException(ErrorCodes.MISSING_PARAMETER,
                    MessageFormat.format(ErrorCodes.MISSING_PARAMETER.getErrorMessage(), "idPacient"));
        }
        patientRepository.findById(request.getIdPacient()).orElseThrow(() -> {
            log.error("idPacient {} is invalid", request.getIdPacient());
            throw new ServiceException(ErrorCodes.INVALID_PARAMETER,
                    MessageFormat.format(ErrorCodes.INVALID_PARAMETER.getErrorMessage(), "idPacient"));
        });
        if (Objects.isNull(request.getIdDiagnostic())) {
            log.error("idDiagnostic is not set on request");
            throw new ServiceException(ErrorCodes.MISSING_PARAMETER,
                    MessageFormat.format(ErrorCodes.MISSING_PARAMETER.getErrorMessage(), "idDiagnostic"));
        }
        diagnoseRepository.findById(request.getIdDiagnostic()).orElseThrow(() -> {
            log.error("idDiagnostic {} is invalid", request.getIdDiagnostic());
            throw new ServiceException(ErrorCodes.INVALID_PARAMETER,
                    MessageFormat.format(ErrorCodes.INVALID_PARAMETER.getErrorMessage(), "idDiagnostic"));
        });
        if (Objects.isNull(request.getIdAngajat())) {
            log.error("idAngajat is not set on request");
            throw new ServiceException(ErrorCodes.MISSING_PARAMETER,
                    MessageFormat.format(ErrorCodes.MISSING_PARAMETER.getErrorMessage(), "idAngajat"));
        }
        employeeRepository.findById(request.getIdAngajat()).orElseThrow(() -> {
            log.error("idAngajat {} is invalid", request.getIdAngajat());
            throw new ServiceException(ErrorCodes.INVALID_PARAMETER,
                    MessageFormat.format(ErrorCodes.INVALID_PARAMETER.getErrorMessage(), "idAngajat"));
        });
        if (Objects.isNull(request.getIdMedicPrescriptor())) {
            log.error("idMedicPrescriptor is not set on request");
            throw new ServiceException(ErrorCodes.MISSING_PARAMETER,
                    MessageFormat.format(ErrorCodes.MISSING_PARAMETER.getErrorMessage(), "idMedicPrescriptor"));
        }
        doctorRepository.findById(request.getIdMedicPrescriptor()).orElseThrow(() -> {
            log.error("idMedicPrescriptor {} is invalid", request.getIdMedicPrescriptor());
            throw new ServiceException(ErrorCodes.INVALID_PARAMETER,
                    MessageFormat.format(ErrorCodes.INVALID_PARAMETER.getErrorMessage(), "idMedicPrescriptor"));
        });
        if (Objects.isNull(request.getTipTratament())) {
            log.error("tipTratament is not set on request");
            throw new ServiceException(ErrorCodes.MISSING_PARAMETER,
                    MessageFormat.format(ErrorCodes.MISSING_PARAMETER.getErrorMessage(), "tipTratament"));
        }
        if (Objects.isNull(request.getDataPrescriere())) {
            log.error("dataPrescriere is not set on request");
            throw new ServiceException(ErrorCodes.MISSING_PARAMETER,
                    MessageFormat.format(ErrorCodes.MISSING_PARAMETER.getErrorMessage(), "dataPrescriere"));
        }
    }

    private RecipeEntity recipeRequestToEntity(RecipeRequest request) {
        RecipeEntity response = new RecipeEntity();

        var patient = patientRepository.findById(request.getIdPacient());
        patient.ifPresent(response::setPacient);
        var diagnose = diagnoseRepository.findById(request.getIdDiagnostic());
        diagnose.ifPresent(response::setDiagnostic);
        var employee = employeeRepository.findById(request.getIdAngajat());
        employee.ifPresent(response::setAngajat);
        var doctor = doctorRepository.findById(request.getIdMedicPrescriptor());
        doctor.ifPresent(response::setMedicPrescriptor);
        response.setTipTratament(request.getTipTratament());
        response.setDataPrescriere(request.getDataPrescriere());

        return response;
    }

    private void validateId(Integer idReteta) {
        recipeRepository.findById(idReteta).orElseThrow(() -> {
            log.error("idReteta {} is invalid", idReteta);
            throw new ServiceException(ErrorCodes.INVALID_PARAMETER,
                    MessageFormat.format(ErrorCodes.INVALID_PARAMETER.getErrorMessage(), "idReteta"));
        });
    }
}
