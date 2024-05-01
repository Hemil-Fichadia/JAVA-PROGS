package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicateNumbers {
    //Here we need to find all the numbers that are repeating and a code is also given for all missing numbers too.
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(allDuplicateNumbers(arr));

    }

    static List<Integer> allDuplicateNumbers(int[] arr){
        List<Integer> duplicate = new ArrayList();
        List<Integer> missing = new ArrayList();
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
        System.out.println(Arrays.toString(arr));
        for (int index = 0; index < arr.length; index++) {
            if(arr[index] != index + 1){
                missing.add(index + 1);
                duplicate.add(arr[index]);

            }
        }
        System.out.println("Missing numbers: "+missing);
        return duplicate;
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
