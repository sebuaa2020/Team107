package com.example.system.utils.exception;

public class UserNotExistException extends RuntimeException {

    public UserNotExistException() {
        super("用户出了大问题");
    }
}
