import java.util.*;
import java.lang.*;

class TwoDArray2_2 {

    public static long maxSumSubMatrix(int[][] A) {
        int N = A.length;
        int M = A[0].length;

        long[][] suffixSum2d = new long[N][M];
        long ans = Integer.MIN_VALUE;

        for(int i = N-1; i >= 0; i--){
            for(int j = M-1; j >= 0; j--){

                if(i == N-1 && j == M-1){
                    suffixSum2d[i][j] = A[i][j];
                }

                else if(i == N-1 && j != M-1){
                    suffixSum2d[i][j] = A[i][j] + suffixSum2d[i][j+1];
                }

                else if(j == M-1 && i != N-1){
                    suffixSum2d[i][j] = A[i][j] + suffixSum2d[i+1][j];
                }

                else{
                    suffixSum2d[i][j] = A[i][j] + suffixSum2d[i+1][j] + suffixSum2d[i][j+1] - suffixSum2d[i+1][j+1];
                }

                if(ans < suffixSum2d[i][j]){
                    ans = suffixSum2d[i][j];
                }
            }
        }

        return ans;
    }

    public static int searchInSortedMatrix(int[][] A, int B) {
        int N = A.length;
        int M = A[0].length;
        int i = 0;
        int j = M - 1;
        int ans = Integer.MAX_VALUE;
        boolean isThere = false;

        while(i < N && j >= 0){
            if(A[i][j] == B){
                isThere = true;
                int sum = ((i+1)*1009)+j+1;
                if(sum < ans){
                    ans = sum;
                }

                j--;
            }
            else if(A[i][j] < B){
                i++;
            }
            else{
                j--;
            }
        }

        if(isThere){
            return ans;
        }
        return -1;
    }

    public static void main(String[] args){
        //*********************************************************************
        //Assignment
        //Q4. Maximum Submatrix
        /* Problem Description
            Given an matrix A of size NxM, which is row-wise and column-wise sorted. 
            Find a submatrix such that sum of its elements is maximum and return this sum.

            This is sort of a tricky one and TA help made it possible to solve.
            This problem asks us to find the sub matirx with max possible sum so one thing that 
            comes to mind is lets add up the whole array for that the given array includes some 
            negative values. 
            
            So one thing is given that the array is sorted in row and colum wise so this gives us 
            an intution of the bottom right element will be the greatest so we can just start adding 
            from there. Here we need to add all the elements in a pattern where we can get the sum of 
            elements in such a way that we get sum of all the elements below and right to the current
            cell so in that way each cell will represent the sum till the bottom right and we can just 
            subtract those cell which are repeating. 

            Now for the starting cell which is bottom right of the given 2d array will be directly stored
            to the bottom right of the sum matrix (The matrix from which we are going to map the maximum
            possible sub-matrix sum) now, the iteration is done in reverse order from bottom right to left 
            in row than we decrement the row index and again start iteration from last column. In this 
            process, first we assigned the bottom right element of the given array in the sum array now 
            the we move towards left and the next column will be summation of the right most element of 
            the sum array and the current index element of the given array that is 
            suffixsum[i][j] = A[i][j] + sumsuffix[i][j+1]; in this way we will create a suffixsum of the bottom 
            row.

            Now as we move upward in row and at the last column we need to get the sum value of that
            cell in sum array and that will be suffixsum[i][j] = A[i][j] + suffixsum[i+1][j]; so 
            this cell of suffixsum matrix will have value = addition of right lower two columns and 
            now again moving towards left in the same row and that cell can be calulated as :-

            suffixsum[i][j] = A[i][j] + suffixsum[i][j+1] + suffixsum[i+1][j] - suffixsum[i+1][j+1];

            so any cell except for lower or right edges will follow the above formula of adding the 
            current element of given array to right and lower element of suffixsum array and subtracting 
            the immideate diagonal to the current cell from suffixsum array so that shows that however
            the combination of sub-matrix will be the diagonal part is repeated in this process.
                                           0  1
            suppose suffixsum array is 0 [ ?, b ]
                                       1 [ c, d ]
            formula for any cell except for edge elements ? = A[0][0] + b + c -d;

            In this process we will be comparing each element of suffixsum array and update if we 
            find any greater sum element and return the answer.
        */

        // int[][] A = {
        //     {-8, 1, 1},
        //     {-1, 6, 6},
        //     {7, 10, 10}
        // };
        // System.out.println(maxSumSubMatrix(A));

        //*********************************************************************
        //Homework
        //Q1. Search in a row wise and column wise sorted matrix
        /* Problem Description
            Given a matrix of integers A of size N x M and an integer B.
            In the given matrix every row and column is sorted in non-decreasing order. 
            Find and return the position of B in the matrix in the given form:
            If A[i][j] = B then return (i * 1009 + j)
            If B is not present return -1.

            Note 1: Rows are numbered from top to bottom and columns are numbered from 
            left to right.
            Note 2: If there are multiple B in A then return the smallest value of 
            i*1009 +j such that A[i][j]=B.
            Note 3: Expected time complexity is linear
            Note 4: Use 1-based indexing

            This problem is simple but requires some attention over searching for the target element.

            Here it is given that the given matrix is sorted in row and colum wise so the intution that 
            comes in mind is that the elements at the last column are going to be the greatest in particular
            row and the element in the bottom right corner is going to be the greatest in entire matrix.

            Now for searching an element we will begin the search from the top right corner that is the 
            first row and last column from there we will start comparing that if the target is greater 
            than the current element that means all the elements in that row are smaller than target 
            and it is invain to search element there so we move downward in row means row++ and again we 
            compare and if the element is smaller than the target than there is a chance that we can 
            find our target in that row so we move backward in that row means col-- and again we compare 
            and if the element is found or not and if the element is greater than the target then we again 
            move backward in the row and similarly if the element is smaller than the target than we move 
            downward and again compare till col >= 0 and row <= n-1;.

            But ther is catch here, that element could be in repetation and if we found the target we need 
            to look backward and if the number is target then we need to update i,j to that value in this
            way we can get the smallest index of target as we are moving backwards in column and we have to 
            return i * 1009 + j; 

            we have to use 1-based index here so we just need to add 1 to both indices in calculation.

        */
        int[][] A = {
                {1, 2, 3, 4},
                {5, 5, 6, 6},
                {7, 8, 9, 10},
                {11, 12, 13, 14}
        };
        int B = 6;
        int ans = searchInSortedMatrix(A, B);
        System.out.println(ans);
    }
}