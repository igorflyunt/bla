package com.softserve.bookworm.servlet.validator;

public class ErrorResponse {
    private int errorType;
    private String errorMessage;

    public ErrorResponse(int errorType, String errorMessage) {
        this.errorType = errorType;
        this.errorMessage = errorMessage;
    }

    public int getErrorType() {
        return errorType;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
