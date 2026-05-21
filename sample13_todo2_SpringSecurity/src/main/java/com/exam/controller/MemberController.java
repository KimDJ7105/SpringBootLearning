package com.exam.controller;

import com.exam.dto.MemberDTO;
import com.exam.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    MemberService memberService;
    PasswordEncoder passwordEncoder;
    public MemberController(MemberService memberService,  PasswordEncoder passwordEncoder) {
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/signup")
    public String signForm(Model model) {
        model.addAttribute("member", new MemberDTO());
        return "memberForm";
    }

    @PostMapping("/signup")
    public String signup(@Valid @ModelAttribute("member") MemberDTO member, BindingResult result) {
        if(result.hasErrors()) { //검증 실패시
            System.out.println(result.getAllErrors());
            return "memberForm";
        }

        String originalPassword = member.getPassword();
        member.setPassword(passwordEncoder.encode(originalPassword));

        //서비스 연동
        //추가로 예외처리 필요.
        int n = memberService.signup(member);
        if(n > 0) System.out.println("회원가입 완료");

        return "redirect:home";
    }
}
