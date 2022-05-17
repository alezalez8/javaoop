package com.company.lesson9.hw9.groupstudent;

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
        return "id = " + id + ", " + super.getLastName() + "  " + super.getName() +
                ",  gender: " + super.getGender() + "; ";


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        return groupName != null ? groupName.equals(student.groupName) : student.groupName == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id;
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        return result;
    }
}
