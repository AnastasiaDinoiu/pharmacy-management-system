package com.bdproject.pharmacy.service.impl;

import com.bdproject.pharmacy.dto.request.JobRequest;
import com.bdproject.pharmacy.exception.ErrorCodes;
import com.bdproject.pharmacy.exception.ServiceException;
import com.bdproject.pharmacy.model.JobEntity;
import com.bdproject.pharmacy.repository.JobRepository;
import com.bdproject.pharmacy.service.JobService;
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
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    @Override
    public Integer createJob(JobRequest request) {
        validateParameters(request);

        return jobRepository.save(jobRequestToEntity(request)).getIdPost();
    }

    @Override
    public Integer updateJob(Integer idPost, JobRequest request) {
        validateId(idPost);
        validateParameters(request);
        var updatedJob = jobRequestToEntity(request);
        updatedJob.setIdPost(idPost);

        return jobRepository.save(updatedJob).getIdPost();
    }

    @Override
    public void deleteJob(Integer idPost) {
        validateId(idPost);
        jobRepository.deleteById(idPost);
    }

    @Override
    @Transactional(readOnly = true)
    public JobEntity getJobById(Integer idPost) {
        return jobRepository.findById(idPost).orElseThrow(() -> {
            log.error("idPost {} is invalid", idPost);
            throw new ServiceException(ErrorCodes.INVALID_PARAMETER,
                    MessageFormat.format(ErrorCodes.INVALID_PARAMETER.getErrorMessage(), "idPost"));
        });
    }

    @Override
    @Transactional(readOnly = true)
    public List<JobEntity> getJobs() {
        return jobRepository.findAll();
    }

    private void validateParameters(JobRequest request) {
        if (Objects.isNull(request.getNume())) {
            log.error("numePost is not set on request");
            throw new ServiceException(ErrorCodes.MISSING_PARAMETER,
                    MessageFormat.format(ErrorCodes.MISSING_PARAMETER.getErrorMessage(), "numePost"));
        }
        if (Objects.isNull(request.getSalariu())) {
            log.error("salariu is not set on request");
            throw new ServiceException(ErrorCodes.MISSING_PARAMETER,
                    MessageFormat.format(ErrorCodes.MISSING_PARAMETER.getErrorMessage(), "salariu"));
        }
    }

    private JobEntity jobRequestToEntity(JobRequest request) {
        JobEntity response = new JobEntity();

        response.setNumePost(request.getNume());
        response.setSalariu(request.getSalariu());

        return response;
    }

    private void validateId(Integer idPost) {
        jobRepository.findById(idPost).orElseThrow(() -> {
            log.error("idPost {} is invalid", idPost);
            throw new ServiceException(ErrorCodes.INVALID_PARAMETER,
                    MessageFormat.format(ErrorCodes.INVALID_PARAMETER.getErrorMessage(), "idPost"));
        });
    }
}
