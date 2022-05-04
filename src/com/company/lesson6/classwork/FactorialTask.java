package com.company.lesson6.classwork;

import java.math.BigInteger;

public class FactorialTask implements Runnable {
    private int n;
    private BigInteger factorialSum = BigInteger.ZERO;


    public FactorialTask(int n) {
        this.n = n;
    }

    public BigInteger calculateFactorial(int number) {
        BigInteger fact = BigInteger.ONE;
        for (int i = 2; i <= number; i++) {

            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }

    @Override
    public void run() {
        Thread thr = Thread.currentThread();
        for (int i = 0; i < n; i++) {
            if (thr.isInterrupted()) {
                System.out.println(thr.getName() + " interrupted");
                return;
            }

            BigInteger fact = calculateFactorial(i);
            System.out.println(thr.getName() + " " + i + "!= " + fact);
            factorialSum = factorialSum.add(fact);
        }

    }

    public BigInteger getFactorialSum() {
        return factorialSum;
    }
}
