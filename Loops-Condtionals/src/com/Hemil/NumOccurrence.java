package com.Hemil;

import java.util.Scanner;

public class NumOccurrence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number: ");
        int num = input.nextInt();

        System.out.print("Enter number to count occurrence: ");
        int count = input.nextInt();

        int numCount = 0;
        while(num > 0)
        {
            int rem = num % 10;
            if(rem == count)
            {
                numCount++;
            }
            num = num / 10;
        }

        System.out.println("Occurrence of " + count + " in number you entered = " + numCount);


    }
}
