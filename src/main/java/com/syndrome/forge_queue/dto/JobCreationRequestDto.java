package com.syndrome.forge_queue.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobCreationRequestDto {
    private String jobName;
    private String interval;
    private String description;
}
