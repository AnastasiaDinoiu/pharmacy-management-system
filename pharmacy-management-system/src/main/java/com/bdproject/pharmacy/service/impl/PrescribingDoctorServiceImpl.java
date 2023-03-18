package com.bdproject.pharmacy.service.impl;

import com.bdproject.pharmacy.dto.request.DoctorRequest;
import com.bdproject.pharmacy.exception.ErrorCodes;
import com.bdproject.pharmacy.exception.ServiceException;
import com.bdproject.pharmacy.model.PrescribingDoctorEntity;
import com.bdproject.pharmacy.repository.PrescribingDoctorRepository;
import com.bdproject.pharmacy.service.PrescribingDoctorService;
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
public class PrescribingDoctorServiceImpl implements PrescribingDoctorService {

    private final PrescribingDoctorRepository doctorRepository;

    @Override
    public Integer createDoctor(DoctorRequest request) {
        validateParameters(request);

        return doctorRepository.save(doctorRequestToEntity(request)).getIdMedicPrescriptor();
    }

    @Override
    public Integer updateDoctor(Integer idDoctor, DoctorRequest request) {
        validateId(idDoctor);
        validateParameters(request);
        var updatedDoctor = doctorRequestToEntity(request);
        updatedDoctor.setIdMedicPrescriptor(idDoctor);

        return doctorRepository.save(doctorRequestToEntity(request)).getIdMedicPrescriptor();
    }

    @Override
    public void deleteDoctor(Integer idDoctor) {
        validateId(idDoctor);
        doctorRepository.deleteById(idDoctor);
    }

    @Override
    @Transactional(readOnly = true)
    public PrescribingDoctorEntity getDoctorById(Integer idDoctor) {
        return doctorRepository.findById(idDoctor).orElseThrow(() -> {
            log.error("idDoctor {} is invalid", idDoctor);
            throw new ServiceException(ErrorCodes.INVALID_PARAMETER,
                    MessageFormat.format(ErrorCodes.INVALID_PARAMETER.getErrorMessage(), "idDoctor"));
        });
    }

    @Override
    @Transactional(readOnly = true)
    public List<PrescribingDoctorEntity> getDoctors() {
        return doctorRepository.findAll();
    }

    private void validateParameters(DoctorRequest request) {
        if (Objects.isNull(request.getUnitateMedicala())) {
            log.error("unitateMedicala is not set on request");
            throw new ServiceException(ErrorCodes.MISSING_PARAMETER,
                    MessageFormat.format(ErrorCodes.MISSING_PARAMETER.getErrorMessage(), "unitateMedicala"));
        }
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

    private PrescribingDoctorEntity doctorRequestToEntity(DoctorRequest request) {
        PrescribingDoctorEntity response = new PrescribingDoctorEntity();

        response.setUnitateMedicala(request.getUnitateMedicala());
        response.setNumeMedicPrescriptor(request.getNume());
        response.setPrenumeMedicPrescriptor(request.getPrenume());
        response.setEmailMedicPrescriptor(request.getEmail());
        response.setTelefonMedicPrescriptor(request.getTelefon());

        return response;
    }

    private void validateId(Integer idDoctor) {
        doctorRepository.findById(idDoctor).orElseThrow(() -> {
            log.error("idDoctor {} is invalid", idDoctor);
            throw new ServiceException(ErrorCodes.INVALID_PARAMETER,
                    MessageFormat.format(ErrorCodes.INVALID_PARAMETER.getErrorMessage(), "idDoctor"));
        });
    }
}
