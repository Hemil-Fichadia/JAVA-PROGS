package com.Hemil;

import java.util.Arrays;

public class VarArgs {
    public static void main(String[] args) {
        fun(1, 2, 3, 45, 56, 9);
    }

    /* Variable length arguments */
    static void fun(int ...v)
    {
        System.out.println(Arrays.toString(v));
    }
}
