package com.bdproject.pharmacy.service;

import com.bdproject.pharmacy.model.ProducerEntity;

import java.util.List;

public interface ProducerService {

    Integer createProducer(String producator, String tara);

    Integer updateProducer(Integer idProducator, String producator, String tara);

    void deleteProducer(Integer idProducator);

    ProducerEntity getProducerById(Integer idProducator);

    List<ProducerEntity> getProducers();
}
