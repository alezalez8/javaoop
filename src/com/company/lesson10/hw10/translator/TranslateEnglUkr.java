package com.company.lesson10.hw10.translator;

import java.io.*;
import java.util.*;

public class TranslateEnglUkr implements TranslateService {
    private Map<String, String> wordMap = new HashMap<>();
    private Properties properties = new Properties();
    private File dictionary = new File("C:\\Users\\Администратор\\Desktop\\dict\\diction.dic");
    private File inputFile = new File("C:\\Users\\Администратор\\Desktop\\dict\\English.in");
    private File outputFile = new File("C:\\Users\\Администратор\\Desktop\\dict\\Ukrainian.out");

    public TranslateEnglUkr() {
        checkPresentDictionary();
    }

    {
        wordMap.put("glass", "скло");
        wordMap.put("area", "площа");
        wordMap.put("case", "випадок");
        wordMap.put("country", "країна");
        wordMap.put("family", "сім'я");
        wordMap.put("day", "день");
        wordMap.put("money", "грошi");
        wordMap.put("people", "люди");
        wordMap.put("point", "точка");
        wordMap.put("story", "історія");
        wordMap.put("student", "студент");
        wordMap.put("want", "хочу");
        wordMap.put("go", "iди");
        wordMap.put("love", "кохати");
        wordMap.put("live", "жити");
        wordMap.put("take", "брати");
        wordMap.put("get", "отримати");
        wordMap.put("load", "навантаження");
        wordMap.put("see", "побачити");


    }


    private final void checkPresentDictionary() {
        if (!dictionary.exists()) {
            try {
                this.dictionary.createNewFile();
                saveDict();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public int translateMode() {
        int m;

        return 0;
    }


    private void addWord() {
        String anglWord;
        String ukrlWord;
        loadDict();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Редагування словника");
        System.out.println("Введіть слово англійською і натисніть Enter");
        for (; (!(anglWord = scanner.nextLine()).equals("n")); ) {
            if (!isWordPresent(anglWord)) {
                System.out.println("Введіть слово українською і натисніть Enter");
                ukrlWord = scanner.nextLine();
                wordMap.put(anglWord, ukrlWord);
            }

            System.out.println("для виходу натисніть n , для продовження натисніть будь-яку клавішу");
            if (scanner.nextLine().equals("n")) {
                return;
            }
            System.out.println("Введіть слово англійською і натисніть Enter");
        }
        scanner.close();
    }

    @Override
    public void saveDict() {
        for (Map.Entry<String, String> set : wordMap.entrySet()
        ) {
            properties.put(set.getKey(), set.getValue());
            try (OutputStream stream = new FileOutputStream(dictionary)) {

                properties.store(stream, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void loadDict() {
        Properties properties = new Properties();
        try (InputStream stream = new FileInputStream(dictionary)) {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String key : properties.stringPropertyNames()) {
            wordMap.put(key, properties.get(key).toString());
        }

    }

    @Override
    public void editAndSaveDictionary() {
        loadDict();
        addWord();
        saveDict();
        System.out.println("Слово(а) збережено в словнику");
    }


    @Override
    public void translate() {
        loadDict();
        List<String> textArray = new ArrayList<>();
        try (FileReader reader = new FileReader(inputFile);
             FileWriter writer = new FileWriter(outputFile)) {

            for (; reader.ready(); ) {

            }


        } catch (IOException e) {
            e.getMessage();
        }
    }


    private boolean isWordPresent(String word) {
        for (Map.Entry<String, String> map : wordMap.entrySet()) {
            if (map.getKey().equals(word)) {
                System.out.println("Таке слово вже є у словнику");
                return true;
            }

        }
        return false;
    }

    public void printDictionary() {
        loadDict();
        System.out.println(wordMap);
        System.out.println("Розмір словника " + wordMap.size() + " слов");
    }

}
