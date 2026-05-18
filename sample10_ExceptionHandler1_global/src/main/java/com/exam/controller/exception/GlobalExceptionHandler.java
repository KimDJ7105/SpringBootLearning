package com.exam.controller.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value=ArithmeticException.class)
    public String exceptionHandler(Exception e, Model model) {
        e.printStackTrace();
        model.addAttribute("message", e.getMessage());
        return "error/error";
    }
}
