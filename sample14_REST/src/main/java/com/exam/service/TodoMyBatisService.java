package com.exam.service;

import com.exam.dto.TodoDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TodoMyBatisService {

    List<TodoDTO> findAll();

    TodoDTO findById(int id);

    @Transactional
    int save(TodoDTO todoDTO);

    @Transactional
    int deleteById(int id);

    @Transactional
    int updateById(TodoDTO todoDTO);
}