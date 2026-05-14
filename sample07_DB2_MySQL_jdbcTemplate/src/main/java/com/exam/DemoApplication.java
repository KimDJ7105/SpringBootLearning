package com.exam;

import com.exam.dto.TodoDTO;
import com.exam.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
	}

    @Autowired
    TodoService todoService;

    @Override
    public void run(String... args) throws Exception {

        TodoDTO todoDTO = todoService.findById(1);
        System.out.println(todoDTO);

        int n = todoService.save(new TodoDTO(4, "홍길동", "excersize"));
        if(n > 0) {
            System.out.println("삽입성공");
        }
        System.out.println("------------------------------");
        List<TodoDTO> list = todoService.findAll();
        System.out.println(list);
        System.out.println("------------------------------");

        n = todoService.delteById(4);
        if(n > 0) {
            System.out.println("삭제성공");
        }

        n = todoService.update(new TodoDTO(2, "이순신", "excersize"));
        if(n > 0) {
            System.out.println("수정성공");
        }
        
        System.out.println("------------------------------");
        list = todoService.findAll();
        System.out.println(list);
        System.out.println("------------------------------");

    }
}
