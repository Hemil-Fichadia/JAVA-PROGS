package com.company;

public class PrettyPrinting {
    public static void main(String[] args) {
        float num = 453.1234f;
        System.out.printf("Formatted number is %.2f", num);
        System.out.println();

        /*Here it also rounds off the number*/
        float num1 = 453.1274f;
        System.out.printf("Formatted and rounded off number is %.2f", num1);
        System.out.println();

        System.out.printf("Pie: %.3f",Math.PI);
        System.out.println();

        System.out.printf("Hello my name is %s and I am %s", "Hemil", "Cool");
        System.out.println();


    }
}
