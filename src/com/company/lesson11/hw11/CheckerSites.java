package com.company.lesson11.hw11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckerSites {
    public static void main(String[] args) {
        checkSite(getListSites());
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

    public static void checkSite(List<String> listSites) {
        String prefix = "http://";
        for (int i = 0; i < listSites.size(); i++) {
            String pathFull = listSites.get(i);
            if (!pathFull.substring(0, 4).equals("http")) {
                pathFull = prefix + listSites.get(i);
            }

            try {
                URL url = new URL(pathFull);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("HEAD");
                if (connection.getResponseCode() >= 200 && connection.getResponseCode() < 400) {
                    System.out.println("Site  " + listSites.get(i) + " is  valid");
                } else {
                    System.out.println("Site " + listSites.get(i) + " is not found!");
                }
                connection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
