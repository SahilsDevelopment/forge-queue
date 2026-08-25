package com.syndrome.forge_queue.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ErrorResponse {
    private String error_code;
    private String error_category;
    private String error_message;
}
