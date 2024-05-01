package com.Hemil;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);

//        System.out.print("Enter name of a fruit");
//        String fruit = input.next();
//
//        switch(fruit) {
//            case "Mango":
//                System.out.println("King of fruits!");
//                break;
//
//            case "Apple":
//                System.out.println("A sweet red fruit");
//                break;
//
//            case "Orange":
//                System.out.println("Round fruit");
//                break;
//
//            case "Grapes":
//                System.out.println("Small fruit");
//                break;
//
//            default:
//                System.out.println("Please enter a valid fruit");
//
//        }


        //Enhanced version
//        switch (fruit) {
//            case "Mango" -> System.out.println("King of fruits!");
//            case "Apple" -> System.out.println("A sweet red fruit");
//            case "Orange" -> System.out.println("Round fruit");
//            case "Grapes" -> System.out.println("Small fruit");
//            default -> System.out.println("Please enter a valid fruit");


        System.out.print("Enter a number");
        int day = input.nextInt();

//        switch(day) {
//            case 1:
//                System.out.println("weekday");
//                break;
//
//            case 2:
//                System.out.println("weekday");
//                break;
//
//            case 3:
//                System.out.println("weekday");
//                break;
//
//            case 4:
//                System.out.println("weekday");
//                break;
//
//            case 5:
//                System.out.println("weekday");
//                break;
//
//            case 6:
//                System.out.println("weekend");
//                break;
//
//            case 7:
//                System.out.println("weekend");
//                break;
//


        switch (day) {
            case 1, 2, 3, 4, 5 -> System.out.println("Weekday");
            case 6, 7 -> System.out.println("Weekend");
        }


        }
}
