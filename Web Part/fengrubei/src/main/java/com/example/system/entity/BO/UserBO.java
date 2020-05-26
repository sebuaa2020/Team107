package com.example.system.entity.BO;

public class UserBO {
    private String username;
    private String password;
    private String confirmPasword;

    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPasword() {
        return confirmPasword;
    }

    public void setConfirmPasword(String confirmPasword) {
        this.confirmPasword = confirmPasword;
    }
}
