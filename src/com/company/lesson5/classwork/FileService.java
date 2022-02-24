package com.company.lesson5.classwork;

import java.io.*;
import java.util.Arrays;

public class FileService {

    public static void copyFile(File fileIn, File fileOut) throws IOException {
        try (InputStream is = new FileInputStream(fileIn); OutputStream os = new FileOutputStream(fileOut)) {

            long totalBytes = is.transferTo(os);
            System.out.println(totalBytes + " Byte copy");
        }
    }

    public static void copyFolder(File folderIn, File folderOut) throws IOException {
        File[] allFiles = folderIn.listFiles();
      //  System.out.println(Arrays.toString(allFiles));
        for (int i = 0; i < allFiles.length; i++) {
            if (allFiles[i].isFile()) {
                File fileOut = new File(folderOut, allFiles[i].getName());
                copyFile(allFiles[i], fileOut);
            }
        }
    }


}
