package com.exam.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class MainController {

   @GetMapping("/main")
    public String main() {
       System.out.println("main");
       return "main";
   }

    @GetMapping("/main2")
    public String main2() {
        System.out.println("main2");
        return "main";
    }
}
