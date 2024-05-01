package com.company;

import java.util.Arrays;

public class Output {
    public static void main(String[] args) {
        System.out.println(56);
//        Integer num = new Integer(56);
//        System.out.println(num.toString());
        /* Inside the println method it fetches the value and calls the .toString method. */
        System.out.println("Hemil");
        /* In this case it, fetches the value of the data which is object and checks the type of it and calls
        of the .toString to it and prints the string value of it and if the value is null then it doesn't call
         any method like .toString method. */
        /* So here it prints the hash code with some symbols at the beginning. */
        System.out.println(new int[]{2, 3, 4, 5});
        /*So here it prints the whole array with square brackets in string representation. as it is been
        * said to print the array with the toString method of the arrays method.*/
        System.out.println(Arrays.toString(new int[]{2, 3, 4, 5}));

        String name = null;
        System.out.println(name);
    }
}
