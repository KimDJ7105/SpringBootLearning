package com.exam.controller;


import com.exam.dto.LoginDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;


@Controller
public class MainController {
    //String 타입
    @GetMapping("/m")
    public String hello(HttpServletRequest request) {
        request.setAttribute("userid", "홍길동");
        request.setAttribute("email", "hong@example.com");

        return "main";
    }

    //ModelAndView
    @GetMapping("/m2")
    public ModelAndView hello2() {
        ModelAndView mv = new ModelAndView("main");

        //mv.setViewName("main");
        //생성자로 전달함.
        mv.addObject("userid", "홍길동");
        mv.addObject("email", "hong@example.com");

        return mv;
    }

    //DTO 타입
    @GetMapping("/main2")
    public @ModelAttribute("loginData") LoginDTO hello3() {
        LoginDTO dto = new LoginDTO("홍길동", "1234");

        return dto;
    }

    //ArrayList
    @GetMapping("/m4")
    public @ModelAttribute("list") ArrayList<String> hello4() {
        ArrayList<String> list = new ArrayList<>();
        list.add("inky4832");
        list.add("lee3842");
        list.add("park424");
        list.add("choi509");

        return list;
    }

    //void
    @GetMapping("/m5")
    public void hello5() {

    }


}
