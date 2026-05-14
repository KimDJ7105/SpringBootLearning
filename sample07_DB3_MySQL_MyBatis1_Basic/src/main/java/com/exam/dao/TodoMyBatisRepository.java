package com.exam.dao;

import com.exam.dto.TodoDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoMyBatisRepository {

    SqlSessionTemplate sqlSessionTemplate;

    public TodoMyBatisRepository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<TodoDTO> findAll() {
        return sqlSessionTemplate.selectList("com.exam.config.TodoMapper.findAll");
    }

    public TodoDTO findById(int id) {
        return sqlSessionTemplate.selectOne("com.exam.config.TodoMapper.findById", id);
    }

    public int save(TodoDTO todoDTO) {
        return sqlSessionTemplate.insert("com.exam.config.TodoMapper.save", todoDTO);
    }

    public int deleteById(int id) {
        return sqlSessionTemplate.delete("com.exam.config.TodoMapper.deleteById", id);
    }

    public int updateById(TodoDTO todoDTO) {
        return sqlSessionTemplate.update("com.exam.config.TodoMapper.updateById", todoDTO);
    }
}