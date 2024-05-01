package com.company;

import java.util.Arrays;

public class SortedMatrix {
    public static void main(String[] args) {

        int[][] arr = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println(Arrays.toString(search(arr, 7)));
    }

    //Simple Binary search for searching the target in a particular row and between two specific columns
    static int[] binarySearch(int[][] matrix, int row, int start, int end, int target){
        while(start <= end){
            int mid = start + (end - start) / 2;

            if(matrix[row][mid] == target){
                return new int[]{row, mid};
            }
            else if(matrix[row][mid] < target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }


    static int[] search(int[][] matrix, int target){

        // here it is not taken as matrix.length-1 as it is used to check if the array is 1 dimensional
        int rows = matrix.length;
        /*It is a homogenous array so row and col size will be uniform that means all the lengths will be same
        as the length of the first column. */
        int cols = matrix[0].length;

        //To check if the array is one dimensional
        if(rows == 1){
            return binarySearch(matrix, 0, 0, cols-1, target);
        }

        //The RowStart is starting from 0 as the search is carried out from first row.
        int RowStart = 0;
        //Here rows is equal to length of matrix so the end index would be less than the length
        int RowEnd = rows - 1;
        int ColMid = cols / 2;

        //run the loop till two rows are remaining
        while( RowStart < (RowEnd-1) ){//while it is true it will have more than two rows
            int RowMid = RowStart + (RowEnd - RowStart) / 2;
            if(matrix[RowMid][ColMid] == target){
                return new int[]{RowMid, ColMid};
            }
            else if(matrix[RowMid][ColMid] < target){
                /* Here in matrix if the mid is less than the target that means there are chances that
                * answer may lie in the right-hand side of that row where middle was there and now that previous
                * mid becomes new start. Here we cannot just skip the mid which does not satisfy the condition
                * as the mid itself is not matching the need but there might be chances of getting our target
                * on the either of the side of that non-satisfying mid, but we ignore the rows above it so that
                * at the end of the while loop, we are left with two rows to be searched for. */
                RowStart = RowMid;
            }
            //matrix[RowMid][ColMid] > target
            else{
                /* Here if the element is greater than the target, it means that the row below it is going to
                * have set of numbers greater than the current mid-element so the row below that current mid
                * is eliminated not the current row because there are chances that target may exist on the left
                * of the current mid-element. So the new end is now switched to current mid and in that case
                * it will only jump upwards as the end is lower row bound and that is done on purpose as we need
                * only two rows at the end in order to apply binary search on a particular row with specific
                * set of columns in that row. */
                RowEnd = RowMid;
            }
            /* At the end of this loop we will be remaining with maximum of two rows as the condition is made
            * in such a way that start = end -1 ==> means it denotes to have two consequent rows so the while
            * loop have a condition of < than so sequentially first it will reach at equilibrium = so the condition
            * will be violated and at the end, the RowStart will be having a starting value of two consequent
            * rows with possibility of target to be found so instead of RowStart and RowEnd,
            * RowStart and RowStart + 1 are used as start and end given to the binary search function  */
        }



        //Now we have two rows remaining
        //Search the target that lies in the columns of the remaining two rows at the end of the loop
        if(matrix[RowStart][ColMid] == target){
            return new int[]{RowStart, ColMid};
        }
        if(matrix[RowStart + 1][ColMid] == target){
            return new int[]{RowStart+1,ColMid};
        }

        //Otherwise
        /* Here, the whole matrix of two rows is split into 4 parts two parts either of the sides of middle
        * in both the rows so searching begins with the left-hand side of  */
        //Search in 1st half
        if(target <= matrix[RowStart][ColMid - 1]){
            return binarySearch(matrix, RowStart, 0, ColMid - 1, target);
        }
        //Search in 2nd half
        if(target >= matrix[RowStart][ColMid + 1] && target <= matrix[RowStart][cols - 1]){
            return binarySearch(matrix, RowStart, ColMid + 1, cols - 1, target);
        }
        //Search in 3rd half
        if(target <= matrix[RowStart + 1][ColMid - 1]){
            return binarySearch(matrix, RowStart + 1, 0, ColMid - 1, target);
        }
        //Search in 4th half
        //target >= matrix[RowStart+1][ColMid+1] && target <= matrix[RowStart+1][ColMid+1]
        else{
            return binarySearch(matrix, RowStart + 1, ColMid + 1, cols - 1, target);
        }


    }
}
