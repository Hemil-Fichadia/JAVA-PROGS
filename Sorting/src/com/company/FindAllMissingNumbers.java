package com.company;

import java.util.ArrayList;
import java.util.List;
//Leetcode question
public class FindAllMissingNumbers {

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(AllMissingNumbers(arr));
    }

    static List<Integer> AllMissingNumbers(int[] arr){
        List<Integer> ls = new ArrayList();
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
                ls.add(index + 1);
            }
        }
        return ls;
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
