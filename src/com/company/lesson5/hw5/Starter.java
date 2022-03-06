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

        try {
            group.addStudent(student1);
            group.addStudent(student2);
            group.addStudent(student3);
        } catch (GroupOverflowException e) {
            System.out.println(e);
        }

        storage.saveGroupToCSV(group);




/*
        File source = new File("C:\\Users\\Администратор\\Desktop\\A");
        File target = new File("C:\\Users\\Администратор\\Desktop\\M");
        String extens = "pdf";

        CopeFileService fileService = new CopeFileService(source, target, extens);
        fileService.copyDefiniteFile();
*/

    }
}

//  C:\\Users\\Администратор\\Desktop\\M
// C:\Users\Администратор\Desktop\M
