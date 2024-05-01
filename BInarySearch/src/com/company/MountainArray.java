package com.company;

public class MountainArray {
    //Mountain array is also called as Bitonic array
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 8, 16, 7, 4, 1};
        /*int[] arr = {2, 3, 5, 16, 8, 7, 4, 1};*/
        int peak = peakIndexMountainArray(arr);
        System.out.println(peak);
        System.out.println(arr[peak]);
    }

    static int peakIndexMountainArray(int[] arr){
        int start = 0;
        int end = arr.length-1;

        while(start < end){

            //Find the middle number
            int mid = start + (end - start) / 2;

            /*This checks if the mid greater than the mid+1 element then its descending part of the array
              and if we are in the descending part that means the peak number we are searching for must be
              on the left side, so we make the mid as end. */
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
}
