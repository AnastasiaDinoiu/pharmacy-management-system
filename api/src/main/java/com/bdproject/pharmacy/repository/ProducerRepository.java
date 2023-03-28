package com.bdproject.pharmacy.repository;

import com.bdproject.pharmacy.model.ProducerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends JpaRepository<ProducerEntity, Integer> {
}
