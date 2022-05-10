package com.company.lesson6.hw6.shell;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{8, 14, -6, -32, 45, 67, -18, 2, 15, -15, -10, 11, 5, 0, -2, 7, 3};
        //int[] array = new int[]{8, 14, -6, -32, 45, 67, -18};
        System.out.println(Arrays.toString(array));
        int[][] partsOfArray = dividerOfArray(array);
        if(partsOfArray == null) return;


        Thread thread1 = new Thread(new ShellSort(partsOfArray[0]));
        Thread thread2 = new Thread(new ShellSort(partsOfArray[1]));
        Thread thread3 = new Thread(new ShellSort(partsOfArray[2]));
        Thread thread4 = new Thread(new ShellSort(partsOfArray[3]));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       array =  merge(merge(partsOfArray[0], partsOfArray[1]), merge(partsOfArray[2], partsOfArray[3]));
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(Arrays.toString(array));
    }

    private static int[][] dividerOfArray(int[] array) {
        int size = array.length;
        int numberOfArray = 4;
        if (size / numberOfArray < 2) {
            System.out.println(" Массив нельзя разбить на четыре подмассива, ");
            System.out.println(" многопоточная сортировка нецелесообразна ");
            return null;
        }
        int lengthOfPart = size / numberOfArray;
        int[] partOne = new int[lengthOfPart];
        int[] partTwo = new int[lengthOfPart];
        int[] partThree = new int[lengthOfPart];
        int[] partFour = new int[size - lengthOfPart * 3];

        System.arraycopy(array, 0, partOne, 0, lengthOfPart);
        System.arraycopy(array, lengthOfPart, partTwo, 0, lengthOfPart);
        System.arraycopy(array, lengthOfPart * 2, partThree, 0, lengthOfPart);
        System.arraycopy(array, lengthOfPart * 3, partFour, 0, size - numberOfArray * 3);

        return new int[][]{partOne, partTwo, partThree, partFour};

    }

    public static int[] merge(int[] firstArray, int[] secondArray) {
        int[] result = new int[firstArray.length + secondArray.length];
        int l = 0;
        int r = 0;
        for (int i = 0; i < result.length; i++) {
            if (l >= firstArray.length) {
                result[i] = secondArray[r];
                r += 1;
            } else if (r >= secondArray.length) {
                result[i] = firstArray[l];
                l += 1;
            } else if (firstArray[l] < secondArray[r]) {
                result[i] = firstArray[l];
                l += 1;
            } else {
                result[i] = secondArray[r];
                r += 1;
            }
        }
        return result;
    }

}