package com.company.lesson9.hw9;

import java.util.ArrayList;
import java.util.List;

public class MagicCola {
    public static void main(String[] args) {
        printAllPerson(2);

    }

    public static void printAllPerson(int countOfCups) {
        List<String> nameOfList = new ArrayList<>();

        nameOfList.add("Sheldon");
        nameOfList.add("Leonard");
        nameOfList.add("Volovitc");
        nameOfList.add("Kutrapalli");
        nameOfList.add("Penny");

        String temp;
        for (int i = 0; i < countOfCups; i++) {
            temp = nameOfList.remove(0);
            for (int j = 0; j < 2; j++) {
                nameOfList.add(temp);
            }
        }
        System.out.println(nameOfList);
    }

}
