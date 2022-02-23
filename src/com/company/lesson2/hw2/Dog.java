package com.company.javaoop.lesson2.hw2;

public class Dog extends Animal{
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public Dog(String ration, String color, int weight, String name) {
        super(ration, color, weight);
        this.name = name;
    }

    @Override
    public String getVoice() {
        return "Gav, gav";
    }

    @Override
    public void eat() {
        System.out.println(name + " is eating");
    }

    @Override
    public void sleep() {
        System.out.println(name + " is sleeping now");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name is " + name + ", eats " + super.getRation() +
                ", color is " + super.getColor() +
                ", and weight is " + super.getWeight() + " kg";
    }
}

