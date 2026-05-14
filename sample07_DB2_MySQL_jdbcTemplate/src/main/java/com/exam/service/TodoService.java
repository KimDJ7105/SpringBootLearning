package com.exam.service;

import com.exam.dto.TodoDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TodoService {
    List<TodoDTO> findAll();

    TodoDTO findById(int id);

    int save(TodoDTO todoDTO);

    @Transactional
    int delteById(int id);

    @Transactional
    int update(TodoDTO todoDTO);
}
