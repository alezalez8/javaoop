package com.company.lesson11.classwork;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
/*
        try (Socket socket = new Socket("127.0.0.1", 20000)) {
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.println("GET / HTTP/1.1");
            pw.println("Host:google.com.ua");
            pw.println("");
            pw.flush();
            InputStream s = socket.getInputStream();
            int r;
            for (; (r = s.read()) != -1; ) {
                System.out.print((char) r);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
*/
        try {
            ServerSocket s = new ServerSocket(20000);
            Socket incoming = s.accept();
            try {
                Scanner sc = new Scanner(incoming.getInputStream());
                PrintWriter out = new PrintWriter(incoming.getOutputStream(), true);
                boolean exit = true;
                for (; exit; ) {
                    String line = sc.nextLine();
                    out.println("Ответ сервера " + line);
                    if (line.compareTo("exit") == 0) exit = false;
                }
            } finally {
                incoming.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("END");

/*
        try (Socket socket = new Socket("127.0.0.1", 200000)) {
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.println("GET / HTTP/1.1");
            pw.println("Host:google.com.ua");
            pw.println("");
            pw.flush();
            InputStream s = socket.getInputStream();
            int r;
            for (; (r = s.read()) != -1; ) {
                System.out.print((char) r);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
*/

    }
}
