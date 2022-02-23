package com.company.lesson4.hw4;

public class TestServiceStudent {
    public static void main(String[] args) throws GroupOverflowException {
        Group group = new Group("test");
        ServiceStudent student = new ServiceStudent();

        group.addStudent(student.newStudent());

        System.out.println(group);




    }

}
