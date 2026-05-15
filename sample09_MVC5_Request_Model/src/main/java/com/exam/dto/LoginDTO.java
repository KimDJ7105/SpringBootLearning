package com.exam.dto;

public class LoginDTO {
    String userid;
    String passwd;

    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getPassword() {
        return passwd;
    }
    public void setPassword(String password) {
        this.passwd = password;
    }

    public LoginDTO() {}
    public LoginDTO(String userid, String passwd) {
        this.userid = userid;
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "userid='" + userid + '\'' +
                ", password='" + passwd + '\'' +
                '}';
    }
}
