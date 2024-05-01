package com.Hemil;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter number till you want to print fibonacci series: ");
        int n = input.nextInt();
        int a = 0;
        int b = 1;
        int count = 2;

        System.out.print(" "+ 0);
        System.out.print(" "+ 1);
        while(count <= n)
        {
            int temp = a + b;
            a = b;
            b = temp;
            System.out.print(" " + temp);
            count++;
        }

    }
}
