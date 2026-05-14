package com.exam.service;

import com.exam.dto.TodoDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TodoMyBatisService {

    List<TodoDTO> findAll();

    TodoDTO findById(int id);

    int save(TodoDTO todoDTO);

    int deleteById(int id);

    @Transactional
    int updateById(TodoDTO todoDTO);
}