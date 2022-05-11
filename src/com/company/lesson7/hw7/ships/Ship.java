package com.company.lesson7.hw7.ships;

public class Ship implements Runnable {
    private int amountOfBox;
    private Dock dock;

    public Ship(Dock dock, int amountOfBox) {
        this.dock = dock;
        this.amountOfBox = amountOfBox;
    }

    @Override
    public void run() {
       dock.upLoad(amountOfBox);
    }
}


