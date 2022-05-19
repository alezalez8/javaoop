package com.company.lesson9.hw9;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimpleList {
    public static void main(String[] args) {
        addAndRemove();
    }

    public static void addAndRemove() {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(100));
        }
        for (int i = 0; i < 2; i++) {
            list.remove(0);
        }

        list.remove(list.size() - 1);
        System.out.println(list);
    }

}
