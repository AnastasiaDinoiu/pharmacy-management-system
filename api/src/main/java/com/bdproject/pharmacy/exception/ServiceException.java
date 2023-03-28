package com.bdproject.pharmacy.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class ServiceException extends RuntimeException {

    private final ErrorCodes error;
    private final String errorCode;
    private final String errorMessage;

    public ServiceException(ErrorCodes error, String errorMessage) {
        super(errorMessage);
        this.error = error;
        this.errorCode = error.getErrorCode();
        this.errorMessage = errorMessage;
    }
}
