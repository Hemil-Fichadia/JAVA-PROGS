import java.util.*;

class PrefixSum1 {

    public static int[] prefixSumArrayItself(int[] A) {
        int sum = 0;
        for(int i = 0; i < A.length; i++){
            sum += A[i];
            A[i] = sum;
        }
        return A;
    }

    public static long[] rangeSum(int[] A, int[][] B) {
        long[] ans = new long[B.length];

        long[] prefixSum = new long[A.length];

        prefixSum[0] = A[0];
        for(int i = 1; i < A.length; i++){
            prefixSum[i] = prefixSum[i-1] + A[i];
        }

        for(int row = 0; row < B.length; row++){
            int start = B[row][0];
            int end = B[row][1];

            if(start == 0){
                ans[row] = prefixSum[end];
            }
            else{
                ans[row] = prefixSum[end] - prefixSum[start-1];
            }
        }
        return ans;
    }

    public static int equillibriumIndex(int[] A) {

        long[] prefixSum = new long[A.length];
        prefixSum[0] = A[0];

        int n = A.length;

        for(int i = 1; i < A.length; i++){
            prefixSum[i] = prefixSum[i-1] + A[i];
        }


        long rightSum = 0;
        long leftSum = 0;

        for(int i = 0; i < A.length; i++){

            if(i == 0){
                leftSum = 0;
                rightSum = prefixSum[n-1] - prefixSum[i];
            }

            else{
                leftSum = prefixSum[i-1];
                rightSum = prefixSum[n-1] - prefixSum[i];
            }

            if(leftSum == rightSum){
                return i;
            }
        }
        return -1;
    }

    public static int[] evenNumsInRange(int[] A, int[][] B) {

        int Asize= A.length;
        for(int i = 0; i < Asize; i++){
            if(A[i] % 2 == 0){
                A[i] = 1;
            }
            else{
                A[i] = 0;
            }
        }

        int[] prefixEvenSum = new int[Asize];
        prefixEvenSum[0] = A[0];
        for(int i = 1; i < Asize; i++){
            prefixEvenSum[i] = prefixEvenSum[i-1] + A[i];
        }


        int Bsize = B.length;
        int[] ans = new int[Bsize];
        for(int row = 0; row < Bsize; row++){
            int start = B[row][0];
            int end = B[row][1];
            if(start == 0){
                ans[row] = prefixEvenSum[end];
            }
            else{
                ans[row] = prefixEvenSum[end] - prefixEvenSum[start-1];
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        // Your code goes here
        //This gives error
        Scanner input = new Scanner(System.in);

        //********************************************************************************
        //Assignment
        //Q3. In-place Prefix Sum
        /* Given an array A of N integers. Construct prefix sum of the array in the given 
        array itself.
        
        Example Input
        Input 1:
        A = [1, 2, 3, 4, 5]
        
        Input 2:
        A = [4, 3, 2]

        Example Output
        Output 1:
        [1, 3, 6, 10, 15]
        
        Output 2:
        [4, 7, 9]
        
        
        A prefix sum array is nothig but cumulative sum of array.
        Ex:- A = [1, 2, 3, 4, 5] prefixSum aray will be constructed as 
        ans[] 1 , 1+2, 1+2+3, 1+2+3+4, 1+2+3+4+5  prefixSum = [1, 3, 6, 10, 15]
        
        */
        // int[] A = {1, 2, 3, 4, 5};
        // int[] ans = prefixSumArrayItself(A);
        // System.out.println(Arrays.toString(ans));


        //********************************************************************************
        //Assignment
        // Q4. Range Sum Query
        /* Problem Description
        You are given an integer array A of length N.
        You are also given a 2D integer array B with dimensions M x 2, where each row 
        denotes a [L, R] query.
        For each query, you have to find the sum of all elements from L to R indices 
        in A (0 - indexed).
        More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.
        
        For questions like process data in the given range prefix technique is used so that 
        we can get the answer without iterating the loop on the given range.
        
		int[] A = {1, 2, 3, 4, 5};
		1, 3, 6, 10, 15, 25, 40 so in this cumulative sum, if we are asked to calcualte the 
		value at 4th position that is 10 in array so we have to subtract 10 - 6 = 4 so the value
		at index 3 that is 4th position is 4 in the same way we have to calculate from start to
		end that means we need value at start that's why we have to do start-1.
		
        Suppose if it is asked that in given array calculate sum from 1 to 5 index 
        of array A = [1, 2, 3, 4, 5] than prefixSum = [1, 3, 6, 10, 15]
        we can calulate by using prefixSum start = 1 and end = 5 
        so prefixSum[end] - prefixSum[start - 1]; here is is start - 1 because we also need the
        sum till start so we need to do start-1.
        */
        // int[] A = {1, 2, 3, 4, 5, 6, 8};
        // int[][] B = {
        //                 {0, 3},
        //                 {1, 2},
        // 				{3, 6}
        //             };
        // long[] ans = rangeSum(A, B);
        // System.out.println(Arrays.toString(ans));


        //********************************************************************************
        //Assignment
        //Q5. Equilibrium index of an array
		/* Problem Description
		You are given an array A of integers of size N.

		Your task is to find the equilibrium index of the given array

		The equilibrium index of an array is an index such that the sum of elements at lower 
		indexes is equal to the sum of elements at higher indexes.

		If there are no elements that are at lower indexes or at higher indexes, then the 
		corresponding sum of elements is considered as 0.

		Note:

		Array indexing starts from 0.
		If there is no equilibrium index then return -1.
		If there are more than one equilibrium indexes then return the minimum index.
		
		Return the equilibrium index of the given array. If no such index is found then return -1.
		
		In this problem we have to find the equillibrium index and return it so that means here
		there is only one equillibrium index.
		The index from where the summation of all the array elements to the left is equal to the 
		summation of all the array elements at the right is called an equllibrium index. Here the 
		current index is excluded from the summation.
		
		So the logic here is if leftSum = prefixSum[i-1] and rightSum = prefixSum[n-1]-prefixSum[i];
		if leftSum == rightSum it is equllibrium index.
		
		*/
        // int[] A = {-7, 1, 5, 2, -4, 3, 0};
        // System.out.println(equillibriumIndex(A));


        //********************************************************************************
        //Assignment
        //Q6. Even numbers in a range
		/* You are given an array A of length N and Q queries given by 
		the 2D array B of size Qx2.

		Each query consists of two integers B[i][0] and B[i][1].

		For every query, your task is to find the count of even numbers in the range 
		from A[B[i][0]] to A[B[i][1]].
		
		There are some questions where we have to think of modifying the given array if it is not 
		altering anything. So her we have to look for even numbers in the given range. Now as the 
		range comes into picture, we have to think of prefix techenique in order to reduce the iterations
		repetatively on the range.
		So we have to think of something that gives the number of even numbers in the range so this 
		idea itself is the hint of modifying the given array by replacing all the even numbers with 
		1 and odd numbers with 0 and then if we construct the prefixSum of that, it will create a 
		cumulative addition of 1s and with the help of that we can get No. of even numbers
		in the given range.
		*/
         int[] A = {1, 2, 3, 4, 5};
         int[][] B = {
         		{0, 2},
         		{2, 4},
         		{1, 4}
         };
         int[] ans = evenNumsInRange(A, B);
         System.out.println(Arrays.toString(ans));

    }
}