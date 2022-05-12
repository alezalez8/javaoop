package com.company.lesson8.hw8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws StudentNotFoundException {

        Student student1 = new Student("Aleks", "Shunin", Gender.MALE);
        Student student2 = new Student("Gena", "Ivanov", Gender.MALE);
        Student student3 = new Student("Sasha", "Petrov", Gender.MALE);

/*
        Student student1 = new Student("Aleks", "Shunin", Gender.MALE);
        Student student2 = new Student("Gena", "Ivanov", Gender.MALE);
        Student student3 = new Student("Sasha", "Petrov", Gender.MALE);
        Student student4 = new Student("Leha", "Sidorov", Gender.MALE);
        Student student5 = new Student("Sveta", "Ischenko", Gender.FEMALE);
        Student student6 = new Student("Lena", "Kapustina", Gender.FEMALE);
        Student student7 = new Student("Igor", "Zadynayskyj", Gender.MALE);
        Student student8 = new Student("Egor", "Sverdlov", Gender.MALE);
        Student student9 = new Student("Yuriy", "Azarov", Gender.MALE);
        Student student10 = new Student("Yuriy", "Azarov", Gender.MALE);
        Student student11 = new Student("Oleg", "Menshikov", Gender.MALE);
        Student student12 = new Student("Artyr", "Lepotov", Gender.MALE);
*/

        ServiceStudent student = new ServiceStudent();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название группы");
        Group group = new Group(scanner.nextLine());
        System.out.println("Заполните группу студентов");


        try {
            group.addStudent(student.newStudent());
            group.addStudent(student.newStudent());
            group.addStudent(student.newStudent());
            group.addStudent(student.newStudent());
            group.addStudent(student.newStudent());
            group.addStudent(student.newStudent());
            group.addStudent(student.newStudent());
            group.addStudent(student.newStudent());
            group.addStudent(student.newStudent());
            group.addStudent(student.newStudent());
            group.addStudent(student.newStudent());


        } catch (GroupOverflowException e) {
            System.out.println(e);
        }
        System.out.println("----------------1------------------------");

        try {
            group.searchStudentByLastName("Ivanov");
            group.searchStudentByLastName("Petro");  // try to find non-existent student
        } catch (StudentNotFoundException e) {
            System.out.println(e);
        }
        System.out.println("------------------2----------------------");

        group.removeStudentByID(0); // try to delete non-existent student
        group.removeStudentByID(9);


        System.out.println("------------------3----------------------");
        System.out.println(group);

        System.out.println("------------------4----------------------");
        try {
            group.addStudent(student.newStudent());  // try to add one more student
        } catch (GroupOverflowException e) {
            System.out.println(e);
        }

        System.out.println("-------------------5---------------------");
        System.out.println(group);

        group.removeStudentByID(6);
        group.removeStudentByID(7);
        System.out.println("-------------------6---------------------");
        System.out.println(group);
    }

}
