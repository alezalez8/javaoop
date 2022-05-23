package com.company.lesson11.classwork;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
/*
        String spec = "https://rozetka.com.ua/";

        try {
            String htmlText = NetworkService.getTextFromURL(spec, "UTF-8");
            System.out.println(htmlText);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
*/
        String spec = "https://content1.rozetka.com.ua/goods/images/big/263977740.jpg";
       // String spec = "https://rozetka.com.ua/";

/*
        File folder = new File("Temp files");
        folder.mkdirs();

        try {
            NetworkService.getFileFromURL(spec, folder);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
*/

        try {
            Map<String, List<String>> headers = NetworkService.getHeadersFromURL(spec);
            for (String k : headers.keySet()) {
                System.out.println(k + " => " + headers.get(k));
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
