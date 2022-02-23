package com.company.javaoop.lesson2.hw2;

import java.io.File;

public class TextTransformStarter {
    public static void main(String[] args) {
        File file1 = new File("test1.txt");
        File file2 = new File("test2.txt");
        File file3 = new File("test3.txt");

        String text = "There are only two ways to live your life. " +
                "One is as though nothing is a miracle. " +
                "The other is as though everything is a miracle";


        TextTransformer transformer1 = new TextTransformer();
        TextTransformer transformer2 = new InverseTransformer();
        TextTransformer transformer3 = new UpDownTransformer();

        TextSaver saver = new TextSaver(transformer1, file1);

        saver.saveTextToFile(text);

        saver.setTransformer(transformer2);
        saver.setFile(file2);
        saver.saveTextToFile(text);

        saver.setTransformer(transformer3);
        saver.setFile(file3);
        saver.saveTextToFile(text);

    }
}
