package com.company.javaoop.lesson2.hw2;

public class Starter {
    public static void main(String[] args) {

        Veterinarian veterinarian = new Veterinarian("Aibolit");
        Cat cat1 = new Cat("meat", "white", 3, "Barsik");
        Cat cat2 = new Cat("Myrzik");
        cat2.setColor("grey");
        cat2.setRation("meat and vegetables");
        cat2.setWeight(4);
        Dog dog = new Dog("meat", "black", 7, "Tiran");

        System.out.println(cat1);
        System.out.println(cat2);
        System.out.println(dog);
        dog.sleep();
        cat1.eat();
        veterinarian.treatment(cat1);
        veterinarian.treatment(dog);


    }
}
