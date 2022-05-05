package com.company.lesson6.hw6;

import java.math.BigInteger;

public class OneHundredThreads {

    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {
            Thread thread = new Thread(new FactorialFromNumber());
            thread.start();
            System.out.println("----------------  " + i + " -----------------------------");
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
        System.out.println(factorial);
        return factorial;
    }


    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        long currentNumberOfThread = thread.getId();
       // System.out.println("Thread name is " + thread.getName() + "  and number is " + currentNumberOfThread);
        factorialSum = factorialSum.add(customFactorial(currentNumberOfThread));
    }
}
