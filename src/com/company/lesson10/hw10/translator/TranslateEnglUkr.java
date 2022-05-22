package com.company.lesson10.hw10.translator;

import java.io.*;
import java.util.*;

public class TranslateEnglUkr implements TranslateService {
    private Map<String, String> wordMap = new HashMap<>();
    private Properties properties = new Properties();
    private File dictionary = new File("./src/diction.dic");
    private File inputFile = new File("./src/English.in");
    private File outputFile = new File("./src/Ukrainian.out");




    public TranslateEnglUkr() {
        checkPresentDictionary();
    }

    {
        wordMap.put("glass", "скло");
        wordMap.put(".", ".");
        wordMap.put("i", "я");
        wordMap.put("glad", "радий");
        wordMap.put("you", "тебе");
        wordMap.put("area", "площа");
        wordMap.put("case", "випадок");
        wordMap.put("country", "країна");
        wordMap.put("family", "сім'я");
        wordMap.put("day", "день");
        wordMap.put("money", "грошi");
        wordMap.put("people", "люди");
        wordMap.put("home", "до дому");
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


    private void addWord() {
        String anglWord;
        String ukrlWord;
        loadDict();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Додавання слов до  словника");
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
    public void addAndSaveDictionary() {
        loadDict();
        addWord();
        saveDict();
        System.out.println("Зараз " + wordMap.size() + " слов(а) у словнику");
    }


    @Override
    public void loadAndSaveTranslateText() {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String result = "";
            String temp = "";
            for (; ; ) {
                temp = reader.readLine();
                if (temp == null) {
                    break;
                }
                result += temp.toLowerCase() + " ";
            }
            writer.write(translate(result));
        } catch (IOException e) {
            e.getMessage();
        }

    }

    @Override
    public String translate(String text) {
        loadDict();
        String temp;
        String translateText = "";
        text = text.replace('.', ' ');
        List<String> textArray = List.of(text.split(" "));
        for (String word : textArray
        ) {
            temp = wordMap.get(word);
            if (temp == null) {
                temp = " ";
            }
            translateText += temp + " ";
        }
        System.out.println(translateText);
        return translateText;
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
        System.out.println("Розмір словника " + wordMap.size() + " слов");
    }

}
