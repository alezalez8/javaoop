package com.company.javaoop.lesson2.hw2;

public class UpDownTransformer extends TextTransformer {

    public UpDownTransformer() {
    }

    @Override
    public String transform(String text) {
        String[] arrayText = text.split("");
        for (int i = 0; i < arrayText.length; i++) {
            if (i % 2 != 0) {
                arrayText[i] = arrayText[i].toLowerCase();
            } else {
                arrayText[i] = arrayText[i].toUpperCase();
            }
        }
        text = String.join("", arrayText);
        return text;
    }
}
