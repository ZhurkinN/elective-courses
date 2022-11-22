package ru.rsreu.electivecourses.model.database;

public class DBTypeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DBTypeException() {
        super();
    }

    public DBTypeException(String message) {
        super(message);
    }
}
