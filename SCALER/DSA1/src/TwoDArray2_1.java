import java.util.*;
import java.lang.*;

class TwoDArray2_1 {

    public static int[] subMatrixSum(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int Alen = A.length;
        int ARowLen = A[0].length;
        int[][] prefixSum2D = new int[Alen][ARowLen];

        int mod = 1000000007;

        int sum = 0;
        //row wise sum 
        for(int row = 0; row < Alen; row++){
            sum = 0;
            for(int col= 0; col < ARowLen; col++){
                sum += A[row][col];
                sum %= mod;
                prefixSum2D[row][col] = sum;
            }
        }

        //col wise sum
        for(int col = 0; col < ARowLen; col++){
            sum = 0;
            for(int row = 0; row < Alen; row++){
                sum += prefixSum2D[row][col];
                sum %= mod;
                prefixSum2D[row][col] = sum;
            }
        }


        //calculating the sum
        int queryLen = B.length;
        //ans array
        int[] ans = new int[queryLen];
        for(int query = 0; query < queryLen; query++){
            //r1
            int startRow = B[query]-1;
            //c1
            int startCol = C[query]-1;
            //r2
            int endRow = D[query]-1;
            //c2
            int endCol = E[query]-1;

            sum = prefixSum2D[endRow][endCol];
            if(startRow != 0){
                sum -= prefixSum2D[startRow-1][endCol];
                sum %= mod;
            }
            if(startCol != 0){
                sum -= prefixSum2D[endRow][startCol-1];
                sum %= mod;
            }
            if(startRow != 0 && startCol != 0){
                sum += prefixSum2D[startRow-1][startCol-1];
                sum %= mod;
            }

            ans[query] = (int)(sum+mod)%mod;
        }

        return ans;
    }

    public static int sumOfAllSubMatrices(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        int sum = 0;
        for(int row = 0; row < N; row++){
            for(int col = 0; col < M; col++){
                long count = (long) (row + 1) *(col + 1)*(N - row)*(M - col);
                sum += (int) (A[row][col]*count);
            }
        }
        return sum;
    }

    public static int maxNoOf1s(int[][] A) {
        int index = 0;
        int ans = 0;
        int Alen = A.length;
        int rowLen = A[0].length;
        int sum = 0;
        for(int i = 0; i < Alen; i++){
            sum = A[i][0];
            for(int j = 1; j < rowLen; j++){
                sum += A[i][j];
                A[i][j] = sum;
            }
            if(ans < sum){
                ans = sum;
                index = i;
            }
        }
        return index;
    }


    public static void main(String[] args){

        //*********************************************************************
        //Assignment
        //Q1. Sub-matrix Sum Queries
        /* Problem Description
            Given a matrix of integers A of size N x M and multiple queries Q, for each query, 
            find and return the submatrix sum.

            Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix 
            whose sum is to find out.

            NOTE:-
            Rows are numbered from top to bottom, and columns are numbered from left to right.
            Sum may be large, so return the answer mod 109 + 7.

            At first glance, problem appears to be solved just using prefixSum matrix and 
            taking the sum of the given range in form of queries but it isn't. 
            In order to take prefixSum of a matrix, first we need to calculate row wise sum 
            then take column wise sum on the same matrix that contains row wise sum which will
            give our prefixSum matrix.

            Now in order to calculate sum of a given sub-matrix we need co-ordinates of top-left and
            bottom-right and first we calcualte the sum till the bottom-right corner of the given 
            query then we subtract the redundant part and add the part that is subtracted twice 
            in this calculation.

            There is a catch, it is given in constraints that the value can exceed the int range so 
            we need to limit it down to int range and for that they have provided to take mod with 
            10^9 but there one thing to be understood the elements of the given array can be negative 
            so answer could be negative but here  if we take mod the answer can never be negative that 
            means we need to store only positive elements in ans array.

            After grabbing all things there is one problem with java that it returns negative ans on 
            taking mod with negative answers so in order to make them positive, we need to add the limit
            to the answer and then take combined modulus of it. 
        */
        // int[][] A = {   
        //     {1, 2, 3},
        //     {4, 5, 6},
        //     {7, 8, 9}
        // };
        // int[] B = {1, 2};
        // int[] C = {1, 2};
        // int[] D = {2, 3};
        // int[] E = {2, 3};
        // int[] sum = subMatrixSum(A, B, C, D, E);
        // System.out.println(Arrays.toString(sum));


        //*********************************************************************
        //Assignment
        //Q2. Sum of all Sub matrices
        /* Problem Description
            Given a 2D Matrix A of dimensions N*N, we need to return the sum of all 
            possible sub matrices.
            matrix is of dimension N x M 
            Here it is clearly mentioned that we need to calculate the sum of all possible
            sub-matrices and for that we cannot even think for brute force approach as it 
            is inapproachable. There is a requirement to think for an optimised solution.
            
            The contribution technique is the one which can be used to get the contribution 
            of each element but for that we need to get each combination in which an element 
            can be found and so for that purpose we need to multiply total possible starting and 
            ending of the i,j element so that would be given as multiplying total number of 
            top left and bottom right that will give us total count of i,j element's contribution.

            In order to generalise it, it can be related to 1d array case like (i+1)(n-i) 
            similarly for 2d it is This represents total possible top lefts that includes i,j element
            top lefts --> (i+1)(j+1) and this represents total possible bottom rights which will
            include i,j element bottom rights --> (N-i)(M-j) count of an element = (i+1)(j+1)(N-i)(M-j);
        */
        // int[][] A = {   
        //     {1, 2, 3},
        //     {4, 5, 6},
        //     {7, 8, 9}
        // };
        // System.out.println(sumOfAllSubMatrices(A));


        //*********************************************************************
        //Assignment
        //Q3. Row with maximum number of ones
        /* Problem Description
            Given a binary sorted matrix A of size N x N. Find the row with the maximum 
            number of 1.

            NOTE:
            If two rows have the maximum number of 1 then return the row which has a lower index.
            Rows are numbered from top to bottom and columns are numbered from left to right.
            Assume 0-based indexing.
            Assume each row to be sorted by values.
            Expected time complexity is O(rows + columns).

            This was bit of an easy one I thought of taking row wise prefixSum and just compare 
            it and just take the greater one.
        */
        int[][] A = {
                {0, 0, 0, 0},
                {0, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 1, 1, 1}
        };
        System.out.println(maxNoOf1s(A));


    }
}