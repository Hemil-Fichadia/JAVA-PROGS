package com.company;

public class SplitArray {
    /*In this problem, we have to make continuous m partitions of a given array and find the least maximum
    * sum of the partition */
    /*This problem doesn't seem like the problem of binary search as the array is not sorted but as we try
    * to understand it deeply it will be easy, and it will click at some point that here comes the application
    * of binary search*/
    public static void main(String[] args) {
        int[] arr = {7, 2, 5, 10, 8};
        int m = 2;
        int ans = splitArray(arr, m);
        System.out.println(ans);
    }

    static int splitArray(int[] arr, int m){
        /*Here start and end are not actually the start and end indexes of array, but they are actually the
        bound or range in which we will search for the required, the least maximum sub array sum */
        int start = 0;
        int end = 0;

        for (int j : arr) {

            /*Now, the maximum sum we can get is when the partition m = 1 that is the sum of whole array itself
            * so that is assigned to end which will be our end in case of search for required sum and the
            * maximum number of partitions that are possible is no of elements in array itself means every
            * element is converter to a sub-array so in that case our answer would be the greatest sum amongst
            * them which would be the highest element itself so here the start = 10 and end = 32.*/

            /*As we are working in a range, so we have gradually increasing values so at this point it reminds
             * us to use binary search.*/

            start = Math.max(start, j);
            end += j;
        }

        while(start < end){
            /*Here the while loop breaks at the instant where start = end so our search continues till the
            * start is less than end.*/

            /*As in binary search, there was a chance of mid to be a potential answer here it behaves like
            * the same but this mid actually drives us to the chances of finding the required answer as it
            * behaves like a limit for sub-arrays that would store elements less than or equal to value of
            *  this mid-limit*/
            //Try for middle as potential ans
            int mid = start + (end - start) / 2;

            /*Here we are not actually creating arrays but instead adding those elements in a variable called
            * sum so ultimately our purpose id served as the sum is only compared with this mid-value.*/

            /*Here pieces is actually the partitions that are to be done accordingly. So the requirement is
            * checked first, if the sum of the sub-array(which is imaginary, and it is directly considered as
            * a sum variable) is less than or equal to the mid than sum is added by the elements but if the
            * sum of that sub array exceeds the limit of mid, then sum is overwritten by the current element
            * through which the if condition was violated and pieces is incremented by 1 so this mimics the
            * situation of creating new sub-array and its sum would be equal to its first element now again
            * same process is carried on till each and every element of array are divided into sub-arrays*/
            int sum = 0;
            int pieces = 1;

            for(int num: arr){
                if(sum + num <= mid){
                    sum += num;
                }
                else{
                    sum = num;
                    pieces++;
                }
            }

            /*Now, number of pieces(partitions) are checked if they are more than the given value m, that means
            * the individual sum limit which is mid is less than it should be, so it is increased by starting
            * our range of search from an element ahead of the existing mid because the values are in ascending
            * order so at the right-hand side of the existing mid there are higher values than left-hand side
            * so now the new mid would be automatically higher than the previous mid because here the average
            * higher start is taken with end so the new mid would be higher too*/
            if(pieces > m){
                start = mid + 1;
            }
            /*If the pieces are less than or equal to m, then it means that the individual sum of the sub-arrays
            * are more than they should be, so now the mid is reduced by shifting the search range to the
            * left-hand side of the existing mid as the left-hand side numbers are less in value then existing
            * mid so existing mid is now new end and the new average would be reduced as the end is minimized
            * so new mid is lesser than previous mid so in this way the individual sum of sub-array is reduced
            * so this results in more-number of sub-arrays. */
            else{
                end = mid;
            }
        }
        /*A certain point comes when the start end and mid all point to a single value so the condition of the
        * while loop is violated and loop breaks at that point the value is our answer.*/
        return end; //Here start == end
    }
}
