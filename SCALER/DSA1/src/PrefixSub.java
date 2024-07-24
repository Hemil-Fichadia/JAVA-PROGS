import java.util.*;
import java.lang.*;

class PrefixSub{

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

    public static void main(String[] args){
        int[][] B = {
                {1, 2, 10},
                {2, 3, 20},
                {2, 5, 25}
        };
        int A = 5;
        int[] ans = moneyInBeggarsPot(A, B);
        System.out.println(Arrays.toString(ans));
    }

}
