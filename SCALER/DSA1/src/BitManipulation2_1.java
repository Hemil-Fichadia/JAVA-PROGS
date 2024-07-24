import java.util.*;
import java.lang.*;


class BitManipulation2_1 {
    public static int unsetIthBit(int A, int B) {
        int mask = 1<<B;
        mask = ~mask;
        return A & mask;
    }

    public static int checkBit(int A, int B) {
        if((A & (1<<B)) == 0){
            return 0;
        }
        return 1;
    }

    public static int countSetBits(int A) {
        int count = 0;

        while(A > 0){
            if((A & 1) == 1){
                count++;
            }
            A = A >> 1;
        }
        return count;
    }

    public static int setBits(int A, int B) {
        int ans = 0;
        int ans1 = 1<<A;
        int ans2 = 1<<B;
        ans = ans1 | ans2;
        return ans;
    }

    public static void main(String[] args){

        //****************************************************************************
        //Assignment
        //Q1 Unset i th bit 
        /* Unset means make it 0 if its 1 and leave it already 0.
           we know that if we "and" 0 with any bit the result is 0 so here we can do it like 
           (A >> B) & 0 by taking right shift on A by B bits and resetting that bit by & 0.
           
           Left shift and right shift operators
           This ">>" is right shift and This "<<" is left shift and this shift is done by
           only adding zeros on the left if it is right shift and adding zeros to the right if 
           it is left shift. so if 000001 if this is the number and we perform left shift << 1 
           then the resultig number would be 000010 so it moved left by 1 position and left shift
           actually means multiplying a number by 2 as many times we shift its position and 
           similarly right shift means dividing number by 2 and moving to right.
           
           So in order to unset i th bit we need to & 0 to that bit and & 1 to all other bits.
           For that I created mask by left shifting 1 i times so it wolud be something like 
           0001000 and taking compliment operator of it so that results to 1110111 and now we 
           take & with A so the relutant number would be : - 
                            1101101
                         &  1110111
                         -------------
                            1100101 <---Ans 
            While using bitwise operators & | ~ we dont need to convert to binary, it atomatically
            converts it to binary and perfrorms operation over it.
        */
        // int num = 48;
        // int bit = 4;
        // System.out.println(unsetIthBit(num, bit));

        //****************************************************************************
        //Assignment
        //Q2 Check Bit 
        /*Problem Description
            You are given two integers A and B.
            Return 1 if B-th bit in A is set
            Return 0 if B-th bit in A is unset
            
            Here we need to check B-th bit status that if it is set than return 1 and 
            0 if it is reset. So if we and 1 with any bit it will return the bit itself like
            if 1 & 0 = 0; 1 & 1 = 1; so we will create a mask of 1>>B and when we do this all 
            other bits are 0 except for 1 so in this mask the ans would be just 0 or 1.
        */
        // int num = 34;
        // int bit = 5;
        // System.out.println(checkBit(num, bit));


        //****************************************************************************
        //Assignment
        //Q3. Number of 1 Bits
        /* Count number of 1 bits in a given integer.
            In order to count no. of 1 bits, we need to iterate on number and count but for that 
            we will & 1 with the last bit and check if it is 1 or not and after that shift 
            the number to right by 1, A = A>>1 till number is greater than 0.
        */
        // int num = 37;
        // System.out.println(countSetBits(num));


        //****************************************************************************
        //Assignment
        //Q4. Set Bit
        /* In this problem we need to set A and B bits in 0 which is given as arguments.
            So easy way to do it set A bit in one number and set B bit in other number
            and or | them together in a seprate variable.
        */
        int bit1 = 6;
        int bit2 = 1;
        System.out.println(setBits(bit1, bit2));
    }
}