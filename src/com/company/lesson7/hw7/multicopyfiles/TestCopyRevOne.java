package com.company.lesson7.hw7.multicopyfiles;

import java.io.*;

public class TestCopyRevOne {


    public static void main(String[] args) throws IOException {
    //    File fileFrom = new File("C:\\Users\\Администратор\\Desktop\\A\\K\\idea_crack.mp4");
     //   File fileTo = new File("C:\\Users\\Администратор\\Desktop\\A\\L\\idea_crack.mp4");



        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Mmm());
            thread.start();
        }


    }


}

class Mmm implements Runnable {
   private File fileFrom = new File("C:\\Users\\Администратор\\Desktop\\A\\K\\idea_crack.mp4");
   private File fileTo = new File("C:\\Users\\Администратор\\Desktop\\A\\L\\idea_crack.mp4");


    public void somethingDo() throws IOException {


        try (InputStream inputStream = new FileInputStream(fileFrom);
             OutputStream outputStream = new FileOutputStream(fileTo, true)
        ) {

            inputStream.transferTo(outputStream);
            System.out.println("Run " + Thread.currentThread().getId());
        } catch (IOException e) {
            throw e;
        }
    }

    @Override
    public void run() {
        try {
            somethingDo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
