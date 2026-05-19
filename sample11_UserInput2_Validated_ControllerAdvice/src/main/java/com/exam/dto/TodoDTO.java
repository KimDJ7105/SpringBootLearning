package com.exam.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class TodoDTO {
    String userid;
    String description;
    LocalDate targetDate;

    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public LocalDate getTargetDate() {
        return targetDate;
    }
    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public TodoDTO() {}
    public TodoDTO(String userid, String description, LocalDate targetDate) {
        this.userid = userid;
        this.description = description;
        this.targetDate = targetDate;
    }

    @Override
    public String toString() {
        return "TodoDTO{" +
                "userid='" + userid + '\'' +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                '}';
    }
}
