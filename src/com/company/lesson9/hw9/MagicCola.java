package com.company.lesson9.hw9;

import java.util.ArrayDeque;
import java.util.Deque;

public class MagicCola {
    public static void main(String[] args) {
        printAllPerson(2);

    }

    public static void printAllPerson(int countOfCups) {
        Deque<String> nameOfPeople = new ArrayDeque<>();

        nameOfPeople.addLast("Sheldon");
        nameOfPeople.addLast("Leonard");
        nameOfPeople.addLast("Volovitc");
        nameOfPeople.addLast("Kutrapalli");
        nameOfPeople.addLast("Penny");

        String temp;
        for (int i = 0; i < countOfCups; i++) {
            temp = nameOfPeople.removeFirst();
            for (int j = 0; j < 2; j++) {
                nameOfPeople.addLast(temp);
            }
        }

        System.out.println(nameOfPeople);
    }

}
