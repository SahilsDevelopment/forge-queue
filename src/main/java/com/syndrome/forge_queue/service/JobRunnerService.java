package com.syndrome.forge_queue.service;

import com.syndrome.forge_queue.dto.JobCreationRequestDto;
import com.syndrome.forge_queue.dto.JobCreationResponseDto;

public interface JobRunnerService {
    JobCreationResponseDto createNewJob(JobCreationRequestDto jobCreationRequestDto);
}
