package com.company.javaoop.lesson2;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        Employee employee = new Employee("Aleks", "Ts", 1, "sci dev");
        System.out.println(employee.getName());
        System.out.println(employee.hashCode());
        System.out.println(employee);

        Person person1 = employee;
        System.out.println(person1);
        if (person1.getClass().equals(Employee.class)) {
            Employee employee1 = (Employee) person1;
            System.out.println("OK");

        } else {
            System.out.println("Not");
        }


    }
}
