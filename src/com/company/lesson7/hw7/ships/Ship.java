package com.company.lesson7.hw7.ships;

import java.util.concurrent.atomic.AtomicBoolean;

public class Ship {
    private int box = 10;
    private Long idCurrentShip = null;
    private AtomicBoolean isLoaded = new AtomicBoolean(true);
    private boolean isEmpty = false;

    public synchronized void unloadCargo() {
        long idShip = Thread.currentThread().getId();
        for (; !(idCurrentShip == null || idCurrentShip != idShip); ) {
            try {
                wait(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        box--;
        System.out.println("Осталось выгрузить " + box + " ящиков, корабль " + idShip);
        idCurrentShip = idShip;
        notify();

    }


}


