package com.Hemil;

public class Shadowing {

    static int x = 90; //This will be shadowed at line no 8

    public static void main(String[] args) {

        System.out.println(x);  // 90

        /* This is variable declaration */ int x;

        //System.out.println(x); // this will give an error as variable is yet initialized

        /* The scope begins at the point where the variable is initialized not from the point
           where the variable is declared
        */
        /* This is variable initialization */ x = 40;

        System.out.println(x); //40
        fun(); // 90

    }

    static void fun() {
        System.out.println(x);
    }
}
