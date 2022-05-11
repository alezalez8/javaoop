package com.company.lesson7.hw7.ships;

import java.util.concurrent.atomic.AtomicInteger;

public class Dock {

    private volatile int amountOfShip = 0;
    private AtomicInteger numberOfShip = new AtomicInteger(0);

    public Dock() {
    }

    public synchronized void upLoad(int amountOfCargo) {
        amountOfShip++;

        if (!(amountOfShip < 3)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int numberOfShip = this.numberOfShip.incrementAndGet();

        System.out.println("---------------- Судно № " +
                numberOfShip + " встало под разгрузку -------------");
        for (; amountOfCargo > 0; amountOfCargo--) {
            System.out.println("Судно № " + numberOfShip +
                    ": осталось выгрузить " + amountOfCargo + " ящик(ов)");

            try {
                wait(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        amountOfShip--;

        System.out.println("---------------- Судно № " +
                numberOfShip + " полностью разгружено -------------");
        notifyAll();
    }
}


