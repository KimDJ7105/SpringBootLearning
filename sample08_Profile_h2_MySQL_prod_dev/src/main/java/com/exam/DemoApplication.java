package com.exam;

import com.exam.dto.TodoDTO;
import com.exam.service.TodoMyBatisService;
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
    private TodoMyBatisService todoMyBatisService;

    @Override
    public void run(String... args) throws Exception {

        //1개 검색
        TodoDTO dto = todoMyBatisService.findById(1);
        System.out.println(dto);

        //전체 출력
        System.out.println("------------------------------");
        List<TodoDTO> list = todoMyBatisService.findAll();

        list.forEach(System.out::println);
        System.out.println("------------------------------");

        //insert
        int n = todoMyBatisService.save(new TodoDTO(4, "홍길동", "Learn k8s"));
        if(n > 0) System.out.println("삽입 성공");

        //전체 출력
        System.out.println("------------------------------");
        list = todoMyBatisService.findAll();

        list.forEach(System.out::println);
        System.out.println("------------------------------");

        //update
        n = todoMyBatisService.updateById(new TodoDTO(1, "이순신", "Learn k8s"));
        if(n > 0) System.out.println("수정 성공");
        //delete
        n = todoMyBatisService.deleteById(4);
        if(n > 0) System.out.println("삭제 성공");

        //전체 출력
        System.out.println("------------------------------");
        list = todoMyBatisService.findAll();

        list.forEach(System.out::println);
        System.out.println("------------------------------");
    }
}
