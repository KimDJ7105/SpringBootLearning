package com.exam;

import com.exam.service.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    // IoC 컨테이너 주입
    @Autowired
    ApplicationContext acx;

	public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("Hello World");
	}

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello Runner");
        DeptServiceImpl service = acx.getBean("service", DeptServiceImpl.class);

        List<String> list =  service.findAll();

        System.out.println(list.toString());
    }
}
