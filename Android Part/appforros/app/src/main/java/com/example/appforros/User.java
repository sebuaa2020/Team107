package com.example.appforros;

public class User {
    private long user_account = -1;
    private int user_priority = -1;
    private String user_password;

    private User() {

    }

    private static class UserHolder{
        private static User user = new User();
    }

    public static User getInstance() {
        return UserHolder.user;
    }

    public void setUser_account(long account) {
        user_account = account;
    }

    public void setUser_priority(int priority) {
        user_priority = priority;
    }

    public long getUser_account() {
        return user_account;
    }

    public int getUser_priority() {
        return user_priority;
    }

}
