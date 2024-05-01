package com.Hemil;

import java.util.Arrays;

public class Overloading {
    public static void main(String[] args) {
        /* int ans = sum(23, 34, 54);
        System.out.println(ans);*/
        demo(23,33,45,55);

    }

    static void demo(int ...v)
    {
        System.out.println(Arrays.toString(v));
    }

    static void demo(String ...v)
    {
        System.out.println(Arrays.toString(v));
    }

    static void fun(int a)
    {
        System.out.println(a);
    }

    static void fun(String name)
    {
        System.out.println(name);
    }

    static int sum(int a, int b)
    {
        return a + b;
    }

    static int sum(int a, int b, int c)
    {
        return a + b - c;
    }
}
