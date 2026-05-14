package com.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    //@RequestMapping("/요청매핑값")
    //public 리턴타입 foo() { 모델과 뷰 처리 }
    //리턴타입이 String이면 뷰 정보(뷰 컴포넌트 파일명)를 의미하는 것이다.

    @RequestMapping("/home")
    public String home(){
        System.out.println("Controller home");
        return "main";
    } // http://localhost:8080/hello
      // 아직 컨텍스트 명이 없다.

    @RequestMapping(value = "/home2")
    public String home2(){
        System.out.println("Controller home2");
        return "main";
    } // http://localhost:8080/hello2

    @RequestMapping(value = {"/home3", "/home4"})
    public String home3(){
        System.out.println("Controller home34");
        return "main";
    } // http://localhost:8080/[hello3 | hello4]

    @RequestMapping(value = "/xxx*")
    public String home4(){
        System.out.println("Controller home4");
        return "main";
    } // http://localhost:8080/xxx(아무 문자)

    @RequestMapping(value = "/yyy/*")
    public String home5(){
        System.out.println("Controller home5");
        return "main";
    } // http://localhost:8080/yyy/(아무 문자열)
    //깊이 1로 제한.

    @RequestMapping(value = "/zzz/**")
    public String home6(){
        System.out.println("Controller home6");
        return "main";
    } // http://localhost:8080/zzz/(아무 문자열)/(아무 문자열)/...

    @RequestMapping(value = "/aaa/*/bbb")
    public String home7(){
        System.out.println("Controller home7");
        return "main";
    } // http://localhost:8080/aaa/(아무 문자열)/bbb

    @RequestMapping(value = "/ccc/**/ddd")
    public String home8(){
        System.out.println("Controller home8");
        return "main";
    } // http://localhost:8080/ccc/(아무 문자열)/(아무 문자열)/.../ddd
    // application.yml 파일에 spring.mvc.pathmatch.matching-strategy=ant_path_matcher 설정 필요
}
