package com.company.lesson7.classwork;

public class Printer {

    private Long idThread = null;


    public synchronized void printText(String text) {
        long id = Thread.currentThread().getId();
        for (; !(idThread == null || idThread != id); ) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(text);
        idThread = id;
        notifyAll();
    }
}
