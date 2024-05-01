package com.company;

public class SearchInMountainArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 3, 1};
        int target = 5;
        int ans = search(arr, target);
        System.out.println(ans);
    }

    static int search(int[] arr, int target ){

        int peak = peakIndexInMountain(arr);

        int firstTry = orderAgnosticBS(arr, target, 0, peak);

        if(firstTry != -1){
            return firstTry;
        }
        //Try to search in second half
        else{
            return orderAgnosticBS(arr, target, peak+1, arr.length-1);
        }
    }

    static int peakIndexInMountain(int[] arr){
        int start = 0;
        int end = arr.length-1;

        while(start < end){
            //Find the middle number
            int mid = start + (end - start) / 2;
            if(arr[mid] > arr[mid+1]){
                //This is the decreasing part of the array
                //This may be the possible ans, but look at the left
                //This why end != mid - 1
                end = mid;
            }
            else{
                //This is the ascending part of the array
                start = mid + 1; //because we know that the mid + 1 number is greater than the mid
            }
            //In the end, start == end and pointing to the greatest number because of the above 2 checks
        }
        return start;
    }

    static int orderAgnosticBS(int[] arr, int target, int start, int end){
         /*This code is focused on the array which is sorted but the order of sorting is unknown,
         weather it is ascending or descending*/

        while(start <= end){
            // find the middle index
            //here addition of start and end can generate a number possible out of range of integer
            int mid = start + (end - start) / 2;

            //it is ascending
            if(arr[start] < arr[end]){

                if(arr[mid] == target){
                    return mid;
                }

                if(target < arr[mid]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }

            }
            //it is descending
            else{
                if(arr[mid] == target){
                    return mid;
                }
                if(target > arr[mid]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
