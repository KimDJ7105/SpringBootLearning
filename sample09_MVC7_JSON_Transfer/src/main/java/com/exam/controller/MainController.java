package com.exam.controller;


import com.exam.dto.LoginDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;


@Controller
public class MainController {

    @GetMapping("/aaa")
    @ResponseBody
    public String aaa() {
        return "Hello World";
    }


    @GetMapping("/bbb")
    @ResponseBody
    public LoginDTO bbb() {
        LoginDTO dto = new LoginDTO("홍길동", "1234");
        return dto;
    }

    @GetMapping("/ccc")
    @ResponseBody
    public ArrayList<LoginDTO> ccc() {
        ArrayList<LoginDTO> list = new ArrayList<>();
        list.add(new LoginDTO("홍길동", "1234"));
        list.add(new LoginDTO("이순신", "9874"));
        list.add(new LoginDTO("유관순", "5678"));
        return list;
    }

    @GetMapping("/ddd")
    @ResponseBody
    public HashMap<String,ArrayList<LoginDTO>> ddd() {
        ArrayList<LoginDTO> list = new ArrayList<>();
        list.add(new LoginDTO("홍길동", "1234"));
        list.add(new LoginDTO("이순신", "9874"));
        list.add(new LoginDTO("유관순", "5678"));

        HashMap<String,ArrayList<LoginDTO>> map = new HashMap<>();
        map.put("one", list);

        return map;
    }

    @GetMapping(value = "/eee", produces = "text/xml")
    @ResponseBody
    public String eee() {
        return "<Person><name>홍길동</name><age>26</age></Person>";
    }

    @GetMapping(value = "/fff", produces = "text/xml")
    @ResponseBody
    public String  fff(){
        return "<html><body><h1>Hello</h1></body></html>";
    }
    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    @PostMapping("/ggg")
    @ResponseBody
    public String ggg(@RequestBody LoginDTO dto) {
        System.out.println(dto);
        return "Hello World";
    }

    @PostMapping("/hhh")
    @ResponseBody
    public String hhh(@RequestBody List<LoginDTO> list) {
        System.out.println(list);
        return "Hello World";
    }
}
