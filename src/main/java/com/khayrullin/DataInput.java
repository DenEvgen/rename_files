package com.khayrullin;

import com.khayrullin.Exceptions.FileExtensionException;
import com.khayrullin.Exceptions.PathException;

import java.io.File;
import java.util.Scanner;

public class DataInput {

    String path;
    String fileExtension;

    Scanner scanner = new Scanner(System.in);

    public String getFileExtension() throws FileExtensionException {
        System.out.println("Enter file extension:  ");
        fileExtension = scanner.nextLine();
        if (!isAlpha(fileExtension)) throw new FileExtensionException("Incorrect extension!", fileExtension);
        return fileExtension;
    }

    public String getPath() throws PathException {
        System.out.println("Enter path to folder:  ");
        path = scanner.nextLine();
        if (!path.endsWith("/")) path += "/";
        if (!isExistPath(path)) throw new PathException("Path is not exist!", path);
        return path;
    }

    private boolean isExistPath(String path) {
        File f = new File(path);
        return f.isDirectory();
    }

    public boolean isAlpha(String fileExtension) {
        return fileExtension.matches("[a-zA-Z]+");
    }

}
