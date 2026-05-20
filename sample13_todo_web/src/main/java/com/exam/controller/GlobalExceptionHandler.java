package com.exam.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value= DataAccessException.class)
    public String exceptionHandler(Exception e, Model model) {
        e.printStackTrace();
        model.addAttribute("message", e.getMessage());
        return "home";
    }
}
