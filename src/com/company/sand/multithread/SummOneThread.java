package com.company.sand.multithread;

public class SummOneThread {
    public static void main(String[] args) {

        long sum = 0;
        long[] arrayCycles = new long[1000];
        long cyclesSumm = 0;
        long avarageCycle = 0;

        int arrayLength = 1000000;
        long[] arrayLong = new long[arrayLength];
        for (int i = 0; i < arrayLong.length; i++) {
            arrayLong[i] = i + 1;
        }

        for (int t = 0; t < arrayCycles.length; t++) {
            long cycle;
            sum = 0;
            long beforeTime = System.nanoTime();

            for (int i = 0; i < arrayLong.length; i++) {
                sum += arrayLong[i];
            }
            cycle = System.nanoTime() - beforeTime;
            arrayCycles[t] = cycle;
        }


        for (int i = 0; i < arrayCycles.length; i++) {
            cyclesSumm += arrayCycles[i];
        }
        avarageCycle = cyclesSumm / arrayCycles.length;
        System.out.println("Сума: " + sum + "; середній час виконання для 1000 разів: " + avarageCycle);
    }
}

