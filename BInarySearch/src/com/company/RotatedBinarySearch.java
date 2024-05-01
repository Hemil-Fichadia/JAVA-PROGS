package com.company;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        /*int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};*/
        int[] arr = {5, 6, 7, 0, 1, 2, 3, 4};
//        System.out.println(findPivot(arr));
        int target = 6;
        int ans = search(arr, target);
        System.out.println(ans);
    }

    static int search(int[] arr, int target){
        int pivot = findPivot(arr);

        //If you didn't find pivot then the array is not rotated and do a normal binary search
        /* That means the array is rotated array.length times so the highest element gets to its original
           ending position and that means normal ascending array. so only binary search will get the answer. */
        if(pivot == -1){
            return binarysearch(arr, target, 0 , arr.length-1);
        }
        //If pivot is found, you have found 2 ascending sorted arrays
        if(arr[pivot] == target){
            return pivot;
        }
        if(target > arr[0]){
            return binarysearch(arr, target, 1, pivot - 1);
        }
        //else
        return binarysearch(arr, target, pivot + 1, arr.length - 1);
    }

    /* This will not work for the duplicate values and any of the conditions will not be able to cover up the
       case of duplication */
    static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length-1;

        while(start <= end){

            int mid = start + (end - start) / 2;

            //4 cases over here
            //{5, 6, 7, 0, 1, 2, 3, 4}
            //{4, 5, 6, 7, 0, 1, 2, 3}
            //{3, 4, 5, 6, 7, 0, 1, 2}
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

    static int binarysearch(int[] arr, int target, int start, int end){

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
