package com.exam.controller;

import com.exam.api.ApiResponse;
import com.exam.dto.TodoDTO;
import com.exam.service.TodoMyBatisService;
import org.apache.catalina.core.ApplicationPushBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController //@Controller + @ResponseBody
public class TodoController {

    TodoMyBatisService todoService;
    public TodoController(TodoMyBatisService todoService) {
        this.todoService = todoService;
    }

    //1. todo 목록 보기
    @GetMapping("/todos")
    public ResponseEntity<ApiResponse<List<TodoDTO>>> todos(){

        return ResponseEntity.ok(ApiResponse.ok("조회 성공(Entity)",todoService.findAll()));
    }

    //2. 특정 todo 보기
    @GetMapping("/todos/{id}")
    //public TodoDTO todos(@PathVariable("id") int id){
    public ResponseEntity<ApiResponse<TodoDTO>> todos(@PathVariable int id){

        TodoDTO todoDTO = todoService.findById(id);
        if(todoDTO == null){
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.fail("해당하는 id가 없습니다.", null));
        }
        return ResponseEntity.ok(ApiResponse.ok("id 조회 성공", todoDTO));
    }

    //3. todo 저장
    @PostMapping("/todos")
    public ResponseEntity<ApiResponse<TodoDTO>> todos(@RequestBody TodoDTO todoDTO){
        //새롭게 생성한 데이터를 리턴한다.

        int n = todoService.save(todoDTO);
        if(n > 0) {
            URI location = ServletUriComponentsBuilder
                            .fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(todoDTO.getId())
                            .toUri();
                            //생성한 DTO 정보를 보여주는 URI 생성
            return ResponseEntity.created(location).body(ApiResponse.ok("삽입 성공", todoDTO));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.fail("삽입 실패", todoDTO));
    }

    //4. 전체 수정
    @PutMapping("/todos/{id}")
    public ResponseEntity<ApiResponse<TodoDTO>> putTodos(@PathVariable int id, @RequestBody TodoDTO todoDTO) {
        todoDTO.setId(id);
        int n = todoService.updateById(todoDTO);
        if(n > 0 ) {
            return ResponseEntity.ok(ApiResponse.ok("수정 성공", todoDTO));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.fail("해당하는 id가 없습니다.", null));
    }

    //5. todo 삭제
    @DeleteMapping("/todos/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteTodos(@PathVariable int id){
        int n = todoService.deleteById(id);
        if(n > 0) {
            return ResponseEntity.noContent()
                    .header("X-request-result", "deleted")
                    .build(); //헤더값에 결과 표시
        }

        return ResponseEntity.noContent()
                .header("X-request-result", "delete fail")
                .build();
    }
}
