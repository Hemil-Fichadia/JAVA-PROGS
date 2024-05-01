package com.Hemil;

import java.util.Scanner;

public class CaseCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a word: ");
        char ch = input.next().trim().charAt(0);
        System.out.println(ch);
        //And operator
        if(ch >= 'a' && ch <= 'z')
        {
            System.out.println("Lower Case");
        }
        else if(ch >= 'A' && ch <= 'Z')
        {
            System.out.println("Upper Case");
        }
        else
        {
            System.out.println("Special Character");
        }

        //OR operator
        Scanner input1 = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num1 = input1.nextInt();

        if (num1 >= 10 || num1 <= 0)
        {
            System.out.println("Number is in range");
        }

    }
}
