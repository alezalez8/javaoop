package com.company.lesson5.hw5;

import java.io.File;
import java.io.IOException;

public class Starter {

    public static void main(String[] args) throws IOException {

        File source = new File("C:\\Users\\Администратор\\Desktop\\A");
        File target = new File("C:\\Users\\Администратор\\Desktop\\M");
        String extens = "pdf";

        CopeFileService fileService = new CopeFileService(source, target, extens);
        fileService.copyDefiniteFile();

    }
}
