package com.Hemil;

import java.util.Arrays;
import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Arrays of primitives
        int[] arr = new int[5];
        arr[0] = 23;
        arr[1] = 233;
        arr[2] = 323;
        arr[3] = 45;
        arr[4] = 54;
        // [23, 233, 323, 45, 54]
        System.out.println(arr[3]);

        //input using for loops
        /*for (int i = 0; i < arr.length; i++) {
            arr[i] = input.nextInt();
        }
        System.out.println(Arrays.toString(arr));*/

        /*for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

        for (int nums : arr) {
            System.out.print(nums + " "); // here nums represents elements of the array
        }*/

        //System.out.println(arr[5]); //index out of bound error

        //Array of objects
        String[] str = new String[4];
        for (int i = 0; i < str.length; i++) {
            str[i] = input.next();
        }
        System.out.println(Arrays.toString(str));

        str[1] = "Hemil";
        System.out.println(Arrays.toString(str));

    }
}
