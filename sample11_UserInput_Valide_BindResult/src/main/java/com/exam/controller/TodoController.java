package com.exam.controller;


import com.exam.dto.TodoDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class TodoController {

    //사용자 화면 출력
    @GetMapping("/add-todo")
    public String showTodoPage(Model model) {
        model.addAttribute("dto", new TodoDTO());
        //key는 post에서 설정한 NodelAttribute와 같아야 한다.
        return "write";
    }

    //로직 처리
    @PostMapping("/add-todo")
    public String addTodo(@Valid @ModelAttribute("dto") TodoDTO todoDTO, BindingResult bindingResult, Model model) {
        System.out.println("Post AddTodo");
        //검증 실패
        if(bindingResult.hasErrors()) {
            //bindingRsult에 검증 결과가 바인드되어 넘어온다.
            //System.out.println(bindingResult.getAllErrors());
            return "write";
        }
        //검증 성공
        return "redirect:main";
    }

    //성공시 보여줄 화면
    @GetMapping("/main")
    public String main() {
        return "main";
    }
}
