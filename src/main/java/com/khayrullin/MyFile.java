package com.khayrullin;

import com.khayrullin.Exceptions.FileExtensionException;
import com.khayrullin.Exceptions.PathException;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class MyFile {
    public static void main(String[] args) {

        String path = null;
        String extension = null;

        DataInput folder = new DataInput();
        File[] files;
        String nameForFile = "Фото";
        int counter = 1;

        try {
            path = folder.getPath();
        } catch (PathException pex) {
            System.out.println(pex.getMessage());
            System.out.println("You entered: " + pex.getIncorrectPath());
        }

        try {
            extension = folder.getFileExtension();
        } catch (FileExtensionException fee) {
            System.out.println(fee.getMessage());
            System.out.println("You entered: " + fee.getExtension());
        }

        System.out.println(path);
        System.out.println(extension);
        File filepath = new File(path);
        files = filepath.listFiles();

        assert files != null;
        Arrays.sort(files, Comparator.comparingLong(File::lastModified));

        for (File file : files) {
            file.renameTo(new File(path + nameForFile + " " + counter+"."+extension));
            counter += 1;
        }
        System.out.println("Done");
    }
}
