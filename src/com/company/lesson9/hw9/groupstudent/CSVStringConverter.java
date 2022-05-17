package com.company.lesson9.hw9.groupstudent;

public class CSVStringConverter implements StringConverter {
    private Student student;
    private String csvStroka;


    @Override
    public String toStringRepresentation(Student student) {
        if (student != null) {
            csvStroka = "id;" + student.getId() + "\n"
                    + "name;" + student.getName() + "\n"
                    + "lastName;" + student.getLastName() + "\n"
                    + "gender;" + student.getGender().toString() + "\n"
                    + "groupName;" + student.getGroupName() + "\n";
        }
        return csvStroka;
    }

    @Override
    public Student fromStringRepresentation(String str) {
        String[] fieldsOfStudent = str.split("\n");
        if (fieldsOfStudent.length != 5) {
            System.out.println("Данная строка не содержит все данные о студенте");
            return null;
        }
        String[] secondElement;
        student = new Student();
        secondElement = fieldsOfStudent[0].split("[,;]");
        student.setId(Integer.parseInt(secondElement[1]));

        secondElement = fieldsOfStudent[1].split("[,;]");
        student.setName(secondElement[1]);

        secondElement = fieldsOfStudent[2].split("[,;]");
        student.setLastName(secondElement[1]);

        secondElement = fieldsOfStudent[3].split("[,;]");
        if (secondElement[1].equals(Gender.MALE.toString())) {
            student.setGender(Gender.MALE);
        } else {
            student.setGender(Gender.FEMALE);
        }

        secondElement = fieldsOfStudent[4].split("[,;]");
        student.setGroupName(secondElement[1]);

        return student;
    }
}