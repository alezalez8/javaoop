package com.company.lesson5.hw5;

import com.company.lesson4.hw4.Gender;
import com.company.lesson4.hw4.Student;

public class CSVStringConverter implements StringConverter {
    private Student student;
    private String csvStroka;

    @Override
    public String toStringRepresentation(Student student) {
        if (student != null) {
            csvStroka = student.getId() + ";" +
                    student.getName() + ";" +
                    student.getLastName() + ";" +
                    student.getGender().toString() + ";" +
                    student.getGroupName() + "\n";
        }
        return csvStroka;
    }

    @Override
    public Student fromStringRepresentation(String str) {
        String[] fieldsOfStudent = str.split("[,;]");
        if (fieldsOfStudent.length != 5) {
            System.out.println("Данная строка не содержит все данные о студенте");
            return null;
        }
        student = new Student();
        student.setId(Integer.parseInt(fieldsOfStudent[0]));
        student.setName(fieldsOfStudent[1]);
        student.setLastName(fieldsOfStudent[2]);
        if (fieldsOfStudent[3].equals(Gender.MALE.toString())) {
            student.setGender(Gender.MALE);
        } else {
            student.setGender(Gender.FEMALE);
        }
        student.setGroupName(fieldsOfStudent[4]);
        return student;
    }
}
