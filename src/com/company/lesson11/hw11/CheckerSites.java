package com.company.lesson11.hw11;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckerSites {
    public static void main(String[] args) {
        System.out.println(getListSites());
       // String p = "C://ua//prog//academy//javaoop//sitesText.txt";

    }


    public static List<String> getListSites() {
        List<String> listSites = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter path to file");
        String path = scanner.nextLine();
        scanner.close();
        File file = new File(path);
        if (file.isFile()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

                for (; ; ) {
                    String currentHost = "";
                    if ((currentHost = bufferedReader.readLine()) != null) {
                        listSites.add(currentHost);
                    } else {
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("File is not found");
        }
        return listSites;
    }
}
