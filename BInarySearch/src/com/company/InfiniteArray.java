package com.company;

public class InfiniteArray {
    public static void main(String[] args) {
        //If the array is sorted then apply binary search without hesitation
        /*As the array is infinite, the start and end indexes are unknown so before applying binary search we
          first need to search in a finite range of array and then gradually increase that range.*/
        int[] arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int target = 10;
        System.out.println(ans(arr, target));
    }

    //The ans function returns the main answer
    static int ans(int[] arr, int target){
        /*In this function, the small boxes of finite range with multiple of 2 are generated and checked
        * whether the target number is lesser than the ending number of the box of multiple of 2. If the number
        * is greater than the ending number of the box then the box is increased by the double size of its
        * previous and again checked if the target number is lesser than the ending number because this is
        * a sorted array in increasing order so if the number is lesser than the ending number, then the target
        * will lie inside that range and binary search is applied to that range */

        /*So this ans function returns the end and start index to binary algorithm function and search is
        * initiated */

        //first find the range
        //first start with box of size 2
        int start = 0;
        int end = 1;

        //condition for target to lie in the range
        while(target > arr[end]){
            /*If the target is greater than the end number of that box, then the range is doubled than the
            * earlier form the successive index of the previous search and new range of double size is generated*/
            /*So for this, first new start is end + 1, and it is stored inside temp variable as the value of start
            * is still required for the calculation of new end so start is not manipulated now.*/
            int temp = end + 1;

            /*Now the size of the box is doubled by generating new end that will result into the required
            * double range. So this is carried out by following method:-
            *  suppose the previous start was at 0 and end was at 1 so new start is end + 1 = 2 and new end is
            * calculated as the previous end + the double size of elements than previous no. of elements */

            /*So the double size of previous elements are calculated as by calculating the no. of elements from
            * current range and doubling it and adding it to the current end. here (end - start + 1 ) is the
            * count of the current no. of elements and this is calculated with help of indexes so the operation
            * is also with respect to indexes so the count is calculated as subtracting the elements of current
            * range from the total size of array till the end*/
            //double the box value
            //end = previous end + sizeofbox*2
            end = end + (end - start + 1) * 2;
            start = temp;
        }
        //Here, the function is called at the return statement of the ans function
        return binarysearch(arr, target, start, end);
    }

    //This function is for binary search algorithm, it returns the index of the target number
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
