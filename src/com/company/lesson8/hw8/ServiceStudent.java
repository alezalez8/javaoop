package com.company.lesson8.hw8;

import java.util.Scanner;

public class ServiceStudent {
    private Gender gender;
    private Student student;

    public Student newStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите через пробел имя, фамилию и пол (в формате \"м или ж\" студента");
        String inpStudent = scanner.nextLine();
        String[] inputData = inpStudent.split("[ +]");
        if(inputData.length != 3) {
            System.out.println("Вы неправильно ввели данные");
            return  null;
        }
        if (inputData[2].toLowerCase().matches("[mfмж]")) {
            if (inputData[2].equalsIgnoreCase("m")
                    || inputData[2].equalsIgnoreCase("м")) {
                gender = Gender.MALE;
            } else {
                gender = Gender.FEMALE;
            }
        } else {
            System.out.println("Вы неправильно ввели пол студента");
            return null;
        }

        if (isNameCorrect(inputData[0]) &&
                isNameCorrect(inputData[1])) {
            student = new Student(inputData[0], inputData[1], gender);
            return student;
        }
        return null;
    }

    public boolean isNameCorrect(String name) {
        if (name.length() <= 1) {
            System.out.println("Имя(Фамилия) не может быть таким коротким");
            return false;
        }
        if (name.length() > 15) {
            System.out.println("Имя(Фамилия) не может быть таким длинным");
            return false;
        }
        return true;
    }

}
