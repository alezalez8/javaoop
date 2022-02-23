package com.company.javaoop.lesson2.hw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class TextSaver {
    private TextTransformer transformer;
    private File file;

    public TextSaver() {
    }

    public TextSaver(TextTransformer transformer, File file) {
        this.transformer = transformer;
        this.file = file;
    }

    public void saveTextToFile(String text) {
        text = transformer.transform(text);
        if (file == null) {
            System.out.println("File is not selected");
            return;
        }
        if (transformer == null) {
            System.out.println("Method of tranformation is not defined ");
            return;
        }
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.write(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    public TextTransformer getTransformer() {
        return transformer;
    }

    public void setTransformer(TextTransformer transformer) {
        this.transformer = transformer;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
