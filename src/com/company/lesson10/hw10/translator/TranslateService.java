package com.company.lesson10.hw10.translator;

public interface TranslateService {

    void addAndSaveDictionary();

    void loadAndSaveTranslateText();

    String translate(String text);

    void printDictionary();
}
