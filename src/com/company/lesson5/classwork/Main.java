package com.company.lesson5.classwork;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
       /* File fileIn = new File("C:\\ua\\prog\\academy\\javaoop\\Наследование.pdf");
        File fileOut = new File(fileIn.getName());

        try {
           FileService.copyFile(fileIn, fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //char[] aChars = new char[10];
        //  String a = new String(aChars, 0, 5);

        File folderIn = new File("C:\\Users\\Администратор\\Desktop\\M");
        File folderOut = new File("C:\\Users\\Администратор\\Desktop\\M\\K");
        folderOut.mkdir();

        try {
            FileService.copyFolder(folderIn, folderOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
