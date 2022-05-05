package com.company.lesson6.hw6;

import java.util.Random;

public class CompareTwoMethodsOfSum {
    public static void main(String[] args) {
        int sizeOfArray = 100_000_000;
        int[] testArray = createArray(sizeOfArray);

        long beginTime = System.currentTimeMillis();
        long sumOne = standartCalculator(testArray);
        long endTime = System.currentTimeMillis();
        System.out.println("Standart calculation of array. It took: " + (endTime - beginTime) + " msec");
        System.out.println("Sum is " + sumOne);

        System.out.println("--------------------------------------------------------------");
        long sumTwo = 0;
        beginTime = System.currentTimeMillis();
        CalculationOfInt thr1 = new CalculationOfInt(testArray, 0, 25_000_000);
        CalculationOfInt thr2 = new CalculationOfInt(testArray, 25_000_000, 50_000_000);
        CalculationOfInt thr3 = new CalculationOfInt(testArray, 50_000_000, 75_000_000);
        CalculationOfInt thr4 = new CalculationOfInt(testArray, 75_000_000, 100_000_000);


        Thread thread1 = new Thread(thr1);
        Thread thread2 = new Thread(thr2);
        Thread thread3 = new Thread(thr3);
        Thread thread4 = new Thread(thr4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sumTwo = thr1.getSummOfPart() + thr2.getSummOfPart() + thr3.getSummOfPart() + thr4.getSummOfPart();

        endTime = System.currentTimeMillis();
        System.out.println("Multithread calculation of array. It took: " + (endTime - beginTime) + " msec");
        System.out.println("Sum is " + sumTwo);

    }

    public static int[] createArray(int sizeOfArray) {
        int[] array = new int[sizeOfArray];
        Random random = new Random();
        for (int i = 0; i < sizeOfArray; i++) {
            array[i] = random.nextInt(1000);
        }
        return array;
    }

    public static long standartCalculator(int[] array) {
        long summ = 0;
        for (int i = 0; i < 100_000_000; i++) {
            summ += array[i];
        }
        return summ;
    }

}

class CalculationOfInt implements Runnable {

    private int[] array;
    private int begin;
    private int end;
    private long summOfPart = 0;

    public CalculationOfInt(int[] array, int begin, int end) {
        this.array = array;
        this.begin = begin;
        this.end = end;
    }

    public long summ() {
        for (int i = begin; i < end; i++) {
            summOfPart += array[i];
        }
        return summOfPart;
    }

    public long getSummOfPart() {
        return summOfPart;
    }

    @Override
    public void run() {
        summ();
    }
}

