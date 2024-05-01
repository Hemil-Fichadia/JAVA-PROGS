package com.Hemil;

public class Swap {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        //Swap numbers code
        /*int temp = a;
        a = b;
        b = temp;*/

        swap(a, b);
        //Here it will not swap the numbers
        System.out.println(a+" "+b);

        String name = "Hemil Fichadia";
        changeName(name);
        System.out.println(name);


    }

    static void changeName(String name) {
        name = "Harshal Trivedi"; // creating a new object

    }

    static void swap(int num1, int num2) {
        int temp = num1;
        num1 = num2;
        num2 = temp;
        //This change will only be valid for this function
        /* for the primitive data types like int, char, long, short, boolean etc.., the copy
           of the value of the reference variable is passed but for the non-primitive
           data types like arrays and String the value itself is passed as object so
           any change is object is made by the reference variable of the function is even
           reflected outside the function.
        */
    }
}
