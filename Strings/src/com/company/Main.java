package com.company;

public class Main {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 4, 19};
        int num = 10;
        String name = "Hemil Fichadia";
        /*System.out.println(name);*/

        /*String is immutable. it is stored in a string pool in heap memory so if there are two string variables
         with same value as "Hemil" so both will point to the same string object in the string pool so here if
         initially the string was "Hemil" and later on the string was reassigned by "Fichadia" so the object was not
         changed but a new is created of String "Fichadia".
         */
        /* The strings are stored in string pool in heap memory as it is faster than normal heap storage as it
        * requires complex memory management so pool gives additional functionality to work faster. */
        String a = "Hemil";
        System.out.println(a);
        a = "Fichadia";
        System.out.println(a);
    }
}
