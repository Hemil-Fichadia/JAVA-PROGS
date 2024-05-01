package com.Hemil;

public class SearchInRange {
    public static void main(String[] args) {
        int[] arr = {21, 2, 44, 67, -2, 54, 76, 98};
        int target = 44;
        System.out.println(linearsearch(arr, target, 1, 5));
    }

    static int linearsearch(int[] arr, int target, int start, int end)
    {
        if(arr.length == 0)
        {
            return -1;
        }

        //run a for loop
        for (int index = start; index < end; index++) {
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
