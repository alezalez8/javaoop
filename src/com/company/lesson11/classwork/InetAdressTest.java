package com.company.lesson11.classwork;

import java.net.*;

public class InetAdressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);
        address = InetAddress.getByName("www.google.com");
        System.out.println(address);
        InetAddress sw[] = InetAddress.getAllByName("bbc.co.uk");
        for (int i = 0; i < sw.length; i++) {
            System.out.println(sw[i]);
        }
    }
}
