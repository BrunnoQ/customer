package com.bqs.customerapi.exception;

import java.util.ArrayList;
import java.util.Collection;

import br.com.fluentvalidator.context.Error;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final Collection<Error> errors = new ArrayList<>();

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Collection<Error> errors) {
        super(message);
        this.errors.addAll(errors);
    }

}
