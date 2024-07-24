import java.util.*;
import java.lang.*;

//Unwinding a 2d rectangular matrix in spiral way
class TwoDArray1_3 {
    public static int[] unwindMatrixInClockwise(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int index = 0;
        int size = n*m;
        int[] ans = new int[size];
        int ansLen = ans.length;

        int row = 0;
        int col = 0;

        while(n > 1 && m >1){

            for(int k = 1; k < m; k++){
                ans[index] = A[row][col];
                col++;
                index++;
            }
            for(int k = 1; k < n; k++){
                ans[index] = A[row][col];
                row++;
                index++;
            }
            for(int k = 1; k < m; k++){
                ans[index] = A[row][col];
                col--;
                index++;
            }
            for(int k = 1; k < n; k++){
                ans[index] = A[row][col];
                row--;
                index++;
            }
            row++;
            col++;
            // index++;
            n -= 2;
            m -= 2;
        }
        // row--;

        if(n == 1){
            for(int k = 1; k <= m; k++){
                ans[index] = A[row][col];
                col++;
                index++;
            }
        }
        else if(m == 1){
            for(int k = 1; k <= n; k++){
                ans[index] = A[row][col];
                row++;
                index++;
            }
        }

        return ans;
    }
    public static void main(String[] args){

        int[][] A = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };
        // int[][] A = {
        //     {1},
        //     {2},
        //     {3},
        //     {4}
        // };
        int[] ans = unwindMatrixInClockwise(A);
        System.out.println(Arrays.toString(ans));

    }
}