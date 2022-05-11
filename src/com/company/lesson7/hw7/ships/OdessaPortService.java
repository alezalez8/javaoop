package com.company.lesson7.hw7.ships;

class OdessaPortService implements Runnable {

    private Ship ship;
    private int box = 10;

    public OdessaPortService(Ship ship) {
        this.ship = ship;
    }

    @Override
    public void run() {
        for (int i = 0; i < box; i++) {
            ship.unloadCargo();
        }
    }


}
