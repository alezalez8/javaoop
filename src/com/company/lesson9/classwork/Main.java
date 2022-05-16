package com.company.lesson9.classwork;

public class Main {
    public static void main(String[] args) {
        Container<Integer> a = new Container<>(100);

       // a.setElement("Java");

        int sum = 50 +  a.getElement();

        System.out.println(sum);

        //Container<String> b = new Container<>("Hello world");

        System.out.println(a);
        //System.out.println(b);
    }
}

