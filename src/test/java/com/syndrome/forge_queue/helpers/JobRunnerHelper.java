package com.syndrome.forge_queue.helpers;

import com.syndrome.forge_queue.dto.JobCreationRequestDto;
import com.syndrome.forge_queue.model.JobRunner;
import com.syndrome.forge_queue.model.JobStatus;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Component
public class JobRunnerHelper {

    public static JobRunner createBasicJobRunner(JobCreationRequestDto jobCreationRequestDto){
        return JobRunner.builder()
                .jobName(jobCreationRequestDto.getJobName())
                .jobInterval(jobCreationRequestDto.getInterval())
                .jobDescription(jobCreationRequestDto.getDescription())
                .jobId("efg-ijk"+ UUID.randomUUID().toString().substring(0, 10))
                .jobStatus(JobStatus.CREATED)
                .createdAt(Timestamp.from(Instant.now()))
                .build();
    }
}
