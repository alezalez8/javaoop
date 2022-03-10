package com.company.sand.multithread;

public class ThreadSumm implements Runnable {
    private long[] array;
    private long summ = 0;
    private Thread thread;
    private int start;
    private int end;

    public ThreadSumm(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;

    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            summ += array[i];
        }
    }
}
