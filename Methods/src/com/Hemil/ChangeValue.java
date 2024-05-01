package com.Hemil;

import java.util.Arrays;

public class ChangeValue {
    public static void main(String[] args) {
        /*In java there is no pass by reference as there are no pointers in java
          there is pass by value so the value of the reference variable is passed
        */
        //create an array
        int[] arr = {1, 2, 3, 45, 6};
        change(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void change(int[] nums) {
        /* if the object is changed via this reference variable the same object will
           be changed.
        */
        nums[0] = 99;
    }
}
