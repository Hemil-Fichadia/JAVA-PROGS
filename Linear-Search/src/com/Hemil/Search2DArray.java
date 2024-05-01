package com.Hemil;

import java.util.Arrays;

public class Search2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                {23, 4, 65},
                {2, 34, 54, 6},
                {3, 44, 78, 9},
                {12, 90}
        };

        int target = 12;
        int[] ans = search(arr, target);
        System.out.println(Arrays.toString(ans));
        System.out.println(maxval(arr));
    }

    static int[] search(int[][] arr, int target) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if(arr[row][col] == target){
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{-1, -1};
    }

    static int maxval(int[][] arr) {
        int max = arr[0][0];
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt > max) {
                    max = anInt;
                }
            }
        }
        return max;
    }
}
