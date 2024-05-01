package com.Hemil;

public class MaximumWealth {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {9, 1, 6},
                {3, 3, 7}
        };
        System.out.println(maximumWealth(arr));
    }

    static int maximumWealth(int[][] accounts){
        // person = row
        //account = col
        int ans = 0;
        for (int person = 0; person < accounts.length; person++) {
            int sum = 0;
            for (int account = 0; account < accounts[person].length; account++) {
                sum += accounts[person][account];
            }
            // now we have sum of accounts of person
            // check with overall ans
            if(sum > ans){
                ans = sum;
            }
        }
        return ans;
    }
}
