package com.company.javaoop.lesson3.hw3;

public class Student extends Human {
    private int id;
    private String groupName;

    public Student() {
    }


    public Student(String name, String lastName, Gender gender) {
        super(name, lastName, gender);
    }

    public Student(String name, String lastName, Gender gender, int id, String groupName) {
        super(name, lastName, gender);
        this.id = id;
        this.groupName = groupName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return  "id = " + id + ", " + super.getLastName() + "  " + super.getName() +
                ",  gender: " + super.getGender() + "; ";


    }

}
