package com.exam.service;

import com.exam.config.TodoMapper;
import com.exam.dto.TodoDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("todoMyBatisService")
//getBean을 사용하지 않기 때문에 별명은 필요없다.
public class TodoMyBatisServiceImpl implements TodoMyBatisService {

    TodoMapper todoMapper;

    public TodoMyBatisServiceImpl(TodoMapper todoMapper) {
        this.todoMapper = todoMapper;
    }

    @Override
    public List<TodoDTO> findAll() {
        return  todoMapper.findAll();
    }

    @Override
    public TodoDTO findById(int id) {
        return todoMapper.findById(id);
    }

    @Override
    @Transactional
    public int save(TodoDTO todoDTO) {
        return todoMapper.save(todoDTO);
    }

    @Override
    @Transactional
    public int deleteById(int id) {
        return todoMapper.deleteById(id);
    }
    @Override
    @Transactional
    public int updateById(TodoDTO todoDTO) {
        return todoMapper.updateById(todoDTO);
    }
}