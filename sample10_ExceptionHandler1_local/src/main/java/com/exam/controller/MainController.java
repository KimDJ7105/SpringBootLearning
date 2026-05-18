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

    //로컬
    @ExceptionHandler(value={NullPointerException.class, IllegalArgumentException.class})
    //value 로 어떤 예외를 처리할지 설정할 수 있다.
    public String handleException(Exception e, Model model) {
       //Model이나 RedirectAttribute 등을 인자로 받아올 수 있다.
       model.addAttribute("message",e.getMessage());
       return "error/error";
    }
}
