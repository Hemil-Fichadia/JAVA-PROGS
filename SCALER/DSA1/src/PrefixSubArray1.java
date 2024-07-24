import java.lang.*;
import java.util.*;

class PrefixSubArray1 {

    public static int[] moneyInBeggarsPot(int A, int[][] B) {
        int[] ans = new int[A];

        for(int i = 0; i < B.length; i++){
            int start = B[i][0] - 1;
            int end = B[i][1] - 1;
            int value = B[i][2];

            ans[start] += value;
            if(end + 1 < A){
                ans[end+1] -= value;
            }
        }
        int sum = 0;
        for(int i = 0; i < ans.length; i++){
            sum += ans[i];
            ans[i] = sum;
        }
        return ans;
    }

    public static int[] prefixMaximum(int[] A) {
        int n = A.length;
        int[] prefixMax = new int[n];

        int max = A[0];
        prefixMax[0] = A[0];
        for(int i = 1; i < A.length; i++){
            if(max < A[i]){
                max = A[i];
            }
            prefixMax[i] = max;
        }

        return prefixMax;
    }

    public static int[] suffixMaximum(int[] A) {
        int n = A.length;
        int max = A[n-1];

        int[] suffixMax = new int[n];

        suffixMax[n-1] = A[n-1];
        for(int i = n-2; i >= 0; i--){
            if(max < A[i]){
                max = A[i];
            }
            suffixMax[i] = max;
        }
        return suffixMax;
    }

    public static int totalWaterTrapped(final int[] A) {
        int n = A.length;

        int max = A[0];
        int[] prefixMax = new int[n];
        prefixMax[0] = A[0];
        for(int i = 1; i < n; i++){
            if(max < A[i]){
                max = A[i];
            }
            prefixMax[i] = max;
        }

        max = A[n-1];
        int[] suffixMax = new int[n];
        suffixMax[n-1] = A[n-1];
        for(int i = n-2; i >= 0; i--){
            if(max < A[i]){
                max = A[i];
            }
            suffixMax[i] = max;
        }

        int water = 0;
        int accumulated = 0;

        for(int i = 0; i < n; i++){

            int left = prefixMax[i];
            int right = suffixMax[i];
            int level = Math.min(left, right);

            water = level - A[i];
            if(water > 0){
                accumulated += water;
            }
        }

        return accumulated;
    }

    public static int maxSumSubArray(final int[] A) {
        int sum = A[0];
        int ans = A[0];
        int n = A.length;
        for(int i = 1; i < n; i++){
            if(sum < 0){
                sum = 0;
            }
            sum += A[i];
            if(ans < sum){
                ans = sum;
            }
        }

        return ans;
    }

    public static void main(String[] args){

        //*****************************************************************
        //Assignment
        // Q1. Continuous Sum Query
        /* Problem Description
            There are A beggars sitting in a row outside a temple. Each beggar initially has 
            an empty pot. When the devotees come to the temple, they donate some amount of 
            coins to these beggars. Each devotee gives a fixed amount of 
            coin(according to their faith and ability) to some K beggars sitting next to 
            each other.

            Given the amount P donated by each devotee to the beggars ranging from L to R 
            index, where 1 <= L <= R <= A, find out the final amount of money in each 
            beggar's pot at the end of the day, provided they don't fill their pots by any 
            other means.
            For ith devotee B[i][0] = L, B[i][1] = R, B[i][2] = P, Given by the 2D array B.

            Here they are asking to calculate amount of money in each beggar's bowl at the end 
            of the day means after querying all the queries of array B what is the total amount
            that each of the beggar have.

            So this denotes the use case of the continuous sum query.

            In continuous sum query, we have to operate in the given sub array range and add the 
            given value to all the elements in that range. So for this we could be using 
            prefixSum but it also uses two for loops which results into O(N^2) time complexity.

            So according to the given constraints, we need to search for an optimised approach.

            Taking an empty array of length equal to A and adding the value of array B to the 
            starting index and subtracting that value from ending + 1 index doing the same for 
            all the rest of the queries and creating a cumulative prefixSum array will result in
            the same like we are adding those values to the array elements in the given range.
        */
        // int[][] B = {
        //     {1, 2, 10},
        //     {2, 3, 20},
        //     {2, 5, 25}
        // };
        // int A = 5;
        // int[] ans = moneyInBeggarsPot(A, B);
        // System.out.println(Arrays.toString(ans));



        //*****************************************************************
        //Assignment
        // Q2. Prefix maximum
        /* Problem Description
            Given an array A of length N, For every index i, you need to find the 
            maximum value occurring in subarray from 0 to i.
        */
        // int[] A = {9, 7, 6, 18, 2};
        // int[] prefixMax = prefixMaximum(A);
        // System.out.println(Arrays.toString(prefixMax));



        //*****************************************************************
        //Assignment
        // Q3. Suffix maximum
        /* Problem Description
            Given an array A of length N, For every index i, you need to find the maximum 
            value in subarray from i to N-1.
        */
        // int[] A = {12, 5, 6, 7};
        // int[] suffixMax = suffixMaximum(A);
        // System.out.println(Arrays.toString(suffixMax));

        //*****************************************************************
        //Assignment
        //Q4. Rain Water Trapped
        /* Given a vector A of non-negative integers representing an elevation map where the 
           width of each bar is 1, compute how much water it is able to trap after raining.

           This question is one of the easiest to solve, just it requires some attention and
           observation in order to understand the requirements to solve it.

           Here the given array elements represents the height of each building and it is given 
           that each building have a width of 1. We know that water can only be accumulatd if the 
           vessel or slot is covered from both sides so using that intution, we need to calculate
           water trapped on top of each building and then add it to accumulated.

           In order to calculate water collected on top of each building, we need to find how 
           a particular building is sourrounded by means the max and min walls of both sides.
           So here comes the intution, from the current building, find the max building on both
           sides and get the minimum of those because the max of those will not be responsible to
           store water as water will spill from either of the side of max size building.
           So that means we got the max hieght till which the water can accumulate on top 
           of that building and can be expressed as :-
           water =  min(leftwall, rightwall) - current height.

           So in order to find max in a given range, we cannot blindly iterate loop over it considering
           the given constraints and so we have to construct prefixMax to find max from left to ith index
           and suffixMax to find max from right to ith index. Getting max from both ends, get the min
           of them and assign it to level variable and water accumulated on top of that building will be
           water = level - A[i]; and add to accumulated.
        */
        // int[] A = {4, 2, 5, 7, 4, 2, 3, 6, 8, 2, 3};
        // System.out.println(totalWaterTrapped(A));


        //*****************************************************************
        //Assignment
        //Q5. Max Sum Contiguous Subarray
        /* Problem Description
            Find the contiguous non-empty subarray within an array, A of length N, 
            with the largest sum.
            At first glance it feels like taking all combinations of sub-arrays and then taking
            sum of all elements of but that will result to tle.
            So we will approach with the carry forward technique in which there is a sum variable 
            which is reset to 0 if its value becomes negative and it is updated normally with each
            iteration of loop by adding the arrays elements to it and this will work as taking all the
            combinations of sub-arrays. We are also updating ans if it is less than sum.
            So in this process we are discarding those combinations that have negative sum and even getting 
            the greatest sum possible with continuous sub-arrray.
            
        */
        int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSumSubArray(A));
    }
}