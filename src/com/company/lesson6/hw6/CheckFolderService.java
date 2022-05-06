package com.company.lesson6.hw6;

import java.io.File;
import java.util.Scanner;

public class CheckFolderService {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input path to folder you want to monitor");
        String pathFolder = scanner.nextLine();
        scanner.close();

        //String pathFolder = "C://tempTwo";
        File file = new File(pathFolder);
        FilePresent filePresent = new FilePresent(file);
        Thread thread = new Thread(filePresent);
        thread.start();
        // todo something else

    }
}

class FilePresent implements Runnable {
    private File file;

    public FilePresent(File file) {
        this.file = file;
    }

    private int countPresentFileInDir(File file) {
        int amountOfFile = 0;
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                amountOfFile++;
            }
        }
        return amountOfFile;
    }

    @Override
    public void run() {
        int temp = countPresentFileInDir(file);
        for (; ; ) {

            if (temp != countPresentFileInDir(file)) {
                if (temp > countPresentFileInDir(file)) {
                    System.out.println("One or more file was delete");
                } else {
                    System.out.println("One or more file was added");
                }
                temp = countPresentFileInDir(file);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}