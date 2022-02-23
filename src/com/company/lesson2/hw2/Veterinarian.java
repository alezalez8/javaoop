package com.company.javaoop.lesson2.hw2;

public class Veterinarian {
    private String name;

    public Veterinarian() {
    }

    public Veterinarian(String name) {
        this.name = name;

    }
    public void treatment(Animal animal) {
        System.out.println("I am " + name + " and I want to hear your voice " + "\n\"" + animal.getVoice() + "\"");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
