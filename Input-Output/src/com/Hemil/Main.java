package com.Hemil;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World");

        //Taking input using scanner class
        Scanner input = new Scanner(System.in);
        //The nextInt takes only integer input
        System.out.println(input.nextInt());
        //nextLine takes the string input
        System.out.println(input.nextLine());
    }
}
