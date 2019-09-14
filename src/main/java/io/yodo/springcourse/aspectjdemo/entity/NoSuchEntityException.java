package io.yodo.springcourse.aspectjdemo.entity;

public class NoSuchEntityException extends RuntimeException {

    public NoSuchEntityException(String message) {
        super(message);
    }
}
