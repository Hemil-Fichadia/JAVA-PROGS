package com.company;

public class NumberOfRotation {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
//        System.out.println(findPivot(arr));
        int ans = findPivot(arr);
        int NoOfRotations = ans + 1;
        System.out.println(NoOfRotations);
    }


    /* This will not work for the duplicate values and any of the conditions will not be able to cover up the
       case of duplication */
    static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            //4 cases over here
            if(mid < end && arr[mid] > arr[mid + 1]){
                return mid;
            }
            if(mid > start && arr[mid] < arr[mid - 1]){
                return mid;
            }

            if(arr[mid] < arr[start]){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return -1;
    }


}
