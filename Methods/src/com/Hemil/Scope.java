package com.Hemil;

public class Scope {
    public static void main(String[] args) {
        //Universal declaration
        int a = 10;
        int b = 20;

        //Block scope
        {
            /* In block scope, universal variables can be accessed and can be modified
               as well.
            */
            /* The variables declared globally, cannot be re-initialized in any block scope  */
            // int a = 30; // XXXX
//            a = 30;  // Reassigned value of ref variable
            System.out.println(a);
            int c = 25;
        }
        System.out.println(a);
        /* The variables declared in a block scope, cannot be accessed outside the block  */
        //System.out.println(c);


        // for loop scope
        for (int i = 0; i < 4; i++) {
            System.out.println(i);
            int num1 = 22 + i;

        }

    }

    static void extra(int marks)
    {
        int num = 54;
        System.out.println(num);
        System.out.println(marks);
    }
}
