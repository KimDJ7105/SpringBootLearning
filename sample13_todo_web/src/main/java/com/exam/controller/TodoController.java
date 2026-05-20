package com.exam.controller;

import com.exam.dto.MemberDTO;
import com.exam.dto.TodoDTO;
import com.exam.mapper.TodoMapper;
import com.exam.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes(value={"loginInfo"})
public class TodoController {

    TodoService todoService;
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todo-list")
    public String home(Model model) {
        String userid = (String)model.getAttribute("loginInfo");
        //System.out.println("userid:"+userid);
        List<TodoDTO> list = todoService.findAll(userid);

        model.addAttribute("todoList", list);

        return "todoList";
    }

    @GetMapping("/todo-add")
    public String todoAddForm(Model model) {
        model.addAttribute("todo", new TodoDTO());
        return "todoAddForm";
    }

    @PostMapping("/todo-add")
    public String todoAdd(@Valid @ModelAttribute("todo") TodoDTO todo, BindingResult result,Model model) {
        if(result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "todoAddForm";
        }

        todo.setUserid((String)model.getAttribute("loginInfo"));

        int n = todoService.save(todo);
        if(n > 0) System.out.println(todo + " 추가 완료");

        return "redirect:todo-list";
    }

    @PostMapping("/todo-delete")
    public String deleteTodo(@RequestParam("id") int id) {
        int n = todoService.deleteById(id);
        if(n>0) System.out.println(n + " 삭제 완료");
        return "redirect:/todo-list";
    }

    @GetMapping("/todo-update")
    public String updateForm(@RequestParam("id") int id, Model model) {
        TodoDTO dto = new TodoDTO();
        dto.setId(id);
        model.addAttribute("todo", dto);
        return "todoUpdateForm";
    }

    @PostMapping("/todo-update")
    public String updateTodo(@Valid @ModelAttribute("todo") TodoDTO todo, BindingResult result) {
        if(result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "todoUpdateForm";
        }

        int n = todoService.updateById(todo);
        if(n>0) System.out.println("수정 완료");

        return "redirect:todo-list";
    }
}
