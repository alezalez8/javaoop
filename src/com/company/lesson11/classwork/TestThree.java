package com.company.lesson11.classwork;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class TestThree {
    public static void main(String[] args) {
      String hosting = "https://www.google.com.ua";
      // String hosting = "http://www.googl.com.ua";
       // String hosting = "https://www.uknown.com/";


            try {
                URL url = new URL(hosting);
                URLConnection urlConnection = url.openConnection();
                System.out.println(url.getHost());
                if (urlConnection.getContentLengthLong() == -1) {
                    System.out.println("Site is not valid");
                  //  System.out.println(urlConnection.getHeaderField(0));
                    System.out.println("====================");
                    String hoss = urlConnection.getHeaderField(0);
                    String[] afga = hoss.split(" ");
                    System.out.println(afga[1]);

                    //System.out.println(urlConnection.getHeaderFields());
                   // System.out.println(urlConnection.getContent());
                } else {
                    System.out.println("Site is valid");
                }


            } catch (IOException   e) {
                e.printStackTrace();
            }

    }
}
