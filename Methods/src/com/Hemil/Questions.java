package com.Hemil;

import java.util.Scanner;

public class Questions {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number to check whether it is prime or not: ");
        int num = input.nextInt();
        boolean ans = isPrime(num);
        System.out.println(ans);


        /*for (int i = 100; i < 10000; i++) {
            if(isArmstrong(i))
            {
                System.out.print(" "+i);
            }
        }*/
    }

    static boolean isArmstrong(int num)
    {
        int numcheck = num;
        int num2;
        int sum = 0;
        int rednum = num;
        int len = 0;
        while(num > 0)
        {
            num = num / 10;
            len++;
        }

        while(numcheck > 0)
        {
            num2 = numcheck % 10;
            sum = (int) (sum + Math.pow(num2,len));
            numcheck = numcheck / 10;

        }
        return rednum == sum;
    }

    //isPrime
    static boolean isPrime(int num) {
        if(num <= 1)
        {
            return false;
        }

        int count = 2;
        while(count * count <= num)
        {
            if(num % count == 0)
            {
                return false;
            }
            count++;
        }

        return count * count > num;
    }
}
