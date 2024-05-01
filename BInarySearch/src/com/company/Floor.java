package com.company;

public class Floor {
    /*This is program of finding a floor number, a number which is the greatest number lesser than or equal
    to the target number inside a given array*/
    /*This thing is achieved by binary search as the search begins, it starts getting halved after each steps
      of search, so it drags till it reaches to the closest number of the target. Now if the number is not
      found, in the final range of scope of start and range then according to our logic the start is increased
      by (mid + 1) as the target is greater than the searched number so the start goes to mid + 1 but the end
      remains the same as the final searched so the number at the end index  is our floor number as the number
      found at the start is the result of the target to be greater than the last search between 45 and 89, so it
      continued it searches till 89 now the end is 45 because the last targeted searched number is 89
      so the target is less than the mid which is 89 so the first if condition of end = mid - 1; is executed so
      now the end is 11 and start is 12 as it was so this condition breaks the while loop and the number at the
      end index is our floor number. */
    public static void main(String[] args) {
        // write your code here
        int arr[] = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};
        int target = 17;

        int index = floor(arr, target);
        /*Here in floor function it is by default returning -1 as the least number would be found at 0th index
          and if the target is lesser than it, then end = mid - 1, so automatically it is 0 - 1 = -1. */
        if(index == -1){
            System.out.println("Sorry the number is already lesser than least value");
        }
        else{
            int ans = arr[index];
            System.out.println(ans);
        }
    }

    //return the index
    static int floor(int[] arr, int target){
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
                //This is the best case as the number itself is found
                return mid;
            }
        }
        return end;
    }
}