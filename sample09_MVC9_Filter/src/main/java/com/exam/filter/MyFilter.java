package com.exam.filter;


import jakarta.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //요청시 실행
        System.out.println("요청 필터");
        filterChain.doFilter(servletRequest,servletResponse);
        //응답시 실행
        System.out.println("응답 필터");
    }
}
