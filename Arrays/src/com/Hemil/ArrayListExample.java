package com.Hemil;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(10);
        Scanner input = new Scanner(System.in);

        /*list.add(4);
        list.add(34);
        list.add(57);
        list.add(78);
        list.add(136);

        System.out.println(list.contains(57));
        System.out.println(list);

        list.set(0, 99);
        list.remove(2);

        System.out.println(list);*/

        //input
        for (int i = 0; i < 5; i++) {
            list.add(input.nextInt());
        }

        //get item at any index
        for (int i = 0; i < 5; i++) {
            System.out.println(list.get(i));// pass index here, as list[index] will not work here
        }

        System.out.println(list);



    }
}
