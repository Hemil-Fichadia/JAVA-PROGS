package com.Hemil;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int result = 0;
        char choice;

        System.out.println("This is calculator!");
        System.out.print("Enter y or Y to continue: ");
        choice = input.next().trim().charAt(0);

        while(choice == 'y' || choice == 'Y')
        {
            System.out.print("Enter operator: ");
            char op = input.next().trim().charAt(0);

            if (op == '+' || op == '-' ||op == '*' ||op == '/' ||op == '%')
            {
                System.out.print("Enter a number: ");
                int num1 = input.nextInt();

                System.out.print("Enter a number: ");
                int num2 = input.nextInt();

                if(op == '+')
                {
                    result = num1 + num2;
                }

                else if(op == '-')
                {
                    result = num1 - num2;
                }

                else if(op == '*')
                {
                    result = num1 * num2;
                }

                else if(op == '/')
                {
                    if(num2 != 0)
                    {
                        result = num1 / num2;
                    }
                    else
                    {
                        System.out.println("Cannot divide by zero");
                    }
                }

                else if(op == '%')
                {
                    result = num1 % num2;
                }

                System.out.println("result: "+ result);
                System.out.print("Enter y or Y to continue: ");
                choice = input.next().trim().charAt(0);
            }

            else
            {
                System.out.println("Invalid operation");
            }

        }

    }
}
