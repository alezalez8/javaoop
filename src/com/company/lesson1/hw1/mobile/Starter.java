package com.company.javaoop.lesson1.hw1.mobile;

public class Starter {
    public static void main(String[] args) {
        Network network = new Network();
        Phone phone1 = new Phone("+380501112233");
        Phone phone2 = new Phone("+380502223344");
        Phone phone3 = new Phone("+380503334455");
        Phone phone4 = new Phone("+380504445566");

        phone1.registration(network);
        phone2.registration(network);
        phone3.registration(network);

        // attempt to register phone1 again:
        phone1.registration(network);
        System.out.println("--------------------------------------------------");


        phone1.outgoingCall("+380502223344");
        System.out.println("--------------------------------------------------");
        phone2.outgoingCall("+380503334455");
        System.out.println("--------------------------------------------------");
        phone3.outgoingCall("+380501112233");
        System.out.println("--------------------------------------------------");
        phone1.outgoingCall("+380501112233");
        System.out.println("--------------------------------------------------");
        phone2.outgoingCall("+380504445566");
        System.out.println("--------------------------------------------------");
        phone4.outgoingCall("+380503334455");


    }
}
