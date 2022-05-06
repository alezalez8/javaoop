package com.company.lesson6.hw6;

import java.io.*;

public class MultiCopyFiles {
    public static void main(String[] args) {

        File inputDir = new File("C://tempOne");
        File outputDir = new File("C://tempTwo");

        File[] listOfFiles = inputDir.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if(listOfFiles[i].isFile()){
                File outputFile = new File(outputDir, listOfFiles[i].getName());
                CopyFileThread copyFile = new CopyFileThread(listOfFiles[i], outputFile);
                Thread thread = new Thread(copyFile);
                thread.start();
            }
        }
    }


}

class CopyFileThread implements Runnable {
    private File inputDir;
    private File outputFile;

    public CopyFileThread(File inputDir, File outputFile ) {
        this.inputDir = inputDir;
        this.outputFile = outputFile;
    }

    private  void fileCopyService() throws IOException {
        long sizeFile = 0;
        try (InputStream fis = new FileInputStream(inputDir);
             OutputStream fos = new FileOutputStream(outputFile)) {
            sizeFile = fis.transferTo(fos);
            System.out.println("Скопирован файл " + inputDir.getName() + ", размер файла " + sizeFile);
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
