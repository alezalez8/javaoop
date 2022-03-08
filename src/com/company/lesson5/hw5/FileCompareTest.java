package com.company.lesson5.hw5;

import java.io.File;
import java.io.IOException;

public class FileCompareTest {

    public static void main(String[] args) throws IOException {

        FileCompareService compareService = new FileCompareService();
        File file1;
        File file2;
        if (args.length == 2) {
            file1 = new File(args[0]);
            file2 = new File(args[1]);
            if (compareService.isFileEquals(file1, file2)) {
                System.out.println("Файлы идеинтичны");
            } else {
                System.out.println("Файлы разные");
            }

        } else {

            file1 = new File("C:\\Users\\Администратор\\Desktop\\M\\test2.txt");
            file2 = new File("C:\\Users\\Администратор\\Desktop\\A\\test2.txt");

            if (compareService.isFileEquals(file1, file2)) {
                System.out.println("Файлы идеинтичны");
            } else {
                System.out.println("Файлы разные");
            }

        }

    }
}
