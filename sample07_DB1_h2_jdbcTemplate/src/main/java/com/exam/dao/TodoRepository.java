package com.exam.dao;

import com.exam.dto.TodoDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TodoRepository {
    JdbcTemplate jdbcTemplate;

    public TodoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<TodoDTO> findAll() {
        //jdbcTemplate.query(sql, RowMAper<T>)

        //RowMapper 인터페이스는 람다로 처리
        return jdbcTemplate.query("select * from todo",
                (ResultSet rs, int rowNum)->
                        new TodoDTO(rs.getInt("id"),rs.getString("name"),rs.getString("job")));
    }

    public TodoDTO findById(int id) {
        return jdbcTemplate.queryForObject("select * from todo where id = ?",
                (ResultSet rs, int rowNum)->
                        new TodoDTO(rs.getInt("id"),rs.getString("name"),rs.getString("job")),
                        id);
    }

    public int save(TodoDTO todoDTO) {
        return jdbcTemplate.update("insert into todo (id, name, job) values (?, ? , ?)",
                todoDTO.getId(),todoDTO.getName(),todoDTO.getJob());
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from todo where id = ?", id);
    }

    public int update(TodoDTO todoDTO) {
        return jdbcTemplate.update("update todo set name=?, job=? where id=?",
                todoDTO.getName(),todoDTO.getJob(),todoDTO.getId());
    }
}
