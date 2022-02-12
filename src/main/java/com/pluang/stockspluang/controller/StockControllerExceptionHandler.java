package com.pluang.stockspluang.controller;

import com.pluang.stockspluang.exception.StockException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class StockControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({StockException.class})
    protected ResponseEntity<Object> handleError(StockException e, WebRequest request) {
        return handleExceptionInternal(e, e.getErrorMsg(),
                null,
                HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
