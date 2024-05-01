package com.company;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int [] arr = {3, 1, 5, 4, 2};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr) {
        /* As the name suggests, the element is selected and placed at its correct index by swapping the element */
        /* Here, the range is started from 0 */
        for (int i = 0; i < arr.length; i++) {
            //Find the max item in the remaining array and swap  with correct index
            int last = arr.length - 1 - i;
            int IndexOfMaxNumber = getMaxIndex(arr, 0, last);

            swap(arr, IndexOfMaxNumber, last);
        }
    }

    static int getMaxIndex(int[] arr, int start, int end) {
        int max = start;
        for (int i = start; i <= end; i++) {
            if(arr[i] > arr[max]){
                max = i;
            }
        }
        return max;
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}