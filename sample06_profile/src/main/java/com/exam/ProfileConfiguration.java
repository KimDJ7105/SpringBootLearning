package com.exam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileConfiguration {
    @Bean
    @Profile("prod")
    public String createProd() {
        System.out.println("create prod");
        return "prod 관련 객체 생성";
    }

    @Bean
    @Profile("dev")
    public String createDev() {
        System.out.println("create dev");
        return "dev 관련 객체 생성";
    }
}
