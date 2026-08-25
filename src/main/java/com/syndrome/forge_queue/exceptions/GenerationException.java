package com.syndrome.forge_queue.exceptions;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenerationException extends RuntimeException{
    private String error_category;
    private String error_message;
}
