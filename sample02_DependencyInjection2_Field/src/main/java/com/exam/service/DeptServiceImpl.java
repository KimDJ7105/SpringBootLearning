package com.exam.service;

import com.exam.dao.DeptDAO;
import com.exam.dao.EmpDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service("service")
public class DeptServiceImpl {
    @Autowired
    DeptDAO dao;
    @Autowired
    EmpDAO empDAO;

    public List<String> findAll() {

        List<String> list = dao.findAll();
        List<String> list2 = empDAO.findAll();
        list.addAll(list2);
        return list;
    }
}
