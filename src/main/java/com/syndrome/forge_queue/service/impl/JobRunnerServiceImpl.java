package com.syndrome.forge_queue.service.impl;

import com.syndrome.forge_queue.dto.JobCreationRequestDto;
import com.syndrome.forge_queue.dto.JobCreationResponseDto;
import com.syndrome.forge_queue.errors_and_messages.BusinessMessages;
import com.syndrome.forge_queue.model.JobRunner;
import com.syndrome.forge_queue.model.JobStatus;
import com.syndrome.forge_queue.repository.JobRunnerRepository;
import com.syndrome.forge_queue.service.JobRunnerService;
import com.syndrome.forge_queue.utils.GeneratorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
@Slf4j
public class JobRunnerServiceImpl implements JobRunnerService {

    private final JobRunnerRepository jobRunnerRepository;

    public JobRunnerServiceImpl(JobRunnerRepository jobRunnerRepository){
        this.jobRunnerRepository = jobRunnerRepository;
    }

    @Override
    public JobCreationResponseDto createNewJob(JobCreationRequestDto jobCreationRequestDto){

        String jobId = GeneratorUtil.generateJobId().toString();

        JobRunner jobRunner = JobRunner.builder()
                .jobDescription(jobCreationRequestDto.getDescription())
                .jobId(jobId)
                .jobInterval(jobCreationRequestDto.getInterval())
                .jobName(jobCreationRequestDto.getJobName())
                .jobStatus(JobStatus.CREATED)
                .createdAt(Timestamp.from(Instant.now()))
                .build();
        jobRunnerRepository.save(jobRunner);
        log.info("Job with job-id - {} saved in database", jobId);

        return JobCreationResponseDto.builder()
                .message(BusinessMessages.JOB_CREATED_SUCCESS)
                .jobId(jobId)
                .build();
    }
}
