/**
 * взял генератор матрицы 5х8 с сайта
 * http://arduino.on.kg/redaktor-simvolov-dlya-matric-5h7
 */


package com.company.lesson10.hw10.art;


import java.util.ArrayList;
import java.util.List;

public class ArtASCII {

    public static void main(String[] args) {

        mySymbol();
        byte[] b = {0x1E, 0x11, 0x11, 0x1E, 0x11, 0x11, 0x1E};

    }


    public static List<String> mySymbol() {
        List<String> arrayOfArtSymbols = new ArrayList<>();
        String a = " *** \n\r*   *\n\r*   *\n\r*   *\n\r*****\n\r*   *\n\r*   *\n\r";
        String b = "**** \n\r*   *\n\r*   *\n\r***** \n\r*   *\n\r*   *\n\r**** \n\r";
        String c = " *** \n\r*   *\n\r*    \n\r*    \n\r*    \n\r*   *\n\r *** \n\r";
        String d = "***  \n\r*  * \n\r*   *\n\r*   *\n\r*   *\n\r*  * \n\r***  \n\r";

        arrayOfArtSymbols.add(a);
        arrayOfArtSymbols.add(b);
        arrayOfArtSymbols.add(c);
        arrayOfArtSymbols.add(d);

        String e = " *** \n\r*   *\n\r*   *\n\r*   *\n\r*****\n\r*   *\n\r*   *\n\r*   *";
        String f = " *** \n\r*   *\n\r*   *\n\r*   *\n\r*****\n\r*   *\n\r*   *\n\r*   *";
        String g = " *** \n\r*   *\n\r*   *\n\r*   *\n\r*****\n\r*   *\n\r*   *\n\r*   *";
        String h = " *** \n\r*   *\n\r*   *\n\r*   *\n\r*****\n\r*   *\n\r*   *\n\r*   *";
        String i = " *** \n\r*   *\n\r*   *\n\r*   *\n\r*****\n\r*   *\n\r*   *\n\r*   *";
        String j = " *** \n\r*   *\n\r*   *\n\r*   *\n\r*****\n\r*   *\n\r*   *\n\r*   *";
        String k = " *** \n\r*   *\n\r*   *\n\r*   *\n\r*****\n\r*   *\n\r*   *\n\r*   *";
        String l = " *** \n\r*   *\n\r*   *\n\r*   *\n\r*****\n\r*   *\n\r*   *\n\r*   *";
        String m = " *** \n\r*   *\n\r*   *\n\r*   *\n\r*****\n\r*   *\n\r*   *\n\r*   *";
        String n = " *** \n\r*   *\n\r*   *\n\r*   *\n\r*****\n\r*   *\n\r*   *\n\r*   *";
        String o = " *** \n\r*   *\n\r*   *\n\r*   *\n\r*   *\n\r*   *\n\r*   *\n\r *** \n\r";

        String p = " *** \n\r*   *\n\r*   *\n\r*   *\n\r*****\n\r*   *\n\r*   *\n\r*   *";
        String q = " *** \n\r*   *\n\r*   *\n\r*   *\n\r*****\n\r*   *\n\r*   *\n\r*   *";
        String r = " *** \n\r*   *\n\r*   *\n\r*   *\n\r*****\n\r*   *\n\r*   *\n\r*   *";
        String s = " *** \n\r*   *\n\r*   *\n\r*   *\n\r*****\n\r*   *\n\r*   *\n\r*   *";
        String t = " *** \n\r*   *\n\r*   *\n\r*   *\n\r*****\n\r*   *\n\r*   *\n\r*   *";
        String u = " *** \n\r*   *\n\r*   *\n\r*   *\n\r*****\n\r*   *\n\r*   *\n\r*   *";
        String v = " *** \n\r*   *\n\r*   *\n\r*   *\n\r*****\n\r*   *\n\r*   *\n\r*   *";
        String w = " *** \n\r*   *\n\r*   *\n\r*   *\n\r*****\n\r*   *\n\r*   *\n\r*   *";
        String x = " *** \n\r*   *\n\r*   *\n\r*   *\n\r*****\n\r*   *\n\r*   *\n\r*   *";
        String y = " *** \n\r*   *\n\r*   *\n\r*   *\n\r*****\n\r*   *\n\r*   *\n\r*   *";
        String z = " *** \n\r*   *\n\r*   *\n\r*   *\n\r*****\n\r*   *\n\r*   *\n\r*   *";
        for (String temp : arrayOfArtSymbols
        ) {
            System.out.println(temp);
        }

        return arrayOfArtSymbols;
    }


}
