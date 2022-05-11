package com.company.lesson7.hw7.ships;

public class Main {
    public static void main(String[] args) {
        int amountOfBox = 10;

        Dock dock = new Dock();

        Ship ship1 = new Ship(dock, amountOfBox);
        Ship ship2 = new Ship(dock, amountOfBox);
        Ship ship3 = new Ship(dock, amountOfBox);

        Thread thread1 = new Thread(ship1);
        Thread thread2 = new Thread(ship2);
        Thread thread3 = new Thread(ship3);

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
