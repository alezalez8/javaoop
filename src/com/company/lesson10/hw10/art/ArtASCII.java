/**
 * взял генератор матрицы 5х8 с сайта
 * http://arduino.on.kg/redaktor-simvolov-dlya-matric-5h7
 * логика проги - построчный  вывод каждой из семи линий
 * состовляющей каждый символ
 */

package com.company.lesson10.hw10.art;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ArtASCII {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text");
        String text = scanner.nextLine();
        scanner.close();

        printText(text, tableOfSymbols());

    }

    public static Map<String, String[]> tableOfSymbols() {
        Map<String, String[]> myArtTable = new HashMap<>();
        String[] a = {" *** ", "*   *", "*   *", "*   *", "*****", "*   *", "*   *"};
        String[] b = {"**** ", "*   *", "*   *", "**** ", "*   *", "*   *", "**** "};
        String[] c = {" *** ", "*   *", "*    ", "*    ", "*    ", "*   *", " *** "};
        String[] d = {"***  ", "*  * ", "*   *", "*   *", "*   *", "*  * ", "***  "};
        String[] e = {"*****", "*    ", "*    ", "**** ", "*    ", "*    ", "*****"};
        String[] f = {"*****", "*    ", "*    ", "**** ", "*    ", "*    ", "*    "};
        String[] g = {" *** ", "*   *", "*    ", "* ***", "*   *", "*   *", " ****"};
        String[] h = {"*   *", "*   *", "*   *", "*****", "*   *", "*   *", "*   *"};
        String[] i = {" *** ", "  *  ", "  *  ", "  *  ", "  *  ", "  *  ", " *** "};
        String[] j = {"  ***", "   * ", "   * ", "   * ", "   * ", "*  * ", " **  "};
        String[] k = {"*   *", "*  * ", "* *  ", "**   ", "* *  ", "*  * ", "*   *"};
        String[] l = {"*    ", "*    ", "*    ", "*    ", "*    ", "*    ", "*****"};
        String[] m = {"*   *", "** **", "* * *", "* * *", "*   *", "*   *", "*   *"};
        String[] n = {"*   *", "*   *", "**  *", "* * *", "*  **", "*   *", "*   *"};
        String[] o = {" *** ", "*   *", "*   *", "*   *", "*   *", "*   *", " *** "};
        String[] p = {"**** ", "*   *", "*   *", "**** ", "*    ", "*    ", "*    "};
        String[] q = {" *** ", "*   *", "*   *", "*   *", "* * *", "*  * ", " ** *"};
        String[] r = {"**** ", "*   *", "*   *", "**** ", "* *  ", "*  * ", "*   *"};
        String[] s = {" ****", "*    ", "*    ", " *** ", "    *", "    *", "**** "};
        String[] t = {"*****", "* * *", "  *  ", "  *  ", "  *  ", "  *  ", "  *  "};
        String[] u = {"*   *", "*   *", "*   *", "*   *", "*   *", "*   *", " *** "};
        String[] v = {"*   *", "*   *", "*   *", "*   *", "*   *", " * * ", "  *  "};
        String[] w = {"*   *", "*   *", "*   *", "* * *", "* * *", "* * *", " * * "};
        String[] x = {"*   *", "*   *", " * * ", "  *  ", " * * ", "*   *", "*   *"};
        String[] y = {"*   *", "*   *", "*   *", " *** ", "  *  ", "  *  ", "  *  "};
        String[] z = {"*****", "    *", "   * ", "  *  ", " *   ", "*    ", "*****"};

        myArtTable.put("a", a);
        myArtTable.put("b", b);
        myArtTable.put("c", c);
        myArtTable.put("d", d);
        myArtTable.put("e", e);
        myArtTable.put("f", f);
        myArtTable.put("g", g);
        myArtTable.put("h", h);
        myArtTable.put("i", i);
        myArtTable.put("j", j);
        myArtTable.put("k", k);
        myArtTable.put("l", l);
        myArtTable.put("m", m);
        myArtTable.put("n", n);
        myArtTable.put("o", o);
        myArtTable.put("p", p);
        myArtTable.put("q", q);
        myArtTable.put("r", r);
        myArtTable.put("s", s);
        myArtTable.put("t", t);
        myArtTable.put("u", u);
        myArtTable.put("v", v);
        myArtTable.put("w", w);
        myArtTable.put("x", x);
        myArtTable.put("y", y);
        myArtTable.put("z", z);
        return myArtTable;
    }

    public static void printText(String text, Map<String, String[]> mySymbol) {
        String[] temp;
        String[] arrayWord = text.toLowerCase().split("");

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < arrayWord.length; j++) {
                temp = mySymbol.get(arrayWord[j]);
                if(temp!=null) {
                    System.out.print(temp[i] + "   ");
                } else {
                    System.out.print("      ");
                }
            }
            System.out.println();
        }
    }

}
