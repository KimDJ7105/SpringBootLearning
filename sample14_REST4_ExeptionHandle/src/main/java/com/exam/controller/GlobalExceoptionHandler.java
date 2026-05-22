package com.exam.controller;

import com.exam.api.ApiResponse;
import com.exam.dto.TodoDTO;
import com.exam.exceoption.DuplicatedIdException;
import com.exam.exceoption.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceoptionHandler {

    @ExceptionHandler(value = {RecordNotFoundException.class})
    public ResponseEntity<ApiResponse<TodoDTO>> handleException(Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.fail(e.getMessage(), null));
    }

    @ExceptionHandler(value = {DuplicatedIdException.class})
    public ResponseEntity<ApiResponse<TodoDTO>> handleDuplicateException(Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ApiResponse.fail(e.getMessage(), null));
    }
}
