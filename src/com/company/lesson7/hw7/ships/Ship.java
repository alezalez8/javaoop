package com.company.lesson7.hw7.ships;


public class Ship implements Runnable {
    private int amountOfCargo = 10;
    private Dock dock;
    private boolean isLoading;

    public Ship(Dock dock) {
        this.dock = dock;
    }

    @Override
    public void run() {

       dock.upLoad(amountOfCargo);
    }
}


