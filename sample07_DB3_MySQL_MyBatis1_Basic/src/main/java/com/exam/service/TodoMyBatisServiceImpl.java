package com.exam.service;

import com.exam.dao.TodoMyBatisRepository;
import com.exam.dto.TodoDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("todoMyBatisService")
//getBean을 사용하지 않기 때문에 별명은 필요없다.
public class TodoMyBatisServiceImpl implements TodoMyBatisService {

    TodoMyBatisRepository todoMyBatisRepository;

    public TodoMyBatisServiceImpl(TodoMyBatisRepository todoMyBatisRepository) {
        this.todoMyBatisRepository = todoMyBatisRepository;
    }

    @Override
    public List<TodoDTO> findAll() {
        return  todoMyBatisRepository.findAll();
    }

    @Override
    public TodoDTO findById(int id) {
        return todoMyBatisRepository.findById(id);
    }

    @Override
    @Transactional
    public int save(TodoDTO todoDTO) {
        return todoMyBatisRepository.save(todoDTO);
    }

    @Override
    @Transactional
    public int deleteById(int id) {
        return todoMyBatisRepository.deleteById(id);
    }
    @Override
    @Transactional
    public int updateById(TodoDTO todoDTO) {
        return todoMyBatisRepository.updateById(todoDTO);
    }
}