package com.company.javaoop.lesson4;

import java.util.Comparator;

public class CatAgeComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Cat cat1 = (Cat) o1;
        Cat cat2 = (Cat) o2;

        int age1 = cat1.getAge();
        int age2 = cat2.getAge();

        if (age1 > age2) {
            return 1;
        }
        if (age1 < age2) {
            return -1;
        }
        return 0;
    }

}

