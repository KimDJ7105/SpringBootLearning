package com.exam.dao;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository("EmpRepository")
public class EmpDAO {
    public EmpDAO() {
        System.out.println("EmpDAO");
    }

    public List<String> findAll() {

        //return Arrays.asList("Hong", "Lee");
        return new ArrayList<>(Arrays.asList("Hong", "Lee"));
    }
}
