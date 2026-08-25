package com.syndrome.forge_queue.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobCreationResponseDto {
    private String message;
    private String jobId;
}