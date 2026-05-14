package com.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DemoApplication  implements CommandLineRunner {

	public static void main(String[] args){
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("Hello World");
	}

    @Autowired
    AppProps appProps;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(appProps);
    }
}
