package com.bqs.customerapi.exception.handler.message;

import java.util.Collection;
import lombok.Builder;

@Builder
public record ErrorMessage (int code, String message, String detail, Collection<Error> errors) {
    
}