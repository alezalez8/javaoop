package com.company.lesson5.hw5;

import com.company.lesson4.hw4.Gender;
import com.company.lesson4.hw4.Group;
import com.company.lesson4.hw4.GroupOverflowException;
import com.company.lesson4.hw4.Student;

import java.io.File;
import java.io.IOException;

public class Starter {

    public static void main(String[] args) throws IOException {

        GroupFileStorage storage = new GroupFileStorage();
        Group group = new Group("javaOOP");

        Student student1 = new Student("Aleks", "Shunin", Gender.MALE);
        Student student2 = new Student("Gena", "Ivanov", Gender.MALE);
        Student student3 = new Student("Sasha", "Petrov", Gender.MALE);
        Student student4 = new Student("Елена", "Сидорова", Gender.FEMALE);
        Student student5 = new Student("Катерина", "Шишова", Gender.FEMALE);

/*
        try {
            group.addStudent(student1);
            group.addStudent(student2);
            group.addStudent(student3);
            group.addStudent(student4);
            group.addStudent(student5);
        } catch (GroupOverflowException e) {
            System.out.println(e);
        }
        System.out.println("------------------ 1 --------------------");
        storage.saveGroupToCSV(group);
*/
        // path for save:  C:\\Users\\Администратор\\Desktop\\M
        System.out.println("------------------ 2 --------------------");


        File file1 = new File("C:\\Users\\Администратор\\Desktop\\M\\javaOOP.csv");
        storage.loadGroupFromCSV(file1);

        System.out.println("------------------ 3 --------------------");

        File file2 = new File("C:\\Users\\Администратор\\Desktop\\M");
        String groupName = "javaOOP";
        File searchFile = storage.findFileByGroupName(groupName, file2);
        System.out.println("Найден файл:  " + searchFile.getName());


    }
}

