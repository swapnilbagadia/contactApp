package com.test.contactapp.controller;

import com.test.contactapp.dtos.ErrorResponseDto;
import com.test.contactapp.exceptions.BadRequestException;
import com.test.contactapp.exceptions.UnAuthenticatedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Swapnil Bagadia
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponseDto> handleBadRequestException(BadRequestException ex) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ex.getMessage());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ex.getMessage());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnAuthenticatedException.class)
    public ResponseEntity<ErrorResponseDto> handleUnAuthenticatedException(UnAuthenticatedException ex) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ex.getMessage());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.FORBIDDEN);
    }
}
