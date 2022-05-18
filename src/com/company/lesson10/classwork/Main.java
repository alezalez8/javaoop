package com.company.lesson10.classwork;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        final int LIST_SIZE = 20;
        List<Integer> list = new ArrayList<>(LIST_SIZE);

        Random rn = new Random();
        for (int i = 0; i < LIST_SIZE; i++) {
            list.add(rn.nextInt(15));
        }
        System.out.println(list);

        Map<Integer, Integer> stat = new HashMap<>();

        for (Integer k : list) {
            if (stat.containsKey(k)) {
                stat.put(k, stat.get(k) + 1);
            } else {
                stat.put(k, 1);
            }
        }
        System.out.println(stat);

        //  variant 2
        for (Integer k : list) {
            Integer n = stat.get(k);
            if (n == null) {
                stat.put(k, 1);
            } else {
                stat.put(k, n + 1);
            }
        }
        System.out.println(stat);


    }


    }

