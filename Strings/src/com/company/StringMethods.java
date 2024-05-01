package com.company;

import java.util.Arrays;

public class StringMethods {
    public static void main(String[] args) {
        String name = "Hemil Fichadia Hello World";
        /*Normal string is immutable. It creates new object which is actually the modified version of the original
        * String. */
        System.out.println(Arrays.toString(name.toCharArray()));
        System.out.println(name.toLowerCase());
        System.out.println(name.toUpperCase());
        System.out.println("   Hemil".trim());
        System.out.println(Arrays.toString(name.split(" ")));

    }
}
