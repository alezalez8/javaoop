package com.company.lesson4.hw4;

public class SearchChainNumber {
    public static void main(String[] args) {
        int exampleOne = 11111111;
        int exampleTwo = 12121212;
        int exampleThree = 123123123;
        int exampleFour = 121121121;
        int exampleFive = 12341234;


        System.out.println(exampleOne + " => " + searchNumber(exampleOne));
        System.out.println(exampleTwo + " => " + searchNumber(exampleTwo));
        System.out.println(exampleThree + " => " + searchNumber(exampleThree));
        System.out.println(exampleFour + " => " + searchNumber(exampleFour));
        System.out.println(exampleFive + " => " + searchNumber(exampleFive));

    }

    public static int searchNumber(int number) {

        String myNumber = String.valueOf(number);
        String searchNumb = "";
        String temp = "";
        int lengthOfNumber;
        boolean isFind = false;
        for (int i = 1; i <= myNumber.length() / 2; i++) {
            if (isFind) {
                break;
            }

            searchNumb = myNumber.substring(0, i);
            lengthOfNumber = searchNumb.length();

            for (int j = i; j < myNumber.length(); j += lengthOfNumber) {
                temp = myNumber.substring(j, j + lengthOfNumber);
                if (searchNumb.equals(temp)) {
                    isFind = true;
                } else {
                    isFind = false;
                    break;
                }
            }
        }

        return Integer.parseInt(searchNumb);
    }
}



