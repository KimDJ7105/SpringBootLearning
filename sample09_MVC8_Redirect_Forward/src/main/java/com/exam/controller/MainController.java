package com.exam.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class MainController {

    @GetMapping("/main")
    public String main() {
        System.out.println("main");
        return "main";
    }

    @GetMapping("/forward")
    public String forward(Model model) {
        System.out.println("forward");
        model.addAttribute("userid", "forward");

        return "forward:main";
    }

    @GetMapping("/redirect")
    public String redirect(Model model) {
        System.out.println("redirect");
        model.addAttribute("userid", "forward");

        return "redirect:main";
    }

    @GetMapping("/flash")
    public String flash(RedirectAttributes redirectAttributes ) {
        System.out.println("flash");
        redirectAttributes.addFlashAttribute("userid", "forward");

        return "redirect:main";
    }
}
