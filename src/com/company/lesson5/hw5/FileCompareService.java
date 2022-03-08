package com.company.lesson5.hw5;

import java.io.*;

public class FileCompareService {
    private File fileOne;
    private File fileTwo;

    public FileCompareService() {
    }

    public FileCompareService(String[] args) {
        this.fileOne = new File(args[0]);
        this.fileTwo = new File(args[1]);
    }


    public boolean isFileEquals(File fileOne, File fileTwo) throws IOException {
        long sizeOne = 0;
        long sizeTwo = 0;
        byte[] arrayOne = new byte[1000];
        byte[] arrayTwo = new byte[1000];
        try (InputStream inputStreamOne = new FileInputStream(fileOne);
             InputStream inputStreamTwo = new FileInputStream(fileTwo)) {
            for (; (inputStreamOne.available() > 0) && (inputStreamTwo.available() > 0); ) {
                sizeOne += inputStreamOne.read(arrayOne);
                sizeTwo += inputStreamTwo.read(arrayTwo);
                if (!compareArrays(arrayOne, arrayTwo)) {
                    return false;
                }
            }
        }
        System.out.println("file one contains: " + sizeOne + " bytes and file two contains: " + sizeTwo);
        return true;
    }

    private boolean compareArrays(byte[] arr1, byte[] arr2) {
        if (arr1.length == arr2.length) {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    return false;
                }
            }
        }
        return true;
    }


}
