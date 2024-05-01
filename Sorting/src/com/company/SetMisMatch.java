package com.company;

import java.util.Arrays;

public class SetMisMatch {
    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 2};
        /*int[] arr = {1, 2, 3, 4};*/
        int[] ans = setMisMatch(arr);

        if(ans[0] == -1){
            System.out.println("No Duplicate or missing found!");
        }
        else{
            System.out.println(Arrays.toString(ans));
        }
    }

    static int[] setMisMatch(int[] arr){
        int i = 0;
        while(i < arr.length){
            int correct = arr[i] - 1;
            if(arr[i] != arr[correct]){
                swap(arr, i, correct);
            }
            else{
                i++;
            }
        }

        for (int index = 0; index < arr.length; index++) {
            if(arr[index] != index + 1){
                return new int[] {arr[index], index+1};

            }
        }
        return new int[] {-1};
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
