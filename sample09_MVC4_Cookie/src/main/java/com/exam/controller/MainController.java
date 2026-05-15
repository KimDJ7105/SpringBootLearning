package com.exam.controller;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
    //쿠키 생성.
    @GetMapping("/set")
    public String helloSet(HttpServletRequest request, HttpServletResponse response) {

        Cookie c = new Cookie("userid", "홍길동");
        //c.setMaxAge(3600);
        response.addCookie(c);

        return "main";
    }

    //쿠키 참조
    @GetMapping("/get2")
    public String helloGet(HttpServletRequest request, HttpServletResponse response) {

        Cookie [] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("userid")){
                    System.out.println(cookie.getName());
                }
            }
        }

        return "main";
    }

    //쿠키 참조
    @GetMapping("/get")
    public String helloGet2(@CookieValue("userid") String userid) {

        System.out.println(userid);

        return "main";
    }
}
