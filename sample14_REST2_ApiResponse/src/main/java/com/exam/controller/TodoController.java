package com.exam.controller;

import com.exam.api.ApiResponse;
import com.exam.dto.TodoDTO;
import com.exam.service.TodoMyBatisService;
import org.apache.catalina.core.ApplicationPushBuilder;
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
    public ApiResponse<List<TodoDTO>> todos(){

        return ApiResponse.ok("조회 성공",todoService.findAll());
    }

    //2. 특정 todo 보기
    @GetMapping("/todos/{id}")
    //public TodoDTO todos(@PathVariable("id") int id){
    public ApiResponse<TodoDTO> todos(@PathVariable int id){

        TodoDTO todoDTO = todoService.findById(id);
        if(todoDTO == null){
         return ApiResponse.fail("id 조회 실패", todoDTO);
        }
        return ApiResponse.ok("id 조회 성공", todoDTO);
    }

    //3. todo 저장
    @PostMapping("/todos")
    public ApiResponse<TodoDTO> todos(@RequestBody TodoDTO todoDTO){
        //새롭게 생성한 데이터를 리턴한다.

        int n = todoService.save(todoDTO);
        if(n > 0) {
            return ApiResponse.ok("삽입 성공", todoDTO);
        }
        return ApiResponse.ok("삽입 실패", todoDTO);
    }

    //4. 전체 수정
    @PutMapping("/todos/{id}")
    public ApiResponse<TodoDTO> putTodos(@PathVariable int id, @RequestBody TodoDTO todoDTO) {
        todoDTO.setId(id);
        int n = todoService.updateById(todoDTO);
        if(n > 0 ) {
            return ApiResponse.ok("수정 성공", todoDTO);
        }
        return ApiResponse.ok("수정 실패", todoDTO);
    }

    //5. todo 삭제
    @DeleteMapping("/todos/{id}")
    public ApiResponse<Void> deleteTodos(@PathVariable int id){
        int n = todoService.deleteById(id);
        if(n > 0) {
            return ApiResponse.ok("삭제 성공", null);
        }

        return ApiResponse.fail("삭제 실패", null);
    }
}
