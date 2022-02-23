package com.company.lesson3.hw3;

public class GroupOverflowException extends Exception{
    public GroupOverflowException() {
        super();
    }

    public GroupOverflowException(String message) {
        super(message);
    }

    public GroupOverflowException(String message, Throwable cause) {
        super(message, cause);
    }

    public GroupOverflowException(Throwable cause) {
        super(cause);
    }
}
