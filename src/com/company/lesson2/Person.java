package com.company.javaoop.lesson2;

public class Person {
    private String name;
    private String lastName;

    public Person(String name, String lastName) {
        super();
        this.name = name;
        this.lastName = lastName;
    }

    public Person() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", lastName=" + lastName + "]";
    }
}