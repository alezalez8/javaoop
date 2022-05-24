package com.company.lesson11.classwork;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        String spec = "https://rozetka.com.ua/";
        try{
            URL url=new URL("https://www.google.ru/?gws_rd=ssl");
            HttpURLConnection urlc=(HttpURLConnection) url.openConnection();
            System.out.println("Метод запроса на сервер "+urlc.getRequestMethod());
            System.out.println("Тип ответа "+urlc.getResponseMessage());
            Map<String,List<String>> hm=urlc.getHeaderFields();
            System.out.println("========================================");
            for (Map.Entry<String, List<String> > temp: hm.entrySet()
                 ) {
                System.out.println(temp.getKey() + " :  =>  " + temp.getValue());
            }
            System.out.println("========================================");

            Set<String> hdrf=hm.keySet();
            for(String k:hdrf){
                System.out.println("Key = "+k+" : "+"Value = "+hm.get(k));
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
/*
        try{
            int c;
            URL url=new URL("https://www.google.ru/?gws_rd=ssl");
            URLConnection urlc=url.openConnection();
            System.out.println("getDate()   "+urlc.getDate());
            System.out.println("getContentType()   "+urlc.getContentType());
            long l=urlc.getContentLengthLong();
            System.out.println("getContentLengthLong()  " + l);
            if(l!=0){
                System.out.println();
                InputStream ins=urlc.getInputStream();
                for(;(c=ins.read())!=-1;){
                    System.out.print((char)c);
                }
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
*/

        /*try{
            URL url=new URL(spec);
            System.out.println(url.getProtocol());
            System.out.println(url.getHost());
            System.out.println(url.getPort());
            System.out.println(url.getFile());
            System.out.println(url.getUserInfo());
        }
        catch(MalformedURLException e){
            System.out.println(e.toString());
        }*/




/*
        try {
            String htmlText = NetworkService.getTextFromURL(spec, "UTF-8");
            System.out.println(htmlText);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
*/
        // String spec = "https://content1.rozetka.com.ua/goods/images/big/263977740.jpg";
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

/*
        try {
            Map<String, List<String>> headers = NetworkService.getHeadersFromURL(spec);
            for (String k : headers.keySet()) {
                System.out.println(k + " => " + headers.get(k));
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
*/

    }
}
