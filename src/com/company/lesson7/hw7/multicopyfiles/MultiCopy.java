package com.company.lesson7.hw7.multicopyfiles;

import java.io.*;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MultiCopy {
    private static int sizeOfPart = 10_000_000;
    private int numberOfPartOfFile;
    private long remainderSize;
    private static int[] array;

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        File fileFrom = new File("C:\\Users\\Администратор\\Desktop\\A\\K\\idea_crack.mp4");
        File fileTo = new File("C:\\Users\\Администратор\\Desktop\\A\\L\\idea_crack.mp4");

        System.out.println(Arrays.toString(listOfAdress(fileFrom)));

        array = listOfAdress(fileFrom);
        for (int i = 0; i < array.length - 1; i++) {
            Thread thread = new Thread(new CopyFile(fileFrom, fileTo, array[i] - 1, array[i + 1]));
            thread.start();
        }


    }

    public static int[] listOfAdress(File file) {
        long sizeOfFile = file.length();
        if (sizeOfFile < sizeOfPart * 2) {
            System.out.println("Файл меньше 20 Мб, мультипоточное копирование нерационально");
            return null;
        }
        int numberOfPartOfFile = (int) (sizeOfFile / sizeOfPart);
        int remainderSize = (int) (sizeOfFile - ((long) numberOfPartOfFile * sizeOfPart));
        int[] arrayOfAdresses = new int[numberOfPartOfFile + 2];
        for (int i = 0; i <= numberOfPartOfFile; i++) {
            arrayOfAdresses[i] = i * sizeOfPart;
        }
        arrayOfAdresses[numberOfPartOfFile+1] = remainderSize;
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


}

class CopyFile implements Runnable {
    private File inputFile;
    private File outputFile;
    private int begin;
    private int length;
    private volatile static int numberOfThread = 1;


    public CopyFile(File inputFile, File outputFile, int begin, int length) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.begin = begin;
        this.length = length;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(String.valueOf(numberOfThread));
        numberOfThread++;
        try {
            copyFile(inputFile, outputFile, begin, length);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void copyFile(File inputFile, File outputFile, int begin, int length) throws IOException {
        byte[] buffer = new byte[length];
        long totalCopyByte = 0;
        try (InputStream is = new FileInputStream(inputFile);
             OutputStream os = new FileOutputStream(outputFile, true)) {

            is.read(buffer, begin, length);
            os.write(buffer, begin, length);
            totalCopyByte += length;
            long numberThread = Thread.currentThread().getId();
            System.out.println(totalCopyByte + " bytes copied in block # " + numberThread);
        } catch (IOException e) {
            throw e;
        }
    }


}


