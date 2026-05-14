package com.exam.service;

import com.exam.dao.TodoRepository;
import com.exam.dto.TodoDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("todoService")
public class TodoServiceImpl implements TodoService{

    TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<TodoDTO> findAll(){
        return todoRepository.findAll();
    }

    @Override
    public TodoDTO findById(int id){
        return todoRepository.findById(id);
    }

    @Override
    @Transactional
    public int save(TodoDTO todoDTO){ //insert
        return todoRepository.save(todoDTO);
    }

    @Override
    @Transactional
    public int delteById(int id){
        return todoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public int update(TodoDTO todoDTO){
        return todoRepository.update(todoDTO);
    }
}
