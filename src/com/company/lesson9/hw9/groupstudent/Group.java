package com.company.lesson9.hw9.groupstudent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Group {

    private String groupName;
    private Student[] students = new Student[10];

    private List<Student> students1 = new ArrayList<>(10);

    private int countOfStudents = 0;

    public Group() {
    }

    public Group(String groupName) {
        this.groupName = groupName;
    }






    public boolean theSameStudentIsPresent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].hashCode() == student.hashCode()) {
                if (students[i].equals(student)) {
                   return false;
                }
            }
        }
        return true;
    }


    public void addStudent(Student student) throws GroupOverflowException {

        if(!theSameStudentIsPresent(student)) {
            throw new GroupOverflowException("This student is already present in this group, you can't add this student again");
        }

        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                if (student.getGroupName() == null) {
                    student.setGroupName(groupName);
                } else {
                    setGroupName(student.getGroupName());
                }
                student.setId(i + 1);
                students[i] = student;
                countOfStudents++;
                return;
            }
        }
        throw new GroupOverflowException("Group is completed, you can't added any students");


    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && lastName.equals(students[i].getLastName())) {
                System.out.println("Student  " + students[i].getLastName() + " was found");
                return students[i];
            }
        }
        throw new StudentNotFoundException("Student " + lastName + " was not found");
    }


    public Student[] sortByLastName() {
        Student[] factStudents = new Student[countOfStudents];
        int newArrayOfStudent = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                factStudents[newArrayOfStudent] = students[i];
                newArrayOfStudent++;
            }
        }
        Arrays.sort(factStudents, Comparator.nullsFirst(Comparator.comparing(Student::getLastName)));
        return factStudents;


    }

    public boolean removeStudentByID(int id) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && id == students[i].getId()) {
                students[i] = null;
                countOfStudents--;
                System.out.println("Student with id = " + id + " was deleted succesfully");
                return true;
            }
        }
        System.out.println("Student with id = " + id + " was not found");
        return false;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Группа: " + "\"" + groupName + "\"" +
                ", студенты: "
                + Arrays.toString(sortByLastName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;

        Group group = (Group) o;

        if (countOfStudents != group.countOfStudents) return false;
        if (groupName != null ? !groupName.equals(group.groupName) : group.groupName != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        int result = groupName != null ? groupName.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(students);
        result = 31 * result + countOfStudents;
        return result;
    }
}
