package com.company.lesson6.hw6;

import java.io.*;

public class MultiCopyFiles {
    public static void main(String[] args) {

        File inputFile = new File("C\\tempOne");
        File outputFile = new File("C\\tempTwo");

        File[] listOfFiles = inputFile.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if(listOfFiles[i].isFile()){
                Thread thread = new Thread(new copyFileThread(new File(listOfFiles[i].getName()), outputFile));
                thread.start();
            }
        }


    }


}

class copyFileThread implements Runnable {
    private File inputFile;
    private File outputFile;

    public copyFileThread(File inputFile, File outputFile ) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    private  void fileCopyService() throws IOException {
        long sizeFile = 0;
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inputFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outputFile))) {
            sizeFile = bis.transferTo(bos);
            System.out.println("Скопирован файл " + inputFile.getName() + ", размер файла " + sizeFile);
        }
    }

    @Override
    public void run() {
        try {
            fileCopyService();
        } catch (IOException e) {
            System.out.println("Ошибка копирования файла.  " + e.getMessage());
        }
    }
}
