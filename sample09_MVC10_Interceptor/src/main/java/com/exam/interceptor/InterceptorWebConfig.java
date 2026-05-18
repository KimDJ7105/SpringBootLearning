package com.exam.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorWebConfig implements WebMvcConfigurer {

    @Autowired
    MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(new MyInterceptor());
        //이렇게 해도 된다.
        registry.addInterceptor(myInterceptor).addPathPatterns("/main", "/aaa/*");
        //addPathPatterns로 인터셉트 할 Url 요청을 지정한다.
        // /**로 모든 URL 경로에 사용할 수 있다.
    }
}
