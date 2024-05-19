package com.example.graphql.exception.handler;

import com.example.graphql.dto.response.ErrorResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> exceptionEntityNotFoundHandler(EntityNotFoundException e){
        log.info(e.getMessage());
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(e.getMessage())
                .errorCode(HttpStatus.NOT_FOUND.value())
                .build();
        return ResponseEntity
                .badRequest()
                .body(errorResponse);
    }

}
