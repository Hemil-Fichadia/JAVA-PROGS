package com.Hemil;

import java.util.Scanner;

public class NumReverse {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number to reverse it: ");
        int num = input.nextInt();
        int revNum = 0;
        while(num > 0)
        {
            int rem = num % 10;
            revNum = (revNum * 10) + rem;
            num = num / 10;
        }
        System.out.println("Reversed number: "+ revNum);

    }
}
