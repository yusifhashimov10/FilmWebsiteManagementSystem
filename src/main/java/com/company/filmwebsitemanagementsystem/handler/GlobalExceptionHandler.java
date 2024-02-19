package com.company.filmwebsitemanagementsystem.handler;

import com.company.filmwebsitemanagementsystem.model.dto.response.ExceptionResponse;
import com.company.filmwebsitemanagementsystem.model.enums.Exceptions;
import com.company.filmwebsitemanagementsystem.model.exception.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ExceptionResponse> handle(ApplicationException exception){
        Exceptions exceptions = exception.getExceptions();

        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .message(exceptions.getMessage())
                .status(exceptions.getStatus().value())
                .build();

        log.error(exceptions.getMessage());

        return ResponseEntity
                .status(exceptionResponse.getStatus())
                .body(exceptionResponse);
    }

}
