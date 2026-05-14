package com.exam;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
	}
    @Value("${spring.application.name}")
    String name;
    @Value("${server.port}")
    String port;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World");
        System.out.println(name);
        System.out.println(port);
    }
}
