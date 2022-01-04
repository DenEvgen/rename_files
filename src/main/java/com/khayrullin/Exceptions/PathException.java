package com.khayrullin.Exceptions;

public class PathException extends Exception {

    private final String incorrectPath;

    public String getIncorrectPath() {
        return incorrectPath;
    }

    public PathException (String message, String path) {
        super(message);
        incorrectPath = path;
    }
}
