package com.company.lesson8.hw8;

import com.company.lesson4.hw4.Group;
import com.company.lesson4.hw4.GroupOverflowException;
import com.company.lesson4.hw4.Student;
import com.company.lesson5.hw5.CSVStringConverter;

import java.io.*;
import java.util.Scanner;


public class GroupFileStorage {
    private final com.company.lesson5.hw5.CSVStringConverter converter = new CSVStringConverter();
    private final com.company.lesson4.hw4.Group group = new com.company.lesson4.hw4.Group();

    public GroupFileStorage() {
    }

    public void saveGroupToCSV(com.company.lesson4.hw4.Group group) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь для сохранения файла " + group.getGroupName());
        String path = scanner.nextLine();
        String csvFileName = group.getGroupName() + ".csv";
        File file = new File(path, csvFileName);
        boolean isFileCreate = file.createNewFile();

        if (isFileCreate) {
            try (Writer writer = new FileWriter(file)) {
                //  CSVStringConverter converter = new CSVStringConverter();

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
        if (file.isFile()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String temp = "";
                for (; ; ) {
                    temp = reader.readLine();
                    if (temp == null) {
                        break;
                    }
                    Student student = converter.fromStringRepresentation(temp);

                    try {
                        group.addStudent(student);
                    } catch (GroupOverflowException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        System.out.println(group);
        return group;
    }

    public File findFileByGroupName(String groupName, File workFolder) {
        File groupFile = null;
        if (workFolder.isDirectory()) {
            File[] listFiles = workFolder.listFiles();
            for (int i = 0; i < listFiles.length; i++) {
                if (groupName.equals(((listFiles[i].getName()).split("\\."))[0])) {
                    groupFile = listFiles[i];
                }
            }
        }
        return groupFile;
    }
}
