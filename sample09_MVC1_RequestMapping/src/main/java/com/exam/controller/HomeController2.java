package com.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class HomeController2 {
    //@RequestMapping("/요청매핑값")
    //public 리턴타입 foo() { 모델과 뷰 처리 }
    //리턴타입이 String이면 뷰 정보(뷰 컴포넌트 파일명)를 의미하는 것이다.

    @RequestMapping("/list")
    public String home(){
        System.out.println("member list");
        return "main";
    } // http://localhost:8080/member/list
      // 아직 컨텍스트 명이 없다.

    @RequestMapping(value = "/write")
    public String home2(){
        System.out.println("member write");
        return "main";
    } // http://localhost:8080/member/write


}
