package com.company;

public class OrderAgnosticBS {
    public static void main(String[] args) {
//        int arr[] = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};
        int arr[] = {89, 45, 22, 18, 16, 15, 4, 3, 2, 0, -4, -12, -18};
        int target = 22;
        int ans = orderAgnosticBS(arr, target);
        System.out.println(ans);
    }

    static int orderAgnosticBS(int[] arr, int target){
         /*This code is focused on the array which is sorted but the order of sorting is unknown,
         weather it is ascending or descending*/
        int start = 0;
        int end = arr.length-1;

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
