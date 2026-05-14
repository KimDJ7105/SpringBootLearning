package com.exam.service;

import com.exam.dao.CommonDAO;
import com.exam.dao.DeptDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service("service")
public class DeptServiceImpl {
    CommonDAO dao;

    public DeptServiceImpl( @Qualifier("EmpRepository") CommonDAO dao) {
        System.out.println("DeptServiceImpl");
        this.dao = dao;
    }

    public List<String> findAll() {
        return dao.findAll();
    }
}
