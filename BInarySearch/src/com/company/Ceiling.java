package com.company;

public class Ceiling {
    /*This is program for finding a ceiling number, a number which is the smallest number greater than
     or equal to the target number in a given array*/
    /*This thing is achieved by binary search as a target number is given in the function and the search is
      initiated as same as binary search now as the search begins, it gets halved with each step of search and
      the number gets closer and closer to the target and if the number is found, it is returned but if number
      is not found then the start index which is +1 of the end index at the value of termination of
      while loop is returned as if the search is carried most likely close to the target number, the expected
      ceiling number is just one further then the closest number searched as the array is sorted in ascending
      order. */
    /*The number is just one further because the number is not found in between start and end index so that means
      the number must be outside the range of start and end and by the time as the loop is terminated,
       the condition is like the start is one ahead of the end index so that is the ceiling number. */
    public static void main(String[] args) {
        // write your code here
        int arr[] = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};
        int target = 44;

        int index = ceiling(arr, target);
        if(index == -1){
            System.out.println("Sorry the number is greater than the greatest value");
        }
        else{
            int ans = arr[index];
            System.out.println(ans);
        }
    }

    //return the index
    static int ceiling(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;

        /*but what if the target number is greater than the greatest number of the array itself,
        so return -1.*/
        if(target > arr[arr.length-1]){
            return -1;
        }

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
                //This is the best case as the number itself is found
                return mid;
            }
        }
        return start;
    }
}