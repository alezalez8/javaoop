package com.company.lesson6.hw6.shell;

public class ShellSort implements Runnable {

    private int[] array;

    public ShellSort(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    public int[] shellSort(int[] array) {
        int step = array.length / 2;
        for (; step > 0; ) {
            for (int i = step; i < array.length; i++) {
                for (int j = i; j >= step && array[j] < array[j - step]; j -= step) {
                    int temp = array[j];
                    array[j] = array[j - step];
                    array[j - step] = temp;
                }
            }
            step = step / 2;
        }
        return array;
    }


    @Override
    public void run() {
        array = shellSort(array);
    }
}
