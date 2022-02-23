package com.company.javaoop.lesson4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Vaska", 6);
        Cat cat2 = new Cat("Luska", 2);
        Cat cat3 = new Cat("Umka", 4);
        Cat cat4 = new Cat("Barsik", 2);
        Cat cat5 = new Cat("Kuzia", 5);


        Cat[] cats = new Cat[]{cat1, cat2, cat3,  cat4, cat5};
        for (int i = 0; i < cats.length; i++) {
            System.out.println(cats[i]);
        }
        System.out.println();

       // CatNameComparator comparator = new CatNameComparator();

       // Arrays.sort(cats, new CatNameComparator());
        Arrays.sort(cats, new CatAgeComparator().thenComparing(new CatNameComparator()));
      //  Arrays.sort(cats, comparator);

      //  Arrays.sort(cats, Comparator.comparing(Cat::getAge));
        for (int i = 0; i < cats.length; i++) {
            System.out.println(cats[i]);
        }


    }
}
