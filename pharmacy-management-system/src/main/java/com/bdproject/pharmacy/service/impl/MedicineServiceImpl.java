package com.bdproject.pharmacy.service.impl;

import com.bdproject.pharmacy.dto.request.MedicineRequest;
import com.bdproject.pharmacy.exception.ErrorCodes;
import com.bdproject.pharmacy.exception.ServiceException;
import com.bdproject.pharmacy.model.MedicineEntity;
import com.bdproject.pharmacy.repository.MedicineRepository;
import com.bdproject.pharmacy.repository.ProducerRepository;
import com.bdproject.pharmacy.service.MedicineService;
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
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepository medicineRepository;
    private final ProducerRepository producerRepository;

    @Override
    public Integer createMedicine(MedicineRequest request) {
        validateParameters(request);

        return medicineRepository.save(medicineRequestToEntity(request)).getIdMedicament();
    }

    @Override
    public Integer updateMedicine(Integer idMedicament, MedicineRequest request) {
        validateId(idMedicament);
        validateParameters(request);
        var updatedMedicine = medicineRequestToEntity(request);
        updatedMedicine.setIdMedicament(idMedicament);

        return medicineRepository.save(updatedMedicine).getIdMedicament();
    }

    @Override
    public void deleteMedicine(Integer idMedicament) {
        validateId(idMedicament);
        medicineRepository.deleteById(idMedicament);
    }

    @Override
    @Transactional(readOnly = true)
    public MedicineEntity getMedicineById(Integer idMedicament) {
        return medicineRepository.findById(idMedicament).orElseThrow(() -> {
            log.error("idMedicament {} is invalid", idMedicament);
            throw new ServiceException(ErrorCodes.INVALID_PARAMETER,
                    MessageFormat.format(ErrorCodes.INVALID_PARAMETER.getErrorMessage(), "idMedicament"));
        });
    }

    @Override
    @Transactional(readOnly = true)
    public List<MedicineEntity> getMedicines() {
        return medicineRepository.findAll();
    }

    private void validateParameters(MedicineRequest request) {
        if (Objects.isNull(request.getDci())) {
            log.error("dci is not set on request");
            throw new ServiceException(ErrorCodes.MISSING_PARAMETER,
                    MessageFormat.format(ErrorCodes.MISSING_PARAMETER.getErrorMessage(), "dci"));
        }
        if (Objects.isNull(request.getDenumireComerciala())) {
            log.error("denumireComerciala is not set on request");
            throw new ServiceException(ErrorCodes.MISSING_PARAMETER,
                    MessageFormat.format(ErrorCodes.MISSING_PARAMETER.getErrorMessage(), "denumireComerciala"));
        }
        if (Objects.isNull(request.getFormaFarmaceutica())) {
            log.error("formaFarmaceutica is not set on request");
            throw new ServiceException(ErrorCodes.MISSING_PARAMETER,
                    MessageFormat.format(ErrorCodes.MISSING_PARAMETER.getErrorMessage(), "formaFarmaceutica"));
        }
        if (Objects.isNull(request.getConcentratie())) {
            log.error("concentratie is not set on request");
            throw new ServiceException(ErrorCodes.MISSING_PARAMETER,
                    MessageFormat.format(ErrorCodes.MISSING_PARAMETER.getErrorMessage(), "concentratie"));
        }
        if (Objects.isNull(request.getIdProducator())) {
            log.error("idProducator is not set on request");
            throw new ServiceException(ErrorCodes.MISSING_PARAMETER,
                    MessageFormat.format(ErrorCodes.MISSING_PARAMETER.getErrorMessage(), "idProducator"));
        }
        producerRepository.findById(request.getIdProducator()).orElseThrow(() -> {
            log.error("idProducator {} is invalid", request.getIdProducator());
            throw new ServiceException(ErrorCodes.INVALID_PARAMETER,
                    MessageFormat.format(ErrorCodes.INVALID_PARAMETER.getErrorMessage(), "idProducator"));
        });
    }

    private MedicineEntity medicineRequestToEntity(MedicineRequest request) {
        MedicineEntity response = new MedicineEntity();

        response.setDci(request.getDci());
        response.setDenumireComerciala(request.getDenumireComerciala());
        response.setFormaFarmaceutica(request.getFormaFarmaceutica());
        response.setConcentratie(request.getConcentratie());
        var producer = producerRepository.findById(request.getIdProducator());
        producer.ifPresent(response::setProducator);

        return response;
    }

    private void validateId(Integer idMedicament) {
        medicineRepository.findById(idMedicament).orElseThrow(() -> {
            log.error("idMedicament {} is invalid", idMedicament);
            throw new ServiceException(ErrorCodes.INVALID_PARAMETER,
                    MessageFormat.format(ErrorCodes.INVALID_PARAMETER.getErrorMessage(), "idMedicament"));
        });
    }
}
