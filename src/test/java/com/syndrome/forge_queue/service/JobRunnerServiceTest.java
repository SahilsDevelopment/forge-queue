package com.syndrome.forge_queue.service;

import com.syndrome.forge_queue.dto.JobCreationRequestDto;
import com.syndrome.forge_queue.dto.JobCreationResponseDto;
import com.syndrome.forge_queue.errors_and_messages.BusinessMessages;
import com.syndrome.forge_queue.repository.JobRunnerRepository;
import com.syndrome.forge_queue.service.impl.JobRunnerServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class JobRunnerServiceTest {

    @Mock
    private JobRunnerRepository jobRunnerRepository;
    @InjectMocks
    private JobRunnerServiceImpl jobRunnerServiceImpl;


    @DisplayName("Test to verify successful creation of a Job")
    @Test
    public void testSuccessfulJobCreation(){
        JobCreationRequestDto jobCreationRequestDto = JobCreationRequestDto.builder()
                .jobName("email-job")
                .interval("3s")
                .description("This job targets the email sending")
                .build();

        JobCreationResponseDto jobCreationResponseDto = jobRunnerServiceImpl.createNewJob(jobCreationRequestDto);
        assertEquals(BusinessMessages.JOB_CREATED_SUCCESS, jobCreationResponseDto.getMessage());
    }
}
