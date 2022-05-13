package com.company.lesson8.classwork;

import java.lang.reflect.Field;

public class Main {

        public static void main(String[] args) {

            Cat cat1 = new Cat("Vaska", 5);
            Cat cat2 = new Cat("Vaska", 5);

            System.out.println(cat1 == cat2);
            System.out.println(cat1.equals(cat2));
            System.out.println(cat1.hashCode());
            System.out.println(cat2.hashCode());
            System.out.println("-----------------------------");

            try {
                Cat cat3 = cat1.clone();

                System.out.println(cat3 == cat1);
                System.out.println(cat3.getClass().equals(cat1.getClass()));
                System.out.println(cat3.equals(cat1));

            } catch (CloneNotSupportedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println("-----------------------------");

            Class catClass = cat1.getClass();

            Field[] catFields = catClass.getDeclaredFields();
            for (int i = 0; i < catFields.length; i++) {
                System.out.println(catFields[i]);
            }
            System.out.println("-----------------------------");

            Class[] interfaces = catClass.getInterfaces();
            for (int i = 0; i < interfaces.length; i++) {
                System.out.println(interfaces[i]);
            }
            System.out.println("-----------------------------");

            try {
                Field catAge = catClass.getDeclaredField("age");
                catAge.setAccessible(true);
                catAge.setInt(cat1, 100500);
            } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println(cat1);

        }
}
