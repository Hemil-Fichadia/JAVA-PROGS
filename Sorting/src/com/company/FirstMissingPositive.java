package com.company;

import java.util.Arrays;

public class FirstMissingPositive {
    /* Here we have to find the first missing positive integer and the algorithm used is cyclic sort as
    * the numbers are form [1 - n] and it is asked to find first missing positive integer starting from
    * 1, so we have to ignore negative numbers. */
    public static void main(String[] args) {
        /*In this example, there are no negative numbers so the search is to begun with the first missing
        * positive integer.*/
        /* So for this array of 8, 7, 10, 9  , it doesn't really sort the array it just checks which is the
        * first positive integer is missing as we don't really care about sorting the array we only need
        * the sequential approach that is only possible with cyclic sort and even if the array is not sorted,
        * we can get our answer. */
        /*int[] arr = {8, 10, 7, 9};*/

        /*In this case it partially sorts the array as it ignores the negative by placing other elements
        * at their respective position. */
        int[] arr = {3, -1, 4, 1};
        System.out.println(missingNumber(arr));
    }


    static int missingNumber(int[] arr){
        int i = 0;
        while(i < arr.length){
            int correct = arr[i] - 1;
            /* As we have to ignore the negative numbers and the array index is also always positive so
            * the negative numbers are ignored. */
            if(arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[correct]){
                swap(arr,i,correct);
            }
            else{
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
        for (int index = 0; index < arr.length; index++) {

            if(arr[index] != index + 1){
                return index + 1 ;
            }
        }
        //If all the numbers as in order the smallest missing positive number would be n + 1
        return arr.length + 1;
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}

