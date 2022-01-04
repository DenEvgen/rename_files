package com.khayrullin.Exceptions;

public class FileExtensionException extends Exception {

    private final String inCorrectExtension;

    public String getExtension() {
        return inCorrectExtension;
    }

    public FileExtensionException(String message, String extension) {
        super(message);
        inCorrectExtension = extension;

    }

}
