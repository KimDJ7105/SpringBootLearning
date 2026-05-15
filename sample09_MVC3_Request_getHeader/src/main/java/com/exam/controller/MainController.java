package com.exam.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Enumeration;


@Controller
public class MainController {

    @GetMapping("/main")
    public String hello(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            System.out.println(headerName + ":" + headerValue);
        }

        //헤더값을 아는 경우
        System.out.println(request.getHeader("User-Agent"));

        return "main";
    }


    @GetMapping("/main2")
    public String hello2(@RequestHeader(value="User-Agent") String userAgent,
                         @RequestHeader(value = "connection")String conn) {
        System.out.println(userAgent);
        System.out.println(conn);

        return "main";
    }
}
