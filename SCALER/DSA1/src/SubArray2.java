import java.util.*;

class SubArray2 {

    public static int goodSubArray(int[] A, int B) {
        int sum = 0;
        int n = A.length;
        int goodSubArray = 0;
        for(int start = 0; start < n; start++){
            int subLength = 0;
            sum = 0;
            for(int end = start; end < n; end++){
                sum += A[end];
                subLength++;

                if(subLength % 2 ==0 && sum < B || subLength % 2 != 0 && sum > B){
                    goodSubArray++;
                }
            }
        }
        return goodSubArray;
    }

    public static int subArraysWithSumlessThan(int[] A, int B) {

        int sum = 0;

        int n = A.length;

        int subArray = 0;

        for(int start = 0; start < n; start++){

            sum = 0;
            for(int end = start; end < n; end++){
                sum += A[end];

                if(sum < B){
                    subArray++;
                }
            }
        }
        return subArray;
    }

    public static void main(String args[]) {
        // Your code goes here
        //This gives error
        Scanner input = new Scanner(System.in);

        //****************************************************************************
        //Homework
        //Q2. Good Subarrays Easy
		/* Problem Description
			Given an array of integers A, a subarray of an array is said to be good if 
			it fulfills any one of the criteria:
			1. Length of the subarray is be even, and the sum of all the elements of 
			the subarray must be less than B.
			2. Length of the subarray is be odd, and the sum of all the elements of the subarray 
			must be greater than B.
			Your task is to find the count of good subarrays in A.

		*/

        // int[] A = {1, 2, 3, 4, 5};
        // System.out.println(goodSubArray(A,4));



        //****************************************************************************
        //Homework
        //Q3. Counting Subarrays Easy
		/* Problem Description
			Given an array A of N non-negative numbers and a non-negative number B,
			you need to find the number of subarrays in A with a sum less than B.
			We may assume that there is no overflow.
		*/
        int[] A = {1, 2, 3, 4, 5};
        System.out.println(subArraysWithSumlessThan(A,8));

    }
}