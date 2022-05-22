package com.company.lesson10.hw10.translator;

public interface TranslateService {


    void saveDict();

    void loadDict();

    void addAndSaveDictionary();

    void loadAndSaveTranslateText();

    String translate(String text);

    void printDictionary();
}
