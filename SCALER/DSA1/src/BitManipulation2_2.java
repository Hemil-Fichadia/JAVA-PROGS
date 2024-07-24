import java.util.*;
import java.lang.*;


class BitManipulation2_2 {

    public static int toggleIthBit(int A, int B) {
        A = A ^ (1<<B);
        return A;
    }

    public static long unsetBitsFromRight(long A, int B) {
        for(int i = 0; i < B; i++){
            A = A & ~(1 << i);
        }
        return A;
    }

    public static long reverseBits(long A) {
        long ans=0;
        for(int i=0;i<32;i++){

            if( (A & (1L<<i)) == 1){

                ans=ans|1L<<(31-i);

            }
        }
        return ans;
    }

    public static void main(String[] args){

        //****************************************************************************
        //Homework
        //Q1 Toggle i-th bit
        /* In this problem we have to toggle the i-th bit and for that we can use ^ exor with
           1 as EXOR ^ returns 0 if the numbers are same and returns 1 if numbers are different
           so we can create a mask that has i-th bit as 1 and just exor it with A so it will 
           toggle i-th bit.
        */
        // int num = 28;
        // System.out.println(toggleIthBit(num, 3));

        //****************************************************************************
        //Homework
        //Q2 Unset x bits from right
        /* Here we need to unset xbits from right side so we will iterate a loop that has
           x iterations and at each step we will handle one bit at a time but we know that 
           if we & 0 with any bit it will result to 0 so we have to make mask at each iteration 
           that has i-th bit as 0 so first we will left shift 1 i times and just take 
           compliment of it so the mask would look like 1111101 in this way 0 will shift to left 
           all the x bits will be unset.
        */
        // long num = 46;
        // int bits = 4;
        // System.out.println(unsetBitsFromRight(num, bits));


        //****************************************************************************
        //Homework
        //Q3. Reverse Bits
        /* Here we have to reverse the whole bit arrangement like if the number was 1101010
        so the reverse would be 0101011 and here it is provided that it is a 32 bit unsigned
        integer means the integer is of 32 bit but the msb is always signed means it represents
        that number is positieve or negative 0 or 1 respectively so actually there are 31 bits 
        left for integer but here it is provided 32 bits unsigned integer means we have to use
        long that is of 64 bits so it will cover the 32 bits range and we will build logic of 
        32 bits and reverse in that range only.
        
        For reversing the bits, here we will iterate and check from lsb that it is not zero and
        set the bit from right most position in answer that would be 31-i as 0 to 31 have 32
        bits. Now we have to create a mask that returns 0 or other values so we will left shift
        1 at each iteration so i will represent numbers from 0 to 31 so 1<<i at each iteration
        and if that result to 0 that means the bit at ith position is 0 so we will leave it 
        and if the result is non-zero that means it is 1 and we will set 31-i th bit that will set
        bits from right and we will get our reversed result.
        
        we can also implement logic of A & (1<<i) == 1; as here the mask is like 0000100 so 
        it will result 1 or 0;
        */
        long num = 1;
        System.out.println(reverseBits(num));
    }
}