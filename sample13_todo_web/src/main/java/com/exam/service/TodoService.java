package com.exam.service;

import com.exam.dto.TodoDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TodoService {

    List<TodoDTO> findAll(String userid);
    TodoDTO findById(int id);
    @Transactional
    int save(TodoDTO dto);
    @Transactional
    int updateById(TodoDTO dto);
    @Transactional
    int deleteById(int id);
}