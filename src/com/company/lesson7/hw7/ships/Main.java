package com.company.lesson7.hw7.ships;

public class Main {
    public static void main(String[] args) {

        Ship ship1 = new Ship();
        Ship ship2 = new Ship();
        Ship ship3 = new Ship();

        OdessaPortService serviceOne = new OdessaPortService(ship1);
        OdessaPortService serviceTwo = new OdessaPortService(ship2);
        OdessaPortService serviceThree = new OdessaPortService(ship3);

        Thread threadOne = new Thread(serviceOne);
        Thread threadTwo = new Thread(serviceTwo);
        Thread threadThree = new Thread(serviceThree);

        threadOne.start();
        threadTwo.start();
        threadThree.start();

/*
        try {
            threadOne.join();
            threadTwo.join();
            threadThree.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/
    }
}
