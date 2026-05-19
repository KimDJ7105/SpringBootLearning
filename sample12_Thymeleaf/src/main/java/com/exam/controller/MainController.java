package com.exam.controller;

import com.exam.dto.EmailDTO;
import com.exam.dto.LoginDTO;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes(value={"session", "xxx"})
public class MainController {

    @Autowired
    ServletContext servletContext;

    //Scope에 저장한 객체 출력
    @GetMapping("/m")
    public String main(Model model) {
        model.addAttribute("request", "홍길동");
        model.addAttribute("request2", "<h1>홍길동</h1>");
        model.addAttribute("session", "홍길동2");
        model.addAttribute("xxx", "홍길동3");

        servletContext.setAttribute("application", "홍길동4");
        return "main";
    }

    // Scope 에 저장한 객체 출력
    @GetMapping("/m2")
    public String main2(Model model) {
        model.addAttribute("login", new LoginDTO("홍길동", "1324"));

        return "main2";
    }

    // Scope 에 저장한 객체 제어문을 활용해서 출력
    @GetMapping("/m3")
    public String main3(Model model) {
        model.addAttribute("login", new LoginDTO("홍길동", "1324"));
        model.addAttribute("login2", new LoginDTO(null, "1324"));

        List<LoginDTO> list = Arrays.asList(new LoginDTO("홍길동", "1324"),
                                            new LoginDTO("이순신", "2342"),
                                            new LoginDTO("유관순", "fh23d"));
        model.addAttribute("myList", list);
        return "main3";
    }

    // 경로(링크)
    @GetMapping("/m4")
    public String main4() {
        return "main4";
    }
    @GetMapping("/m4-1")
    public String main41(@RequestParam(value = "id", required = false) String userId,
                         @RequestParam(value = "pw", required = false) String passwd) {
        return "loginForm";
    }

    @GetMapping("/m4-2")
    public String main42(@RequestParam(value = "userid", required = false) String userId,
                         @RequestParam(value = "password", required = false) String passwd) {

        System.out.println(userId + "  " +  passwd);
        return "loginForm";
    }

    //유틸리티
    @GetMapping("/m5")
    public String main5(Model model) {
        model.addAttribute("today", LocalDate.now());
        model.addAttribute("username", "hong gil dong");
        model.addAttribute("price", "1234");
        model.addAttribute("myList", Arrays.asList("A", "B", "C", "D", "E"));
        return "main5";
    }

    //화면재사용
    @GetMapping("/m6")
    public String main6(Model model) {
        return "main6";
    }
}
