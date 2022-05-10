package com.company.lesson7.classwork;

public class PrinterTask implements Runnable {
    private String text;
    private Printer printer;

    public PrinterTask(String text, Printer printer) {
        super();
        this.text = text;
        this.printer = printer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            printer.printText(text);
        }
    }
}
