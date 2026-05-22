package com.exam.exceoption;

public class DuplicatedIdException extends RuntimeException {
    public DuplicatedIdException(String message) {
        super(message);
    }
}
