package com.Hemil;

import java.util.Scanner;

public class Conditionals {

    public static void main(String[] args) {

        /* Syntax of if statement

           if (boolean expressions true or false)
           {
                business logic
           }
           else
           {
                business logic
           }

         */

        Scanner input  = new Scanner(System.in);
        System.out.print("Enter salary: ");
        int salary = input.nextInt();
//        if (salary > 10000)
//        {
//           salary = salary + 1000;
//        }
//        else
//        {
//            salary = salary + 2000;
//        }
//        System.out.println(salary);

        if (salary < 10000)
        {
            salary += 5000;
        }
        else if (salary > 20000)
        {
            salary += 1000;
        }
        else
        {
            salary += 3000;
        }
        System.out.println("Your incremented salary: "+salary);

    }
}
