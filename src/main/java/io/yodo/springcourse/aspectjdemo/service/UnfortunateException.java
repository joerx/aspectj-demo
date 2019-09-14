package io.yodo.springcourse.aspectjdemo.service;

public class UnfortunateException extends RuntimeException {

    UnfortunateException(String message) {
        super(message);
    }
}
