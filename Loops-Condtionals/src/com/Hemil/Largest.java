package com.Hemil;

import java.util.Scanner;

public class Largest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int a = input.nextInt();
        System.out.print("Enter a number: ");
        int b = input.nextInt();
        System.out.print("Enter a number: ");
        int c = input.nextInt();

        //Q: Find the largest amongst 3 numbers
//        int max = a;
//        if(b > max)
//        {
//            max = b;
//        }
//        if(c > max)
//        {
//            max = c;
//        }

        int max = Math.max(c, Math.max(a,b));
        System.out.println("Largest number: "+ max);

    }
}
