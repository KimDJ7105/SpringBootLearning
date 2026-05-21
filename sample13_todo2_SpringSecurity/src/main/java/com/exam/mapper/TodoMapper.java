package com.exam.mapper;

import com.exam.dto.TodoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface TodoMapper {
    List<TodoDTO> findAll(@Param("userid") String userid);
    TodoDTO findById(@Param("id") int id);
    int save(TodoDTO dto);
    int updateById(TodoDTO dto);
    int deleteById(@Param("id") int id);
}
