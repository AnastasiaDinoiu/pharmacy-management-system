package com.bdproject.pharmacy.service;

import com.bdproject.pharmacy.dto.request.DoctorRequest;
import com.bdproject.pharmacy.model.PrescribingDoctorEntity;

import java.util.List;

public interface PrescribingDoctorService {

    Integer createDoctor(DoctorRequest request);

    Integer updateDoctor(Integer idDoctor, DoctorRequest request);

    void deleteDoctor(Integer idDoctor);

    PrescribingDoctorEntity getDoctorById(Integer idDoctor);

    List<PrescribingDoctorEntity> getDoctors();
}
