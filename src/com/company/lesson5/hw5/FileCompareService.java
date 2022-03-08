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
        byte[] arrayOne = new byte[1000];
        byte[] arrayTwo = new byte[1000];
        try (InputStream inputStreamOne = new FileInputStream(fileOne);
             InputStream inputStreamTwo = new FileInputStream(fileTwo)) {


        }


        return false;
    }


}
