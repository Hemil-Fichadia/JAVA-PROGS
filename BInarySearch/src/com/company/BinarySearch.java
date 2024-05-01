package com.company;

public class BinarySearch {

    public static void main(String[] args) {
        // write your code here
        int arr[] = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};
        int target = 22;
        int ans  = binarysearch(arr, target);
        System.out.println(ans);
    }

    //return the index
    //if none are matched then return -1
    static int binarysearch(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            // find the middle index
            //here addition of start and end can generate a number possible out of range of integer
            int mid = start + (end - start) / 2;

            if(target < arr[mid]){
                end = mid - 1;
            }
            else if(target > arr[mid]){
                start = mid + 1;
            }
            else{
                //Answer found
                return mid;
            }
        }
        return -1;
    }
}