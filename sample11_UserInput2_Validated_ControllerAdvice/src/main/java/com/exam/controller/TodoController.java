package com.exam.controller;


import com.exam.dto.TodoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;


@Controller
@Validated
public class TodoController {

    //사용자 화면 출력
    @GetMapping("/add-todo")
    public String showTodoPage() {
        return "write";
    }

    //로직 처리
    @PostMapping("/add-todo")
    public String addTodo(@NotBlank(message = "적어도 한 글자 이상 입력해야합니다.") String userid,
                          @Size(min=5, message = "최소 5글자 이상 입력해야합니다.") String description,
                          @NotNull @FutureOrPresent(message ="현재 혹은 미래 날자만 선택 가능합니다.") LocalDate targetDate) {

        //검증 실패 : 예외가 발생 -> @ControllerAdvice

        //검증 성공
        System.out.println(userid);
        System.out.println(description);
        System.out.println(targetDate);
        return "redirect:main";
    }

    //성공시 보여줄 화면
    @GetMapping("/main")
    public String main() {
        return "main";
    }
}
