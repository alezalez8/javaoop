package com.company.lesson5.hw5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import com.company.lesson4.hw4.*;


public class GroupFileStorage {

    public void saveGroupToCSV(Group group) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь для сохранения файла " + group.getGroupName());
        String path = scanner.nextLine();
        //File file = new File(path + "\\" + group.getGroupName() + "\\.csv");
        String csvFileName = group.getGroupName() + ".csv";
        File file = new File(path, csvFileName);
        file.createNewFile();
        try (Writer writer = new FileWriter(file)) {
            //  Student[] students = group.getStudents();
            CSVStringConverter converter = new CSVStringConverter();

            for (int i = 0; i < group.getStudents().length; i++) {

                //  converter.toStringRepresentation(students[i]);
                if ((group.getStudents())[i] != null) {
                    String csvStroka = converter.toStringRepresentation((group.getStudents())[i]);
                    writer.write(csvStroka);
                }
            }
            System.out.println("Файл успешно сохранен");
        }

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
