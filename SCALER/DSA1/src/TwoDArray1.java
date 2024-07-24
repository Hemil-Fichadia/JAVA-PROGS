import java.util.*;
import java.lang.*;

class TwoDArray1 {

    public static int subArrayGivenLengthSum(int[] A, int B, int C) {
        int sum = 0;
        for(int i = 0; i < B; i++){
            sum += A[i];
        }

        if(sum == C){
            return 1;
        }

        int n = A.length;
        int start = 1;
        int end = B;

        while(end < n){
            sum = sum - A[start-1] + A[end];
            if(sum == C){
                return 1;
            }
            start++;
            end++;
        }
        return 0;
    }

    public static long maxSumSubArrayFixLen(int[] A, int B) {

        int n = A.length;
        int start = 1;
        int end = B;
        long ans = Long.MIN_VALUE;

        long sum = 0;
        for(int i = 0; i < B; i++){
            sum += A[i];
        }
        if(ans < sum){
            ans = sum;
        }

        while(end < n){
            sum = sum - A[start-1] + A[end];
            if(ans < sum){
                ans = sum;
            }
            start++;
            end++;
        }
        return ans;
    }

    public static void printMatrixSpiral(int[][] B){

        int N = B.length;

        int row = 0;
        int col = 0;
        while(N > 1){

            for(int k = 1; k < N; k++){
                System.out.print(B[row][col]+" ");
                col++;
            }
            for(int k = 1; k < N; k++){
                System.out.print(B[row][col]+" ");
                row++;
            }
            for(int k = 1; k < N; k++){
                System.out.print(B[row][col]+" ");
                col--;
            }
            for(int k = 1; k < N; k++){
                System.out.print(B[row][col]+" ");
                row--;
            }
            row++;
            col++;
            N -= 2;
        }

        if(N == 1){
            System.out.print(B[row][col]+" ");
        }
    }

    public static int findInMatrix(int[][] A, int B) {
        int rowLen = A.length;
        int colLen = A[0].length;
        int row = 0;
        int col = colLen-1;

        while(row < rowLen && col >= 0){

            if(A[row][col] == B){
                return 1;
            }
            else if(A[row][col] < B){
                row++;
            }
            else{
                col--;
            }
        }

        return 0;
    }
    public static void main(String[] args){

        //*********************************************************************
        //Assignment
        //Q1. Subarray with given sum and length
        /* Problem Description
            Given an array A of length N. Also given are integers B and C.
            Return 1 if there exists a subarray with length B having sum C and 0 otherwise 
        */
        // int[] A = {4, 3, 2, 6, 1};
        // int B = 3;
        // int C = 11;
        // System.out.println(subArrayGivenLengthSum(A, B, C));


        //*********************************************************************
        //Assignment
        //Q2. Maximum subarray sum of fixed length
        /* Problem Description
            Given an array A of length N, Find the maximum subarray sum out of all possible 
            subarray of length B. 
        */
        // int[] A = {6, 7, 8, 2};
        // int B = 2;
        // System.out.println(maxSumSubArrayFixLen(A, B));


        //*********************************************************************
        //Assignment
        //Q3. Spiral matrix
        /* Problem Description

        Given an integer matrix A of size NxN. Print the matrix in spiral form starting 
        from A[0][0] in the first row.
        For example : Given matrix of 2x2
        1 2
        3 4
        You should print => 1 2 4 3 
        */
        // int[][] B = {
        //     {1, 2, 3},
        //     {4, 5, 6},
        //     {7, 8, 9}
        // };
        // printMatrixSpiral(B);


        //*********************************************************************
        //Assignment
        //Q4. Find in matrix
        /* Problem Description
            Given an matrix A of size NxN, which is row-wise and column-wise sorted. 
            Find if the number B exists in the matrix.
            Note : 0 represents False and 1 represents True 

            Here it is given that the matrix is sorted in row and column wise so that gives 
            an intution to search efficiently in matrix. We can begin searching for the element 
            from the top right corner as the last column elements are greatest in that row and
            if the target is greater than that top right element than we increase row and again 
            it begins from the last column and if the target is less than that element than we move
            backwards in row and compare it if the element is less than the target than we move 
            down in row for the same column as we moved backwrd due to the last column element was 
            greater than the target so we moved down in row in same column and compare if the element 
            is greates than target than again we move baackward in the column in the same row and if
            the element is found then it is returned and if not the same process is continued.
        */
        int[][] B = {
                {-10, -5, -2,  2,  4,  7},
                {-7,  -4, -1,  3,  6,  9},
                {-2,   3,  5,  7,  11, 14},
                { 3,   6,  8,  11, 14, 17},
                {7,    11, 12, 15, 19, 20},
                {10,   14, 18, 20, 24, 29},
        };
        int target = 12;
        System.out.println(findInMatrix(B, target));

    }
}