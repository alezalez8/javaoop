package com.company.javaoop.lesson1;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.setName("Barsik");
        cat1.setColor("Black");
        cat1.setWeight(5);

        Cat cat2 = new Cat();
        cat2.setName("Umka");
        cat2.setColor("White");
        cat2.setWeight(4);

        Cat cat3 = new Cat("Liza", 4, "Grey");

        System.out.println(cat1);
        System.out.println(cat1.meow());

        System.out.println(cat2);
        System.out.println(cat3);

    }
}
