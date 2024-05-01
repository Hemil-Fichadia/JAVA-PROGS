package com.company;

import java.util.ArrayList;

public class Operators {
    public static void main(String[] args) {
        /*Here it adds ASCII values of the characters and then performs the addition.*/
        System.out.println('a'+'b');
        System.out.println("a"+"b");
        System.out.println('a' + 3);
        System.out.println((char)('a'+3));

        /*In this case the integer is converted to its rapper class Integer and calls .toString method and this
        * converts to the String */
        /* After few steps this will be converted to "a" + "1" */
        System.out.println("a" + 1);

        System.out.println("Hemil" + new ArrayList<>());
        System.out.println("Hemil" + new Integer(56));

        /*This will throw an error as this whole is an expression and to use the "+" operator the condition is
         that it should atleast contain one string or a primitive data type. */
        /*System.out.println(new Integer(56) + new ArrayList<>());*/

        System.out.println(new Integer(56) +""+ new ArrayList<>());

    }
}
