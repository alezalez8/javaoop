package com.company.lesson4.hw4;

public class CSVStringConverter implements StringConverter {
    private Student student;
    private String csvStroka = "";


    @Override
    public String toStringRepresentation(Student student) {
        if (student != null) {
            csvStroka = "id;" + student.getId() + "\n"
                    + "name;" + student.getName() + "\n"
                    + "lastName;" + student.getLastName()
                    + "gender;" + student.getGender().toString()
                    + "groupName;" + student.getGroupName();
        }
        return csvStroka;
    }

    @Override
    public Student fromStringRepresentation(String str) {
        return null;
    }
}
