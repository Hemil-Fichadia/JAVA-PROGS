package com.Hemil;

import java.util.Scanner;

public class NestedSwitch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter employee ID: ");
        int empId = input.nextInt();

        /* for multi-line comment like this use command ctrl+shift+/  */
/*
        switch(empId)
        {
            case 1:
                System.out.println("Hemil Fichadia");
                break;

            case 2:
                System.out.println("Harshal Trivedi");
                break;

            case 3:
                System.out.print("Enter Department: ");
                String department = input.next();
                switch(department)
                {
                    case "IT":
                        System.out.println("IT Department");
                        break;

                    case "DevOps":
                        System.out.println("DevOps Department");
                        break;

                    default:
                        System.out.println("No Department found");
                        break;
                }
                break;

            default:
                System.out.println("Enter valid ID");

        }
*/

        //Better way to write
        switch (empId) {
            case 1 -> System.out.println("Hemil Fichadia");
            case 2 -> System.out.println("Harshal Trivedi");
            case 3 -> {
                System.out.print("Enter Department: ");
                String department = input.next();
                switch (department) {
                    case "IT" -> System.out.println("IT Department");
                    case "DevOps" -> System.out.println("DevOps Department");
                    default -> System.out.println("No Department found");
                }
            }
            default -> System.out.println("Enter valid ID");
        }
    }

}
