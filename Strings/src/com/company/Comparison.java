package com.company;

public class Comparison {
    public static void main(String[] args) {
        String a = "Hemil";
        String b = "Hemil";
        String c = a;
        System.out.println(c == a);

        // == method
        /* If two variables pointing to two different objects even with the same values, == comparator will return
        * false, it will return true if the reference variables pointing to the same object. So it checks the variables
        * are pointing to the same object. */
        System.out.println(a == b);

        String name1 = new String("Hemil");
        String name2 = new String("Hemil");
        /*Here it will not show true as the */
        /*System.out.println(name1 == name2);*/

        System.out.println(name1.equals(name2));
        System.out.println(name1.charAt(0));
    }
}
