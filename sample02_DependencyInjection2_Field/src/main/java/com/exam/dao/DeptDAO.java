package com.exam.dao;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class DeptDAO {
    public DeptDAO() {
        System.out.println("DeptDAO");
    }

    public List<String> findAll() {
        return new ArrayList<>(Arrays.asList("홍길동", "이순신"));
    }
}
