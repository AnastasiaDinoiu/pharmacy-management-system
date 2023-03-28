package com.bdproject.pharmacy.service.impl;

import com.bdproject.pharmacy.exception.ErrorCodes;
import com.bdproject.pharmacy.exception.ServiceException;
import com.bdproject.pharmacy.model.ProducerEntity;
import com.bdproject.pharmacy.repository.ProducerRepository;
import com.bdproject.pharmacy.service.ProducerService;
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
public class ProducerServiceImpl implements ProducerService {

    private final ProducerRepository producerRepository;

    @Override
    public Integer createProducer(String producator, String tara) {
        validateParameters(producator, tara);

        return producerRepository.save(producerRequestToEntity(producator, tara)).getIdProducator();
    }

    @Override
    public Integer updateProducer(Integer idProducator, String producator, String tara) {
        validateId(idProducator);
        validateParameters(producator, tara);
        var updatedProducer = producerRequestToEntity(producator, tara);
        updatedProducer.setIdProducator(idProducator);

        return producerRepository.save(updatedProducer).getIdProducator();
    }

    @Override
    public void deleteProducer(Integer idProducator) {
        validateId(idProducator);
        producerRepository.deleteById(idProducator);
    }

    @Override
    @Transactional(readOnly = true)
    public ProducerEntity getProducerById(Integer idProducator) {
        return producerRepository.findById(idProducator).orElseThrow(() -> {
            log.error("idProducator {} is invalid", idProducator);
            throw new ServiceException(ErrorCodes.INVALID_PARAMETER,
                    MessageFormat.format(ErrorCodes.INVALID_PARAMETER.getErrorMessage(), "idProducator"));
        });
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProducerEntity> getProducers() {
        return producerRepository.findAll();
    }

    private void validateParameters(String producator, String tara) {
        if (Objects.isNull(producator)) {
            log.error("producator is not set on request");
            throw new ServiceException(ErrorCodes.MISSING_PARAMETER,
                    MessageFormat.format(ErrorCodes.MISSING_PARAMETER.getErrorMessage(), "producator"));
        }
        if (Objects.isNull(tara)) {
            log.error("tara is not set on request");
            throw new ServiceException(ErrorCodes.MISSING_PARAMETER,
                    MessageFormat.format(ErrorCodes.MISSING_PARAMETER.getErrorMessage(), "tara"));
        }
    }

    private ProducerEntity producerRequestToEntity(String producator, String tara) {
        ProducerEntity response = new ProducerEntity();

        response.setNumeProducator(producator);
        response.setTara(tara);

        return response;
    }

    private void validateId(Integer idProducator) {
        producerRepository.findById(idProducator).orElseThrow(() -> {
            log.error("idProducator {} is invalid", idProducator);
            throw new ServiceException(ErrorCodes.INVALID_PARAMETER,
                    MessageFormat.format(ErrorCodes.INVALID_PARAMETER.getErrorMessage(), "idProducator"));
        });
    }
}
