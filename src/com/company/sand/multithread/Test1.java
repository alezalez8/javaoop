package com.company.sand.multithread;


public class Test1 {

    public static void main(String[] args) {
        long sum = 0;
        long[] arrayCycles = new long[1000];
       // long cyclesSumm = 0;
       // long total = 0;

        int arrayLength = 1_000_000;
        long[] arrayLong = new long[arrayLength];
        for (int i = 0; i < arrayLong.length; i++) {
            arrayLong[i] = i + 1;
        }

        ThreadSumm tr1 = new ThreadSumm(arrayLong, 0, 250_000);
        ThreadSumm tr2 = new ThreadSumm(arrayLong, 250_0000, 500_000);
        ThreadSumm tr3 = new ThreadSumm(arrayLong, 500_000, 750_000);
        ThreadSumm tr4 = new ThreadSumm(arrayLong, 750_000, 1_000_000);



        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            Thread trr1 = new Thread(tr1);
            Thread trr2 = new Thread(tr2);
            Thread trr3 = new Thread(tr3);
            Thread trr4 = new Thread(tr4);

            trr1.start();
            trr2.start();
            trr3.start();
            trr4.start();
            try {
                trr1.join();
                trr2.join();
                trr3.join();
                trr4.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long timeAll = System.currentTimeMillis() - start;
        System.out.println("time = " + timeAll);
        long avrTime = timeAll / 1000;

        System.out.println("Avr time is " + avrTime);







    }

}
