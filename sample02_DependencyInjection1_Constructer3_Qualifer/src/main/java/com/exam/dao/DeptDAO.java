package com.exam.dao;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository("DeptRepository")
public class DeptDAO implements CommonDAO {
    public DeptDAO() {
        System.out.println("DeptDAO");
    }

    @Override
    public List<String> findAll() {
        return Arrays.asList("홍길동", "이순신");
    }
}
