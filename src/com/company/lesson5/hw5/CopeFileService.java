package com.company.lesson5.hw5;

import java.io.*;
import java.util.Scanner;

public class CopeFileService {
    private File source;
    private File target;
    private String extension;

    public CopeFileService() {
    }

    public CopeFileService(File source, File target, String extension) {
        this.source = source;
        this.target = target;
        this.extension = extension;
    }

    public void inputInfoAboutFiles() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к исходной директории");
        source = new File(scanner.nextLine());
        System.out.println("Введите путь к конечной директории");
        target = new File(scanner.nextLine());
        System.out.println("Введите расширение файла");
        extension = scanner.nextLine();

    }


    public void copyDefiniteFile() throws IOException {
     //   inputInfoAboutFiles();
        if (!source.isDirectory()) {
            System.out.println("Путь к исходной директории не является путем к директории");
            return;
        }
        int countOfFiles = 0;
        File[] files = source.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                String[] extensionCurrentFile = files[i].getName().split("\\.");
                if (extension.equals(extensionCurrentFile[1])) {
                    File outputFile = new File(target, files[i].getName());
                    copyFiles(files[i], outputFile);
                    countOfFiles++;
                }
            }
        }

        System.out.println("Всего скопирован(о)  " + countOfFiles + " файла(ов)");
        if (countOfFiles == 0) {
            System.out.println("Файлы с таким расширением отстутствуют в указанной директории");
        }
    }

    private void copyFiles(File file, File outputFile) throws IOException {

        try (InputStream inputStream = new FileInputStream(file);
             OutputStream outputStream = new FileOutputStream(outputFile)) {
            inputStream.transferTo(outputStream);
        }
    }


}
