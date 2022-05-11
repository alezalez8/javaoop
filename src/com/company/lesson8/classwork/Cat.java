package com.company.lesson8.classwork;

import java.util.Objects;

public class Cat implements Cloneable {
    private String name;
    private int age;
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Cat() {
        super();
    }
    public String getName() {
        return name;
    } public void setName(String name) {
        this.name = name;
    } public int getAge() {
        return age;
    } public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return    "Cat [name=" + name + ", age=" + age + "]";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cat other = (Cat) obj;
        return age == other.age && Objects.equals(name, other.name);
    }

    @Override
    protected Cat clone() throws CloneNotSupportedException {
        return (Cat)super.clone();
    }
}