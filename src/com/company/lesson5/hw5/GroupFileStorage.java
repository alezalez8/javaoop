package com.company.lesson5.hw5;

import java.io.*;
import java.util.Scanner;

import com.company.lesson4.hw4.*;


public class GroupFileStorage {

    public void saveGroupToCSV(Group group) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь для сохранения файла " + group.getGroupName());
        String path = scanner.nextLine();
        String csvFileName = group.getGroupName() + ".csv";
        File file = new File(path, csvFileName);
        boolean isFileCreate = file.createNewFile();

        if (isFileCreate) {
            try (Writer writer = new FileWriter(file)) {
                CSVStringConverter converter = new CSVStringConverter();

                for (int i = 0; i < group.getStudents().length; i++) {
                    if ((group.getStudents())[i] != null) {
                        String csvStroka = converter.toStringRepresentation((group.getStudents())[i]);
                        writer.write(csvStroka);
                    }
                }

                System.out.println("Файл успешно сохранен");

            }
        } else {
            System.out.println("Не могу создать файл с таким именем");
        }

    }

    public Group loadGroupFromCSV(File file) throws IOException {
        Group group = new Group();
        CSVStringConverter converter = new CSVStringConverter();
        if (file.isFile()) {

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String studentCSV = "";
                String temp = "";
                for (; ; ) {
                    temp = reader.readLine();
                    if (temp == null) {
                        break;
                    }
                    converter.fromStringRepresentation(temp);

                    studentCSV += temp + System.lineSeparator();

                }
                System.out.println(studentCSV);
            }

        }
        return group;
    }

    public File findFileByGroupName(String groupName, File workFolder) {
        return new File("");
    }
}


// 1;Сергей;Иванов;м;javaoop
// 2;Евгений;Петров;м;javaoop
// 3;Елена;Сидорова;ж;javaoop
