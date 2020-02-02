package com.fslqup.day05.Exception;

public class MyException extends Exception {
    public MyException() {
    }

    public MyException(String message) {
        super (message);
        System.out.println ("异常："+message);
    }
}
