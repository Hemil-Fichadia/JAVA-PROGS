import java.lang.*;
import java.util.*;

class PrefixSubArray2 {

    public static int[] continuousSumQueryNonZeroArray(int[] A, int[][] B) {
        int n = A.length;
        int[] ans = new int[n];
        for(int i = 0; i < B.length; i++){
            int start = B[i][0]-1;
            int end = B[i][1]-1;
            int value = B[i][2];

            ans[start] += value;
            if(end + 1 < n){
                ans[end+1] -= value;
            }
        }
        int sum = 0;
        for(int i = 0; i < ans.length; i++){
            sum += ans[i];
            ans[i] = sum;
        }

        for(int i = 0; i < n; i++){
            ans[i] += A[i];
        }

        return ans;
    }

    public static int chocolateDistribution(int[] A, int B) {
        Arrays.sort(A);
        int n = A.length;

        if(B == 0 || n == 0){
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i <= (n-1)-B; i++){
            int end = B + i - 1;
            int difference = A[end] - A[i];
            if(difference < ans){
                ans = difference;
            }
        }
        return ans;
    }

    public static void main(String[] args){

        //*****************************************************************
        //Homework
        // Q1. Range sum - 2
        /* Here it is same as assignment question-1 but the given array is non-zero so the change
        is just we need add the resulting prefixSum array with the respective index to the given 
        non-zero array and works fine.
        */
        // int[] A = {1, 2, 1, 4};
        // int[][] B = {
        //     {2, 3, 2},
        //     {1, 4, 5},
        //     {4, 4, 1}
        // };
        // int[] ans = continuousSumQueryNonZeroArray(A, B);
        // System.out.println(Arrays.toString(ans));


        //*****************************************************************
        //Homework
        // Q2. Chocolate Distribution
        /* Problem Description
            Given an array A of N integers where the i-th element represent the number of 
            chocolates in the i-th packet.

            There are B number of students, the task is to distribute chocolate packets 
            following below conditions:

            1. Each student gets one packets.
            2. The difference between the number of chocolates given to any two students 
            is minimum.
            Return the minimum difference (that can be achieved) between the student who gets 
            minimum number of chocolates and the student who gets maximum number of chocolates.

            Note: If you can't give each student 1 packet, return 0. 

            Here the idea is, it is given that we have a chocolate array where each element 
            represents packet of chocolate and the value is no of chocolates in it. B is the no.
            of students and we have to distribute chocolate packets to them in such a way that the
            difference between maximum chocolate packet and minimum chocolate packet is least.

            So to solve this problem, we need to sort the array as we are not bound with the 
            occurrence of the elements and after that the intution is that B is the distribution 
            count and also it will be our sliding window to get the both extreme ends not for calculating
            sum and after getting both ends of the window and taking end minus start and updating to 
            variable difference if it is less than previous difference.
        */

        int[] A = {3, 4, 1, 9, 56, 7, 9, 12};
        int B = 5;
        System.out.println(chocolateDistribution(A, B));
    }
}