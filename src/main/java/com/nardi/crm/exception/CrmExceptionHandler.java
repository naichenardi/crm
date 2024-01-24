
package com.nardi.crm.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CrmExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = CrmHttpException.class)
    public ResponseEntity<Object> handleException(CrmHttpException e) {
        return new ResponseEntity<>(e.getMessage(), e.getStatus());
    }
}