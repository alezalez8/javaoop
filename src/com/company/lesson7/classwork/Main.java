package com.company.lesson7.classwork;

public class Main {
    public static void main(String[] args) {

        Printer printer = new Printer();

        PrinterTask task1 = new PrinterTask("Hello", printer);
        PrinterTask task2 = new PrinterTask("World", printer);

        Thread thr1 = new Thread(task1);
        Thread thr2 = new Thread(task2);

        thr1.start();
        thr2.start();
    }
}
