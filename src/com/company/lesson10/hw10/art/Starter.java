package com.company.lesson10.hw10.art;

import java.util.List;
import java.util.Scanner;

public class Starter {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Input the text to convert into ASCII-art: ");
        String text = scan.nextLine();
        scan.close();
        TestOne tr = new TestOne();

        List<List<String>> arrStr = tr.StrToAsciiConvert(text);
        tr.asciiOut(arrStr);

    }
}
