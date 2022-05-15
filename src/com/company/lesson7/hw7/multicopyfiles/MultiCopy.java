package com.company.lesson7.hw7.multicopyfiles;

import java.io.*;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MultiCopy {
    private static int sizeOfPart = 10_000_000;
    private int numberOfPartOfFile;
    private  long remainderSize;

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        File fileFrom = new File("C:\\Users\\Администратор\\Desktop\\A\\K\\idea_crack.mp4");
        File fileTo = new File("C:\\Users\\Администратор\\Desktop\\A\\L\\idea_crack.mp4");

        System.out.println(fileFrom.length());
        System.out.println(Arrays.toString(listOfAdress(fileFrom)));

       // copyFile(fileFrom, fileTo);


    }

    public static long[] listOfAdress(File file) {
        long  sizeOfFile = file.length();
        if (sizeOfFile < sizeOfPart * 2) {
            System.out.println("Файл меньше 20 Мб, мультипоточное копирование нерационально");
            return null;
        }
        int numberOfPartOfFile = (int)(sizeOfFile / sizeOfPart);
        long remainderSize = sizeOfFile - ((long) numberOfPartOfFile * sizeOfPart);
        long[] arrayOfAdresses = new long[numberOfPartOfFile + 1];
        for (int i = 0; i < numberOfPartOfFile; i++) {
            arrayOfAdresses[i] = i * sizeOfPart;
        }
        arrayOfAdresses[numberOfPartOfFile] = remainderSize;
        return arrayOfAdresses;
    }

    public static void copyFile1(File in, File out) throws IOException {
        try (InputStream is = new FileInputStream(in);
             OutputStream os = new FileOutputStream(out)) {
            long copyBytes = is.transferTo(os);
            System.out.println(copyBytes + " bytes copied");
        } catch (IOException e) {
            throw e;
        }
    }

    public static void copyFileWithoutEdit(File in, File out) throws IOException {
        byte[] buffer = new byte[10_000_000];
        int readBytes = 0;
        long totalCopyByte = 0;
        try (InputStream is = new FileInputStream(in);
             OutputStream os = new FileOutputStream(out)) {
            for (;;) {
                readBytes = is.read(buffer);
                if (readBytes <= 0) {
                    break;
                }
                os.write(buffer, 0, readBytes);
                totalCopyByte += readBytes;
            }
            System.out.println(totalCopyByte + " bytes copied");
        } catch (IOException e) {
            throw e;
        }
    }

}

class CopyFile implements Runnable {
    private File inputFile;
    private File outputFile;
    int begin;
    int length;

    public CopyFile(File inputFile, File outputFile, int begin, int length) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.begin = begin;
        this.length = length;
    }

    @Override
    public void run() {
        try {
            copyFile(inputFile, outputFile, begin, length);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public  void copyFile(File inputFile, File outputFile, int begin, int length) throws IOException {
        byte[] buffer = new byte[length];
        long totalCopyByte = 0;
        try (InputStream is = new FileInputStream(inputFile);
             OutputStream os = new FileOutputStream(outputFile)) {

            is.read(buffer);
            os.write(buffer, begin, length);
            totalCopyByte += length;

            System.out.println(totalCopyByte + " bytes copied");
        } catch (IOException e) {
            throw e;
        }
    }


}


