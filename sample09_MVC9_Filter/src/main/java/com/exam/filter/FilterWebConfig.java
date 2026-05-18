package com.exam.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FilterWebConfig implements WebMvcConfigurer {

    @Bean
    public FilterRegistrationBean<MyFilter> filterRegistrationBean() {
        FilterRegistrationBean<MyFilter> frb =
                new FilterRegistrationBean<>();
        frb.setFilter(new MyFilter());
        frb.addUrlPatterns("/*"); // 필터를 적용할 URL 설정
                                  // 현재는 모든 url 적용

        return frb;
    }
}
