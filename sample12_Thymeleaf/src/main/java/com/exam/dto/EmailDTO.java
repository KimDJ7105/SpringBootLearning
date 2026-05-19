package com.exam.dto;

import java.util.List;

public class EmailDTO {
    //String [] email;
    List<String> emails;

    public List<String> getEmails() {
        return emails;
    }
    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public EmailDTO() {}
    public EmailDTO(List<String> emails) {
        this.emails = emails;
    }

    @Override
    public String toString() {
        return "EmailDTO{" +
                "emails=" + emails +
                '}';
    }
}
