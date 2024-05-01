package com.Hemil;

public class Main {

    public static void main(String[] args) {
        int[] nums = {23, 45, 6, 84, 90, -1, 11, -3, 16, 71};
        int target = 90;
        int ans = linearsearch(nums, target);
        System.out.println(ans);
    }
    //search in array, return the index if found
    //if item not found, return -1;
    static int linearsearch(int[] arr, int target)
    {
        if(arr.length == 0)
        {
            return -1;
        }

        //run a for loop
        for (int index = 0; index < arr.length; index++) {
            int element = arr[index];
            if(element == target)
            {
                return index;
            }
        }
        //this line will execute if none of the return statements hits
        //hence target not found
        return -1;
    }
}
