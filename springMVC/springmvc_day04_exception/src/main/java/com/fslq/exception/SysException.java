package com.fslq.exception;
/*
* 系统异常类
* */
public class SysException extends Exception {
    private String message;

    public SysException(String message) {
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message=message;
    }
}
