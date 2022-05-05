package com.company.sand.multithread;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Testik {
    public static void main(String[] args) {

        double n = 3.12634;
        System.out.println(n);


        double scale = Math.pow(10, 3);

        System.out.println((Math.round(n * scale)) / scale);

        System.out.println("--------------------------");

        double nn = n * 10000;
        nn = Math.round(nn);
        System.out.println(nn);
        nn = nn / 10000;
        System.out.println(nn);

        System.out.printf("%.3f", n);




       /* int[][] arr1 = {{1, 2}, {3, 4}};
        int[][] arr2 = {{1, 5}, {3, 8}};

        System.out.println(Arrays.toString(arr1[0]));
        System.out.println(Arrays.toString(arr1[1]));

    }

    public static void saveArrays(int[][] arr1) {

        try (PrintWriter pw = new PrintWriter("SaveArrays.txt")) {
            for (int index = 0; index < arr1.length; index++) {
                pw.print(Arrays.toString(arr1[index]));
            }
        } catch (IOException e) {
            e.getStackTrace();
        }*/


    }
}
