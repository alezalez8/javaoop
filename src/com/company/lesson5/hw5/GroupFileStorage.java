package com.company.lesson5.hw5;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.company.lesson4.hw4.*;


public class GroupFileStorage {

    public void saveGroupToCSV(Group group) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь для сохранения файла " + group.getGroupName());
        String path = scanner.nextLine();
        File file = new File(path + "\\" + group.getGroupName() + "\\.csv");
        file.createNewFile();




    }

    public Group loadGroupFromCSV(File file) {
        return new Group();
    }

    public File findFileByGroupName(String groupName, File workFolder) {
        return new File("");
    }
}


// 1;Сергей;Иванов;м;javaoop
// 2;Евгений;Петров;м;javaoop
// 3;Елена;Сидорова;ж;javaoop
