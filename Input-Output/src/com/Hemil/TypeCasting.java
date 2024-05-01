package com.Hemil;

import java.util.Scanner;

public class TypeCasting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        /* float num1 = input.nextFloat();
        System.out.println(num1); */

        //Type casting
        /* int num2 = (int)(56.67f);
        System.out.println(num2); */


        /* 1 byte = 8-bits so maximum possible number is 256 and here the greater value is
        assigned as 257 so it exceeds the limit of 256 so here java does 257 % 256  */
        /*int a = 257;
        byte b = (byte)(a); //257 % 256 remainder is 1
        System.out.println(b);*/

        //Automatic type promotion in expressions
        /* Here, when 40 and 50 are multiplied, it already exceeds the limit of byte
         as the result of it is 2000 so java temporarily promotes byte to integer
         while evaluating the expressions. So the sub expression a*b is performed integer
         so that the value can be stored for the further evaluation
         */
        /*byte b = 50;
        byte c = 100;
        byte a = 40;
        int d = a * b / c;
        System.out.println(d);*/


        /* this will give an error as integer cannot be multiplied to byte

         */
//        byte b = 50;
//        b = b * 2;

        //Automatic type conversion to ASCII value
        /*int number = 'a';
        System.out.println(number);

        int number1 = 'A';
        System.out.println(number1);*/

        //java follows unicode principles
        /* System.out.println("नमस्ते");
        System.out.println("નમસ્તે");

         */

        //The automatic promotion is carried by the largest data type in the expression
        //Here the integer is converted to double
        //System.out.println(3 * 4.56734);

        byte b = 42;
        char c = 'a';
        short s = 1024;
        int i = 50000;
        float f = 5.67f;
        double d = 0.1234;
        //Here the type promotion is carried as
        // float * byte = float, integer / char = integer, double * short = double
        /* float + integer - double = double so the whole expression is converted to the
           biggest data type amongst them
         */
        double result = (f *  b) + (i / c) - (d * s);
        System.out.println((f *  b) +" "+  (i / c) +" "+ (d * s));
        System.out.println(result);


    }
}
