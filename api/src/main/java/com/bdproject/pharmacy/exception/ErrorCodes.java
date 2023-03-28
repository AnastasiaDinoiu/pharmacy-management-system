package com.bdproject.pharmacy.exception;

import lombok.Getter;

@Getter
public enum ErrorCodes {
    TECHNICAL_ERROR("TECHNICAL_ERROR", "Technical error"),
    RESOURCE_NOT_FOUND("RESOURCE_NOT_FOUND", "Resource {0} not found"),
    INVALID_PARAMETER("INVALID_PARAMETER", "Parameter {0} is invalid"),
    MISSING_PARAMETER("MISSING_PARAMETER", "Parameter {0} is missing");

    private String errorCode;
    private String errorMessage;

    ErrorCodes(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
