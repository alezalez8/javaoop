package com.company.lesson10.hw10.translator;

public class Main {
    public static void main(String[] args) {
        TranslateService translate = new TranslateEnglUkr();
        translate.saveDict();
        translate.loadDict();

        translate.printDictionary();

    }
}
