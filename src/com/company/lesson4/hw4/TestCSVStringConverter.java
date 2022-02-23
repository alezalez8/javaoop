package com.company.lesson4.hw4;

import java.io.IOException;

public class TestCSVStringConverter {
    public static void main(String[] args) throws IOException {

        Student student1 = new Student("Aleks", "Shunin", Gender.MALE);
        student1.setGroupName("testGroup");
        student1.setId(1);

        CSVStringConverter converter = new CSVStringConverter();

        String csvText = converter.toStringRepresentation(student1);
        System.out.println(csvText);
        System.out.println("----------------------------------------------");

        Student student = new Student();
        student = converter.fromStringRepresentation(csvText);
        System.out.println(student + "; " + student.getGroupName());

    }
}
