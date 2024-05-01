package com.company;

public class DuplicateRBS {
    public static void main(String[] args) {
        int[] arr = {4, 4, 6, 7, 7, 1, 4};
//        System.out.println(findPivot(arr));
        int target = 7;
        int ans = search(arr, target);
        System.out.println(ans);
    }

    static int search(int[] arr, int target){
        int pivot = findPivotWithDuplicates(arr);

        //If you didn't find pivot then the array is not rotated and do a normal binary search
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
        return binarysearch(arr, target, pivot + 1, arr.length - 1);
    }

    static int findPivotWithDuplicates(int[] arr){
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

            //If elements at middle, start and end are equal then just check for the duplicates
            if(arr[mid] == arr[start] && arr[mid] == arr[end]){
                //If the duplicates are not the pivots then skip the duplicates
                //Skip the duplicates
                //NOTE: What if these elements at start and end were the pivots
                //check if the start is the pivot
                if(arr[start] > arr[start + 1]){
                    return start;
                }
                start++;

                if(arr[end] > arr[end - 1]){
                    return end;
                }
                end--;
            }
            else if(arr[mid] > arr[start] || (arr[mid] == arr[start] && arr[mid] > arr[end])){
                start = mid + 1;
            }
            else{
                end = mid - 1;
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
