package com.company.lesson7.classwork;

public class Printer {
        private Long threadId = null;

        public synchronized void printText(String text) {
            Thread thr = Thread.currentThread();
            long id = thr.getId();

            for (; !(threadId == null || threadId != id); ) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    // TODO: handle exception
                }
            }
            System.out.println(text);
            threadId = id;
            notifyAll();
        }

    }
