package com.company;

import java.util.Arrays;

public class FindDuplicateNumber {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 2};
        int ans = findDuplicateNumber(arr);

        if(ans == -1){
            System.out.println("No duplicate found!");
        }
        else{
            System.out.println(ans);
        }

    }

    static int findDuplicateNumber(int[] arr){

        int i = 0;

        while(i < arr.length){

            if(arr[i] != i + 1){

                int correct = arr[i] - 1;

                if(arr[i] != arr[correct]){
                    swap(arr, i, correct);
                }
                else{
                    System.out.println(Arrays.toString(arr));
                    return arr[i];
                }

            }
            else{
                i++;
            }

        }
        return -1;
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
