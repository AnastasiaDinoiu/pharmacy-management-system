package com.bdproject.pharmacy.service.impl;

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
    public Integer createJob(String numePost, Integer salariu) {
        validateParameters(numePost, salariu);

        return jobRepository.save(jobRequestToEntity(numePost, salariu)).getIdPost();
    }

    @Override
    public Integer updateJob(Integer idPost, String numePost, Integer salariu) {
        validateId(idPost);
        validateParameters(numePost, salariu);
        var updatedJob = jobRequestToEntity(numePost, salariu);
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

    private void validateParameters(String numePost, Integer salariu) {
        if (Objects.isNull(numePost)) {
            log.error("numePost is not set on request");
            throw new ServiceException(ErrorCodes.MISSING_PARAMETER,
                    MessageFormat.format(ErrorCodes.MISSING_PARAMETER.getErrorMessage(), "numePost"));
        }
        if (Objects.isNull(salariu)) {
            log.error("salariu is not set on request");
            throw new ServiceException(ErrorCodes.MISSING_PARAMETER,
                    MessageFormat.format(ErrorCodes.MISSING_PARAMETER.getErrorMessage(), "salariu"));
        }
    }

    private JobEntity jobRequestToEntity(String numePost, Integer salariu) {
        JobEntity respone = new JobEntity();

        respone.setNumePost(numePost);
        respone.setSalariu(salariu);

        return respone;
    }

    private void validateId(Integer idPost) {
        jobRepository.findById(idPost).orElseThrow(() -> {
            log.error("idPost {} is invalid", idPost);
            throw new ServiceException(ErrorCodes.INVALID_PARAMETER,
                    MessageFormat.format(ErrorCodes.INVALID_PARAMETER.getErrorMessage(), "idPost"));
        });
    }
}
