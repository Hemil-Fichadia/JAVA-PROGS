package com.Hemil;

import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {

        /*
               Syntax of for loop
               for(initialization; condition; increment/decrement)
               {
                    Business logic
               }
         */

        // Q: Print numbers 1 to 5
//        for(int num=1; num <=5; num += 1)  //num ++
//        {
//            System.out.println(num);
//        }


//        Scanner input = new Scanner(System.in);
//        System.out.print("Enter number: ");
//        int n = input.nextInt();
//        for (int num = 1; num < n; num++)
//        {
//            System.out.println(num);
//        }

        // while loop syntax
        /*
            while(condition)
            {
                body
            }
         */

//        int num = 1;
//        while(num <= 5)
//        {
//            System.out.println(num);
//            num +=1;
//        }

        //do while loop
        /*
            do{
                body
            } while(condition)
         */

        int num = 1;
        do
        {
            System.out.println(num);
            num++;
        }while (num <= 5);

    }
}
