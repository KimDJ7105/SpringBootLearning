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
    @GetMapping("/login")
    public String signForm(Model model) {
        model.addAttribute("logindto", new MemberDTO());
        return "loginForm";
    }

}
