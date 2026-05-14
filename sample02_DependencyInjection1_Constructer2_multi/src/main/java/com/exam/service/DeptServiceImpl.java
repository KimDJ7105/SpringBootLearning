package com.exam.service;

import com.exam.dao.DeptDAO;
import com.exam.dao.EmpDAO;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service("service")
public class DeptServiceImpl {
    DeptDAO dao;
    EmpDAO empdao;

    public DeptServiceImpl(DeptDAO dao, EmpDAO empDAO) {
        System.out.println("DeptServiceImpl");
        this.dao = dao;
        this.empdao = empDAO;
    }

    public List<String> findAll() {

        List<String> list = dao.findAll();
        List<String> list2 = empdao.findAll();
        list.addAll(list2);
        return list;
    }
}
