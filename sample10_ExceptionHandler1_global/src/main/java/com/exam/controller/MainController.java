package com.exam.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class MainController {

   @GetMapping("/main")
    public String main() {
       System.out.println("main");

       if(true) throw new IllegalArgumentException("IllegalArgumentException 예외 발생");

       return "main";
   }

    @GetMapping("/main2")
    public String main2() {
        System.out.println("main2");

        if(true) throw new NullPointerException("NullPointerException 예외 발생");

        return "main";
    }
}
