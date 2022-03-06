package com.company.lesson5.hw5;

import com.company.lesson4.hw4.Student;

public interface StringConverter {

    public String toStringRepresentation(Student student);

    public Student fromStringRepresentation(String str);

}
