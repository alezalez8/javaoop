package com.company.lesson6.hw6;

import java.math.BigInteger;

public class OneHundredThreads {

    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {
            Thread thread = new Thread(new FactorialFromNumber());
            thread.start();
        }
    }

}

class FactorialFromNumber implements Runnable {

    private BigInteger factorialSum = BigInteger.ZERO;

    public BigInteger customFactorial(long numberOfFactorial) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = 2; i <= numberOfFactorial; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        int currentThreadNumber = Integer.parseInt(thread.getName().substring(7));
        factorialSum = factorialSum.add(customFactorial(currentThreadNumber));
        System.out.println("Thread number " + currentThreadNumber + ":  factorial = " + factorialSum);
    }
}
