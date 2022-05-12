package com.company.lesson8.hw8;

public class TestServiceStudent {
    public static void main(String[] args) throws GroupOverflowException {
        Group group = new Group("test");
        ServiceStudent student = new ServiceStudent();

        group.addStudent(student.newStudent());

        System.out.println(group);




    }

}
