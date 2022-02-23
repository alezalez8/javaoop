package com.company.lesson4.hw4;

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
        String[] fueldsOfStudent = str.split("\n");
        if (fueldsOfStudent.length != 5) {
            System.out.println("Данная строка не содержит все данные о студенте");
            return null;
        }
        String[] secondElement;
        student = new Student();
        secondElement = fueldsOfStudent[0].split("[,;]");
        student.setId(Integer.parseInt(secondElement[1]));

        secondElement = fueldsOfStudent[1].split("[,;]");
        student.setName(secondElement[1]);

        secondElement = fueldsOfStudent[2].split("[,;]");
        student.setLastName(secondElement[1]);

        secondElement = fueldsOfStudent[3].split("[,;]");
        if (secondElement[1].equals(Gender.MALE.toString())) {
            student.setGender(Gender.MALE);
        } else {
            student.setGender(Gender.FEMALE);
        }

        secondElement = fueldsOfStudent[4].split("[,;]");
        student.setGroupName(secondElement[1]);

        return student;
    }
}
