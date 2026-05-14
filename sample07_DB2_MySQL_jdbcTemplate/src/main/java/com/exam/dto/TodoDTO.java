package com.exam.dto;

import org.springframework.stereotype.Component;

public class TodoDTO {
    int id;
    String name;
    String job;

    public TodoDTO(int id, String name, String job) {
        this.id = id;
        this.name = name;
        this.job = job;
    }

    public TodoDTO() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "TodoDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
