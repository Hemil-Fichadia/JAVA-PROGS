package com.Hemil;

public class EvenDigits {
    public static void main(String[] args) {
        int[] arr = {12, 1, 343, 56, 7896};
        int ans = findNumbers(arr);
        System.out.println(ans);
        System.out.println(countDigits(345678));
    }

    static int findNumbers(int[] nums){
        int count = 0;
        for(int num : nums){
            if(even(num)){
                count++;
            }
        }
        return count;
    }

    static boolean even(int num) {
        /*int count = 0;
        while(num > 0){
            num = num / 10;
            count++;
        }
        return count % 2 == 0;*/
        return ((int)(Math.log10(num)) + 1)%2 ==0;
    }

    /*This function returns length of the given number, as
    * log10() gives the near or less than the length of the given number so
    * adding 1 to it and type casting it to integer gives our required answer.*/
    static int countDigits(int num){
        if(num < 0){
            num = num * -1;
        }
        return (int)(Math.log10(num)) + 1;
    }
}
