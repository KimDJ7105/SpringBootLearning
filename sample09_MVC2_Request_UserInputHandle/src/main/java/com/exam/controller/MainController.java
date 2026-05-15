package com.exam.controller;

import com.exam.dto.EmailDTO;
import com.exam.dto.LoginDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @GetMapping("/set")
    public String hello() {
        return "main";
    }

    @GetMapping("/loginform")
    public String loginForm() {
        return "loginForm";
    }

    @GetMapping("/login2")
    public String loginGet(HttpServletRequest request, HttpServletResponse response) {

        String userid = request.getParameter("userid");
        String password = request.getParameter("password");

        System.out.println(userid + "   " + password);

        return "main";
    }

    @GetMapping("/login3")
    public String loginGetParam(@RequestParam(value = "userid", required = false) String userid,
                                @RequestParam(defaultValue = "99999") String password) {
                                // 변수명이 매핑과 동일하면 매핑 파라미터 생략 가능
                                // required 속성을 통해 값이 없는 경우 예외를 발생시킬지 아닐지
                                // 정할 수 있다. 기본은 true
                                // defaultValue로 값이 없는 경우 기본값을 설정할 수 있다.
        System.out.println(userid + "   " + password);

        return "main";
    }

    @GetMapping("/login")
    public String loginDTO(LoginDTO dto) {
        System.out.println(dto);
        return "main";
    }

    @GetMapping("/login4")
    public String loginMap(@RequestParam Map<String, Object> map) {
        System.out.println(map);
        return "main";
    }

    //--------------------------------------------
    //복수의 데이터를 가져오는 방법
    //--------------------------------------------
    @GetMapping("email")
    public String email(@RequestParam("email")  String [] email) {
        System.out.println(Arrays.toString(email));
        return "loginForm";
    }

    @GetMapping("email2")
    public String email2(@RequestParam("email") List<String> email) {
        System.out.println(email);
        return "loginForm";
    }

    @GetMapping("email3")
    public String email3(EmailDTO email) {
        System.out.println(email);
        return "loginForm";
    }


    @PostMapping("/login")
    public String loginPost() {
        return "main";
    }
}
