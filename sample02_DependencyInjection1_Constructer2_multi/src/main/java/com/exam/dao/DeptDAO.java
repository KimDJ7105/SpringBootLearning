package com.exam.dao;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository("DeptRepository")
public class DeptDAO {
    public DeptDAO() {
        System.out.println("DeptDAO");
    }

    public List<String> findAll() {
        //return Arrays.asList("홍길동", "이순신");
        // asList로 만든 리스트는 수정 불가능.
        return new ArrayList<>(Arrays.asList("홍길동", "이순신"));
    }
}
