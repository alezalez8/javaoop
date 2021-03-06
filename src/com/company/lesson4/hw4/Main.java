package com.company.lesson4.hw4;

public class Main {
    public static void main(String[] args) throws StudentNotFoundException {

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

        Group group = new Group("javaoop");

        try {
            group.addStudent(student1);
            group.addStudent(student2);
            group.addStudent(student3);
            group.addStudent(student4);
            group.addStudent(student5);
            group.addStudent(student6);
            group.addStudent(student7);
            group.addStudent(student8);
            group.addStudent(student9);
            group.addStudent(student10); // the same as student9
            group.addStudent(student11);
            group.addStudent(student12);

        } catch (GroupOverflowException e) {
            System.out.println(e);
        }
        System.out.println("----------------1------------------------");

        try {
            group.searchStudentByLastName("Sverdlov");
            group.searchStudentByLastName("Sverd");  // try to find non-existent student
        } catch (StudentNotFoundException e) {
            System.out.println(e);
        }
        System.out.println("------------------2----------------------");

        group.removeStudentByID(0); // try to delete non-existent student
        group.removeStudentByID(9);
        group.removeStudentByID(10);

        System.out.println("------------------3----------------------");
        System.out.println(group);

        System.out.println("------------------4----------------------");
        try {
            group.addStudent(student9);  // try to add one more student
            group.addStudent(student12);
        } catch (GroupOverflowException e) {
            System.out.println(e);
        }

        System.out.println("-------------------5---------------------");
        System.out.println(group);

        group.removeStudentByID(4);
        group.removeStudentByID(5);
        group.removeStudentByID(6);
        group.removeStudentByID(7);
        System.out.println("-------------------6---------------------");
        System.out.println(group);
    }

}
