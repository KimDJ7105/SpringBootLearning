package com.exam.controller;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
    //@RequestMapping("/요청매핑값")
    //public 리턴타입 foo() { 모델과 뷰 처리 }
    //리턴타입이 String이면 뷰 정보(뷰 컴포넌트 파일명)를 의미하는 것이다.

    @RequestMapping("/memberForm")
    public String home(){
        System.out.println("memberForm");
        return "memberForm";
    } //http://localhost:8080/memberForm

    //Get 요청 처리
    //@RequestMapping(value="/member", method = RequestMethod.GET)
    @GetMapping("/member")
    public String memberGET(){
        System.out.println("member GET");
        return "memberForm";
    }

    //Post 요청 처리
    //@RequestMapping(value="/member", method = RequestMethod.POST)
    @PostMapping("/member")
    public String memberPOST(){
        System.out.println("member POST");
        return "memberForm";
    }



}
