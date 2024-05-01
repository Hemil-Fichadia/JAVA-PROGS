package com.company;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int [] arr = {3, 1, 4, 5, 2};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void cyclicSort(int[] arr){
        //Iteration starts from 0
        int i = 0;
        //Loop breaks when every element are at their correct position according to the precedence
        while(i < arr.length){
            //Element's correct position like, at arr[0]=>5 correct = 5 - 1 = 4th index
            int correct = arr[i] - 1;
            /*Checking whether the current element is at its exact position or not and if the element is not at its
              position, i will be incremented by 1 each time.
             */
            if(arr[i] != arr[correct]){
                /*If the element is not at its correct index than that element is swapped by the element of
                 the respective index.*/
                swap(arr, i, correct);
            }
            else{
                i++;
            }
        }
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
