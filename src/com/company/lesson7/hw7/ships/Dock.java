package com.company.lesson7.hw7.ships;

public class Dock {

    private boolean isFull;
    private int amountOfCargo;
    public static volatile int amountOfShip = 0;


    public Dock() {

    }

    public synchronized void upLoad(int amountOfCargo) {
        amountOfShip++;
        if (amountOfShip < 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (; amountOfCargo > 0; amountOfCargo--) {
            System.out.println("upLoad  " + amountOfCargo + " thread " + Thread.currentThread().getId());
            System.out.println("amountOfShip = " + amountOfShip);

            try {
                wait(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
        amountOfCargo--;
        amountOfShip--;
    }
}


