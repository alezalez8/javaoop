package com.company.lesson9.hw9.groupstudent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Group {

    private String groupName;
    private List<Student> students = new ArrayList<>();
    private int countOfStudents = 0;

    public Group() {
    }

    public Group(String groupName) {
        this.groupName = groupName;
    }


    public boolean theSameStudentIsPresent(Student student) {
        for (Student st : students
        ) {
            if (st.getName().equals(student.getName())
                    && st.getLastName().equals(student.getLastName())) {
                return true;
            }
        }
        return false;
    }


    public void addStudent(Student student) throws GroupOverflowException {
        if (theSameStudentIsPresent(student)) {
            throw new GroupOverflowException("This student is already present in this group, you can't add this student again");
        }
        if (students.size() < 10) {
            student.setGroupName(groupName);

            int postiton = 0;
            for (Student st : students
            ) {
                if (st.getId() == postiton) {
                    postiton++;
                } else {
                    break;
                }
            }
            student.setId(postiton);
            students.add(postiton, student);

        } else {
            throw new GroupOverflowException("Group is completed, you can't added any students");
        }
    }


    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        for (Student studentLastName : students) {
            if (lastName.equals(studentLastName.getLastName())) {
                System.out.println("Student " + studentLastName + " was found");
                return studentLastName;
            }
        }
        throw new StudentNotFoundException("Student " + lastName + " was not found");

    }

    public List<Student> sortByLastName() {
        // students1.sort((o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));
        students.sort(Comparator.comparing(Human::getLastName));
        return students;
    }


    public boolean removeStudentByID(int id) {
        if (id < students.size()) {
            for (Student st : students
            ) {
                if (st.getId() == id) {
                    students.remove(st);
                    System.out.println("Student with id = " + id + " was deleted succesfully");
                    return true;
                }
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


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Группа: " + "\"" + groupName + "\"" +
                ", студенты: "
                + students.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;

        Group group = (Group) o;

        if (countOfStudents != group.countOfStudents) return false;
        if (groupName != null ? !groupName.equals(group.groupName) : group.groupName != null) return false;
        return students != null ? students.equals(group.students) : group.students == null;
    }

    @Override
    public int hashCode() {
        int result = groupName != null ? groupName.hashCode() : 0;
        result = 31 * result + (students != null ? students.hashCode() : 0);
        result = 31 * result + countOfStudents;
        return result;
    }

}
