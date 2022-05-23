package com.company.lesson11.classwork;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class NetworkService {
    public static String getTextFromURL(String spec, String code) throws IOException {
        URL url = new URL(spec);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        String result = "";
        try (var br = new BufferedReader(new InputStreamReader(connection.getInputStream(), code))) {
            String temp = "";
            for (; ; ) {
                temp = br.readLine();
                if (temp == null) {
                    break;
                }
                result += temp + System.lineSeparator();
            }
        }

        return result;
    }
    public static void getFileFromURL(String spec, File folder) throws IOException {
        URL url = new URL(spec);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        int n = spec.lastIndexOf("/");
        String fileName = spec.substring(n + 1);
        File file = new File(folder, fileName);
        try (InputStream is = connection.getInputStream(); OutputStream os = new FileOutputStream(file)) {
            long size = is.transferTo(os);
            System.out.println(size + " byte copy");
        }
    }

    public static Map<String, List<String>> getHeadersFromURL(String spec) throws IOException {
        URL url = new URL(spec);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        return connection.getHeaderFields();
    }



}
