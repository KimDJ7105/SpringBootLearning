package com.exam.config;

import com.exam.controller.DeptController;
import com.exam.dao.DeptDAO;
import com.exam.service.DeptServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeptConfiguration
{
    @Bean
    public DeptController getDeptController()
    {
        return new DeptController();
    }

    @Bean
    public DeptServiceImpl getDeptService()
    {
        return new DeptServiceImpl();
    }

    @Bean
    public DeptDAO getDeptDAO()
    {
        return new DeptDAO();
    }
}
