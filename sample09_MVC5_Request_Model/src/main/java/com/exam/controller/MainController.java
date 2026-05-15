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
    @GetMapping("/m")
    public String hello(HttpServletRequest request) {
        request.setAttribute("userid", "홍길동");
        request.setAttribute("email", "hong@example.com");

        return "main";
    }

    @GetMapping("/m2")
    public String hello2(Model model) {
        model.addAttribute("userid", "홍길동");
        model.addAttribute("email", "hong@example.com");

        return "main";
    }

    @GetMapping("/m3")
    public String hello3(Map<String, String> map) {
        map.put("userid", "홍길동");
        map.put("email", "hong@example.com");

        return "main";
    }

    @GetMapping("/m4")
    public String hello4(Model model) {
        model.addAttribute("dto", new LoginDTO("홍길동", "비번"));

        return "main2";
    }

    @GetMapping("/m5")
    public String hello5(LoginDTO dto) {
        dto.setUserid("홍길동");
        dto.setPassword("비번");
        return "main3";
    }

    @GetMapping("/m6")
    public String hello6(@ModelAttribute("loginDTO") LoginDTO dto) {
        dto.setUserid("홍길동");
        dto.setPassword("비번");
        return "main3";
    }

    @GetMapping("/m7")
    public String hello7(@ModelAttribute("nameList") ArrayList<String> nameList) {
        
        nameList.add("홍길동");
        nameList.add("이순신");
        nameList.add("유관순");
        nameList.add("세종대왕");
        
        return "main4";
    }

    @GetMapping("/m8")
    public  ModelAndView hello8() {

        ModelAndView mv = new ModelAndView();

        mv.setViewName("main5"); // view 지정
    
        // 모델에 데이터 저장
        mv.addObject("userid", "홍길동");
        mv.addObject("dto", new LoginDTO("이순신", "비번"));
        mv.addObject("list", Arrays.asList("Lee","Hong","Choi"));
        mv.addObject("dtoList", Arrays.asList(new LoginDTO("홍길동", "비번1"),
                new LoginDTO("이순신", "비번2"),
                new LoginDTO("유관순", "비번3")));

        return mv;
    }
}
