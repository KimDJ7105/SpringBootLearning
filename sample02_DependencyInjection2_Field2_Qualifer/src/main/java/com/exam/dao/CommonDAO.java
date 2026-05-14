package com.exam.dao;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;


public interface CommonDAO {
    public abstract List<String> findAll();
}