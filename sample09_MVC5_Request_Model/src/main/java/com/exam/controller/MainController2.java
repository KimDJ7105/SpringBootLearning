package com.exam.controller;


import com.exam.dto.LoginDTO;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;


@Controller
@SessionAttributes(names={"bbb", "ccc"})
public class MainController2 {

    @Autowired
    ServletContext sc;

    @GetMapping("/session")
    public String hello(Model model) {
        //Request Scope
        model.addAttribute("aaa", "홍길동1");
        //Session Scope
        model.addAttribute("bbb", "홍길동2");
        model.addAttribute("ccc", "홍길동3");
        //Application Scope

        sc.setAttribute("ddd", "홍길동4");
        sc.setAttribute("eee", "홍길동5");


        return "target"; //target.html
    }
}
