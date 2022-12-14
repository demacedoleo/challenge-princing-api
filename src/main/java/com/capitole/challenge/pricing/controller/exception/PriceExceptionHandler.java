package com.capitole.challenge.pricing.controller.exception;

import com.capitole.challenge.pricing.domain.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class PriceExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Error> handleGenericException(Exception e) {
        Error error = new Error();
        error.setCode(HttpStatus.Series.SERVER_ERROR.toString());
        error.setMessage("error trying to get product price");

        String[] causes = {e.getMessage()};
        error.setCauses(causes);

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
