package com.syndrome.forge_queue.utils;

import com.syndrome.forge_queue.errors_and_messages.ErrorsMessages;
import com.syndrome.forge_queue.exceptions.GenerationException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GeneratorUtil {

    public static StringBuffer generateJobId(){
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("efg_hij");
            stringBuffer.append(UUID.randomUUID().toString(), 0, 8);
            return stringBuffer;
        } catch (Exception e) {
            throw new GenerationException(ErrorsMessages.JOB_ID_NOT_GENERATED, ErrorsMessages.ERROR_GENERATING_JOB_ID);
        }
    }
}
