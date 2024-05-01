package com.Hemil;

import java.util.Scanner;

public class Sum {

    public static void main(String[] args) {
	// write your code here
        int ans = SumArgRet(20, 30);
        System.out.println("sumargret = "+ ans);

    }

    /* method syntax

        return_type name(){

          //body
          return statement
        }
     */

    //Method with no return type
    static void SumNoRet(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        int num1 = input.nextInt();
        System.out.print("Enter number 2: ");
        int num2 = input.nextInt();
        int sum = num1 + num2;
        System.out.println("The sum = "+sum);

    }

    //method with return type
    static int SumRet(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        int num1 = input.nextInt();
        System.out.print("Enter number 2: ");
        int num2 = input.nextInt();
        int sum = num1 + num2;
        return sum;

    }

    //method with return type and argument
    static int SumArgRet(int a, int b){

        int sum = a + b;
        return sum;

    }

}
