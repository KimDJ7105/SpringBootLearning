package com.exam.service;

import com.exam.dao.DeptDAO;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service("service")
public class DeptServiceImpl {
    DeptDAO dao;

    public DeptServiceImpl(DeptDAO dao) {
        System.out.println("DeptServiceImpl");
        this.dao = dao;
    }

    public List<String> findAll() {
        return dao.findAll();
    }
}
