package com.company.lesson9.hw9;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StatsOfWord {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter path to file");
        File file = new File(scanner.nextLine());
        scanner.close();

        getFile(getText(file));
    }

    public static String getText(File file) {
        String text = "";
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            String temp;
            for (; (temp = bufferedReader.readLine()) != null; ) {
                text += temp;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }


    public static void getFile(String text) {
        Map<Character, Integer> map = new HashMap<>();
        char[] arrayOfChar = text.toCharArray();

        for (int i = 0; i < arrayOfChar.length; i++) {
            if (Character.isLetter(arrayOfChar[i])) {
                if (map.containsKey(arrayOfChar[i])) {
                    map.put(arrayOfChar[i], map.get(arrayOfChar[i]) + 1);
                } else {
                    map.put(arrayOfChar[i], 1);
                }
            }
        }
        map.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .forEach(System.out::println);

    }
}
