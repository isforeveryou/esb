package com.forever.utils;

import java.io.File;
import java.io.IOException;

public class FileUtils {


    public static File getFile(String filePath) throws IOException {
        File file = new File(filePath);
        File parentFile = file.getParentFile();

        if (parentFile.exists() && !file.exists()) {
            file.createNewFile();
        } else if (!parentFile.exists()) {
            parentFile.mkdirs();
            file.createNewFile();
        }
        return file;
    }
}
