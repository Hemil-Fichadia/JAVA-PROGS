package com.company;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr){
        /* A variable named swapped is assigned to set the status of this boolean variable accordingly if the array
        * is already sorted, then the swaps will not occur and if it is not swapped than the loop breaks and
        * then, further checks are prevented and our algorithm would have steps according
        * to the requirement. */
        boolean swapped;
        //Repeat the steps n - 1 times
        /* The first for loop is for number of pass to sort an array like here in every pass, the largest element
        * is set to its highest position like 5, 4, 3, 2, 1 for the first pass, 5 will be shifted to the end of the
        * array and for the second pass, 4 will be at the second last position and so on. So in this process the max
        * no of passes that are required are total no of elements - 1: means length-1 or N-1 so if the array is of
        * size 5 => 5-1 = 4 pass are required and the array will be sorted in this 4 passes because at the end fifth
        * and the smallest number is going to be at in its sorted position. so we only need 4 swaps so N-1 */
        /* So here in this sorting, the first for loop acts as a counter which counts no. of pass and as the pass
        * increases the size for which we are swapping numbers reduces as the ending part of the array will be sorted
        * after every pass so that ending part is discarded with the help of i variable of this for loop as it is
        * taken as limit for the nested for loop. */
        //0 -to- < 5
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            //After every step, the max item will come at the last position
            /* This for loop does the main task. Here in this loop, the number of comparisons are carried out so
            * the range is decided in which the sorting is to be carried out and that is considered as n-i. So the
            * count starts as n-0 as i starts from 0 so the entire array is considered initially as the position of
            * the elements might not be in order so first the largest element is shifted to last position. Now in
            * second pass i = 1 so N-i = n-1 so the array is considered till the range it is not sorted which is
            * the second last index as checking the last element after first pass is not worth of it. In the same way
            * whole array is traversed and gradually the range is minimized and at the loop ends at i = 4 =>
            * n - i = 5 - 4 = 1 so j starts from 1 and ends at 1 and loop is terminated and so the last element is
            * checked as it is going to be in its sorted position. */
            for (int j = 1; j < arr.length - i; j++) {
                //Swap the numbers if the previous is greater than the current element
                if(arr[j] < arr[j-1]){
                    //Swap
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
            }
            /* Here a check is made if the numbers are not swapped for even once on an iteration, it will not change
            * the status false to true means if swap doesn't occur then swapped will remain false and !false = true
            * so loop will break when array is sorted completely and this will even make sure if an array is already
            * sorted, than the program will end. */
            if(!swapped){
                break;
            }
        }
    }
}
