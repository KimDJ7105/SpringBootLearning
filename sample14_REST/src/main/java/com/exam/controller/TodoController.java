package com.exam.controller;

import com.exam.dto.TodoDTO;
import com.exam.service.TodoMyBatisService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //@Controller + @ResponseBody
public class TodoController {

    TodoMyBatisService todoService;
    public TodoController(TodoMyBatisService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    //1. todo 목록 보기
    @GetMapping("/todos")
    public List<TodoDTO> todos(){

        return todoService.findAll();
    }

    //2. 특정 todo 보기
    @GetMapping("/todos/{id}")
    //public TodoDTO todos(@PathVariable("id") int id){
    public TodoDTO todos(@PathVariable int id){
        return todoService.findById(id);
    }

    //3. todo 저장
    @PostMapping("/todos")
    public TodoDTO todos(@RequestBody TodoDTO todoDTO){
        //새롭게 생성한 데이터를 리턴한다.
        todoService.save(todoDTO);
        return todoDTO;
    }

    //4. 전체 수정
    @PutMapping("/todos/{id}")
    public TodoDTO putTodos(@PathVariable int id, @RequestBody TodoDTO todoDTO) {
        todoDTO.setId(id);
        todoService.updateById(todoDTO);
        return todoDTO;
    }

    //5. todo 삭제
    @DeleteMapping("/todos/{id}")
    public void deleteTodos(@PathVariable int id){
        todoService.deleteById(id);
    }
}
