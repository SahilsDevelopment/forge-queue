package com.syndrome.forge_queue.controller;

import com.syndrome.forge_queue.dto.JobCreationRequestDto;
import com.syndrome.forge_queue.dto.JobCreationResponseDto;
import com.syndrome.forge_queue.service.JobRunnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/jobs")
@Slf4j
public class JobRunnerController {

    private final JobRunnerService jobRunnerService;

    public JobRunnerController(JobRunnerService jobRunnerService){
        this.jobRunnerService = jobRunnerService;
    }

    @PostMapping
    public ResponseEntity<JobCreationResponseDto> createNewJob(@RequestBody
                                                               @Validated JobCreationRequestDto jobCreationRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(jobRunnerService.createNewJob(jobCreationRequestDto));
    }
}