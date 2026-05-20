package com.exam.controller;

import com.exam.dto.MemberDTO;
import com.exam.service.AuthenticationService;
import com.exam.service.MemberService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;

@Controller
@SessionAttributes(value = {"loginInfo"})
public class LoginController {

    AuthenticationService authenticationService;
    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/login")
    public String signForm(Model model) {
        model.addAttribute("logindto", new MemberDTO());
        return "loginForm";
    }

    @PostMapping("/login")
    public String signup(@Valid @ModelAttribute("logindto") MemberDTO dto, BindingResult result, Model model,
                         RedirectAttributes rttr) {
        if(result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "loginForm";
        }

        HashMap<String, String> loginMap = new HashMap<>();
        loginMap.put("userid", dto.getUserid());
        loginMap.put("password", dto.getPassword());

        if(authenticationService.authenticate( new HashMap<String, String>(loginMap)) != null) {
            //로그인 성공, 세션에 임의의 데이터 저장 ex) MemberDTO, userid, ...
            //저장된 세션을 이용해 로그인 여부 판단.
            //session.setAttribute("loginInfo", dto.getUserid());
            model.addAttribute("loginInfo", dto.getUserid());
            return "redirect:home";
        }
        
        //로그인에 실패
        rttr.addFlashAttribute("errorMessage", "아이디 또는 비밀번호가 틀렸습니다.");
        
        return "redirect:login";
    }

    @GetMapping("/logout")
    public String logout(SessionStatus  sessionStatus) {
        sessionStatus.setComplete(); // 세션 삭제

        return "home";
    }
}
