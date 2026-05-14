package com.exam.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository("EmpRepository")
public class EmpDAO implements CommonDAO {
    public EmpDAO() {
        System.out.println("EmpDAO");
    }

    @Override
    public List<String> findAll() {
        return Arrays.asList("Hong", "Lee");
    }
}
