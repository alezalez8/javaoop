package com.company.lesson10.hw10.translator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TranslateService translate = new TranslateEnglUkr();
        modeTranslate(translate);

    }




    public static void modeTranslate(TranslateService translate) {
        System.out.println("виберіть потрібну вам дію:");
        System.out.println("додавання слів до словника -натиснить 1");
        System.out.println("переклад тексту - натиснить 2");
        System.out.println("для виходу з програми натисніть будь-яку клавішу та Enter");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "1":
                translate.addAndSaveDictionary();
                break;
            case "2":
                translate.loadAndSaveTranslateText();
                break;
            default:
                return;
        }

    }
}
