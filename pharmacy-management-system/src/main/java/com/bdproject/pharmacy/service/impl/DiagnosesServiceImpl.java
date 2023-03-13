package com.bdproject.pharmacy.service.impl;

import com.bdproject.pharmacy.exception.ErrorCodes;
import com.bdproject.pharmacy.exception.ServiceException;
import com.bdproject.pharmacy.model.DiagnoseEntity;
import com.bdproject.pharmacy.repository.DiagnoseRepository;
import com.bdproject.pharmacy.service.DiagnosesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;


@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class DiagnosesServiceImpl implements DiagnosesService {

    @Autowired
    private final DiagnoseRepository diagnoseRepository;

    @Override
    public DiagnoseEntity createDiagnose(String numeDiagnostic) {
        if (Objects.isNull(numeDiagnostic)) {
            log.error("numeDiagnostic is not set on create request");
            throw new ServiceException(ErrorCodes.MISSING_PARAMETER,
                    MessageFormat.format(ErrorCodes.MISSING_PARAMETER.getErrorMessage(), "numeDiagnostic"));
        }
        DiagnoseEntity diagnose = new DiagnoseEntity();
        diagnose.setNumeDiagnostic(numeDiagnostic);

        return diagnoseRepository.save(diagnose);
    }

    @Override
    public DiagnoseEntity updateDiagnose(DiagnoseEntity diagnoseRequest) {
        validateParametersForUpdate(diagnoseRequest);

        DiagnoseEntity diagnose = new DiagnoseEntity();
        diagnose.setIdDiagnostic(diagnoseRequest.getIdDiagnostic());
        diagnose.setNumeDiagnostic(diagnoseRequest.getNumeDiagnostic());

        return diagnoseRepository.save(diagnose);
    }

    @Override
    public void deleteDiagnose(Integer idDiagnostic) {
        diagnoseRepository.findById(idDiagnostic).orElseThrow(() -> {
            log.error("idDiagnostic {} is invalid", idDiagnostic);
            throw new ServiceException(ErrorCodes.INVALID_PARAMETER,
                    MessageFormat.format(ErrorCodes.INVALID_PARAMETER.getErrorMessage(), "idDiagnostic"));
        });

        diagnoseRepository.deleteById(idDiagnostic);
    }

    @Override
    @Transactional(readOnly = true)
    public DiagnoseEntity getDiagnoseById(Integer idDiagnostic) {
        return diagnoseRepository.findById(idDiagnostic).orElseThrow(() -> {
            log.error("idDiagnostic {} is invalid", idDiagnostic);
            throw new ServiceException(ErrorCodes.INVALID_PARAMETER,
                    MessageFormat.format(ErrorCodes.INVALID_PARAMETER.getErrorMessage(), "idDiagnostic"));
        });
    }

    @Override
    @Transactional(readOnly = true)
    public List<DiagnoseEntity> getDiagnoses() {
        return diagnoseRepository.findAll();
    }

    private void validateParametersForUpdate(DiagnoseEntity diagnoseRequest) {
        if (Objects.isNull(diagnoseRequest.getIdDiagnostic())) {
            log.error("idDiagnostic is not set on update request");
            throw new ServiceException(ErrorCodes.MISSING_PARAMETER,
                    MessageFormat.format(ErrorCodes.MISSING_PARAMETER.getErrorMessage(), "idDiagnostic"));
        }
        diagnoseRepository.findById(diagnoseRequest.getIdDiagnostic()).orElseThrow(() -> {
            log.error("idDiagnostic {} is invalid", diagnoseRequest.getIdDiagnostic());
            throw new ServiceException(ErrorCodes.INVALID_PARAMETER,
                    MessageFormat.format(ErrorCodes.INVALID_PARAMETER.getErrorMessage(), "idDiagnostic"));
        });
        if (Objects.isNull(diagnoseRequest.getNumeDiagnostic())) {
            log.error("numeDiagnostic is not set on update request");
            throw new ServiceException(ErrorCodes.MISSING_PARAMETER,
                    MessageFormat.format(ErrorCodes.MISSING_PARAMETER.getErrorMessage(), "numeDiagnostic"));
        }
    }
}
