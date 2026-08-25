package com.syndrome.forge_queue.exceptions;

import com.syndrome.forge_queue.errors_and_messages.ErrorsMessages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GenerationException.class)
    public ResponseEntity<ErrorResponse> handleGenerationException(GenerationException generationException){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .error_code(Exceptions.GENERATION_EXCEPTION.name())
                .error_category(generationException.getError_category())
                .error_message(generationException.getError_message())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
