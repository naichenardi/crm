package com.nardi.crm.exception;

import org.springframework.http.HttpStatus;

public class CrmHttpException extends RuntimeException {
    private HttpStatus status;
    public CrmHttpException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public CrmHttpException(String message, HttpStatus status, Throwable cause) {
        super(message, cause);
        this.status = status;

    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
