package com.Hemil;

import java.util.Arrays;
import java.util.Scanner;

public class MultiDimensional {
    public static void main(String[] args) {

          /*1, 2, 3,
          4, 5, 6,
          7, 8, 9*/

        //int[][] arr = new int[3][3];
        //The size of row needs to be specified but the size of column is not needed to be specified
        /*int[][] arr = {
                {1, 2, 3},
                {4, 5},
                {6, 7, 8, 9}
        };*/

        Scanner input = new Scanner(System.in);
        int[][] arr = new int[3][3];
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                arr[row][col] = input.nextInt();
            }
        }

        /*for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(arr[row][col]+" ");
            }
            System.out.println();
        }*/

        /*for (int row = 0; row < arr.length; row++) {
            System.out.println(Arrays.toString(arr[row]));
        }*/

        for(int[] ele: arr)
        {
            System.out.println(Arrays.toString(ele));
        }

    }
}
