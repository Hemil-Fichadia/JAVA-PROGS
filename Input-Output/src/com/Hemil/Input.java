package com.Hemil;

import java.util.Scanner;

public class Input {
    public static void main(String[] args) {

        //Here Scanner class is inside package util
        /* System.in is passed as parameter in Scanner as input is taken from keyboard.
          System has a variable in which has functionality to take input from keyboard */
        Scanner input = new Scanner(System.in);

        //Here println is written as print so input is taken in the same line
        /* System.out.print("Enter Integer data: ");
        int rollno  =  input.nextInt();
        System.out.println("Your roll no is: "+rollno); */

        System.out.print("Enter string data: ");
        String data = input.nextLine();
        System.out.println(data);

        System.out.println("Enter Integer data");
        float num1 = input.nextFloat();
        System.out.println(num1);
    }
}
