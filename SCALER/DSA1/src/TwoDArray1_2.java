import java.lang.*;
import java.util.*;

class TwoDArray1_2 {

    public static int leastAvgSubArryFixLen(int[] A, int B) {

        int average = Integer.MAX_VALUE;
        int n = A.length;
        int sum = 0;
        int index = 0;
        for(int i = 0; i < B; i++){
            sum += A[i];
        }

        average = sum;

        int start = 1;
        int end = B;

        while(end < n){
            sum = sum - A[start-1] + A[end];

            if(sum < average){
                average = sum;
                index = start;
            }
            start++;
            end++;
        }
        return index;
    }

    public static int minimumSwaps(int[] A, int B) {
        //Solved using sliding window technique
        int swap = Integer.MAX_VALUE;
        int targetElements = 0;
        int n = A.length;

        for(int i = 0; i < n; i++){
            if(A[i] <= B){
                targetElements++;
            }
        }

        int windowLen = targetElements;
        int start = 0;
        int end = windowLen-1;
        int count = 0;
        for(int i = start; i <= end; i++){
            if(A[i] > B){
                count++;
            }
        }

        start = 1;
        end = windowLen;
        swap = count;
        while(end < n){
            if(A[start-1] > B){
                count--;
            }
            if(A[end]>B){
                count++;
            }
            if(count < swap){
                swap = count;
            }
            start++;
            end++;
        }

        return swap;
    }

    public static int[][] generateMatrix(int A) {
        int[][] matrix = new int[A][A];
        int N = A;
        int row = 0;
        int col = 0;
        int element = 1;
        while(N > 1){

            for(int k = 1; k < N; k++){
                matrix[row][col] = element;
                col++;
                element++;
            }
            for(int k = 1; k < N; k++){
                matrix[row][col] = element;
                row++;
                element++;
            }
            for(int k = 1; k < N; k++){
                matrix[row][col] = element;
                col--;
                element++;
            }
            for(int k = 1; k < N; k++){
                matrix[row][col] = element;
                row--;
                element++;
            }
            row++;
            col++;

            N -= 2;
        }

        if(N == 1){
            matrix[row][col] = element;
        }

        return matrix;
    }

    public static void main(String[] args){
        //*********************************************************************
        //Homework
        // Q1. Subarray with least average
        /* Problem Description
            Given an array of size N, find the subarray of size K with the least average.

            There is a stepping stone here is of taking average and if the sum is less, than
            average too will be less so no need to calculate average we can just compare sum.

            It is solved with the same sliding window sum technique window is slided forward and
            the element one index back of the window is subtracted and the end element of window is
            added. In this way sum is calculated and compared.
        */
        // int[] A = {3, 7, 90, 20, 10, 50, 40};
        // int B = 3;
        // System.out.println(leastAvgSubArryFixLen(A, B)); 


        //*********************************************************************
        //Homework
        // Q2. Minimum Swaps
        /* Problem Description

            Given an array of integers A and an integer B, find and return the minimum 
            number of swaps required to bring all the numbers less than or equal to B together.

            Note: It is possible to swap any two elements, not necessarily consecutive.

            Here in question we are expected to return the minimum nuber of swaps required to group 
            all the elements which are less than the given number together. So we don't actually need 
            to bring them together but we can think of like the position at which those targetted elements
            are more in number together, we can take remaining targetted elements near them so this way 
            the number of swaps would be reduced atomatically.

            So for that first the number of target elements means elements that are less than or equal to B 
            are found first by iterating over array and the count of the elements will result into the 
            size of our window which we are going to slide over array and inside that window we will 
            search those elements that are greater than the given number and the window which gives the
            minimum number of count will be returned. 

            So for this logic, initial window is iterated and the count of elements that are greater than
            the given number are counted and stored in count variable. Now window is slidede to next position 
            and in the similar way of sliding window the previous element than window and the end element 
            of the window are the elements which differs than the previous window so those are checked.

            The previous element than window is checked that if it is greater than the given number then 
            it definitely contributes in count so count is decremented by 1. The end element is greater than 
            the given number than count is incremented by 1 so in this way we are counting the number of 
            elements that are greater than given element and the window in which the count is least will 
            have the most number of targetted elements together and the no of swaps would be equal to the 
            count variable of that window.

        */
        // int[] A = {1, 12, 10, 3, 14, 10, 5};
        // int B = 8;
        // System.out.println(minimumSwaps(A, B));


        //*********************************************************************
        //Homework
        // Q3. Spiral Order Matrix II
        /* Given an integer A, generate a square matrix filled with elements from 1 to A2 in 
            spiral order and return the generated square matrix.

            Here we have to store elements from 1 to A^2 in a 2d matrix. So an integer A is given 
            and we have to store A^2 elements so A x A would be the dimension of the ans matrix.
            For storing elements we have to iterate over the matrix in spiral pattern and after storing 
            each element we have to simply increment it.
        */
        int[][] ans = generateMatrix(3);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }


    }
}