import java.util.*;
import java.lang.*;

class TwoPointers_2 {

    static int countPairSum(int[] A, int targetSum){
        int Alen = A.length;
        int p1 = 0;
        int p2 = Alen-1;
        int pairs = 0;
        while(p1 < p2){
            int sum = A[p1] + A[p2];
            if(sum == targetSum){
                int l = p1;
                int r = p2;
                if(A[p1] == A[p2]){
                    int count = p2-p1+1;
                    pairs += (count*(count-1))/2;
                    break;
                }
                else{
                    int leftCount = 0;
                    int rightCount = 0;
                    while(A[l] == A[p1]){
                        leftCount++;
                        l++;
                    }
                    while(A[r] == A[p2]){
                        rightCount++;
                        r--;
                    }
                    pairs += (leftCount*rightCount);
                    p1 = l;
                    p2 = r;
                }
            }
            else if(sum > targetSum){
                p2--;
            }
            else{
                p1++;
            }
        }
        return pairs;
    }

    static int countRectangles(int[] A, int area){
        int Alen = A.length;
        int p1 = 0;
        int p2 = Alen-1;
        int pairs = 0;
        while(p1 < Alen && p2 >= 0){
            int product = A[p1] * A[p2];
            if(product < area){
                pairs += p2+1;
                p1++;
            }
            else{
                p2--;
            }
        }
        return pairs;
    }

    static int threeSumClosest(int[] A, int B){
        int ans = 0;
        int diff = Integer.MAX_VALUE;
        int Alen = A.length;
        Arrays.sort(A);
        for(int i = 0; i < Alen-2; i++){
            int p1 = i+1;
            int p2 = Alen-1;
            while(p1 < p2){
                int sum = A[i] + A[p1] + A[p2];
                if(Math.abs(B-sum) < diff){
                    diff = Math.abs(B-sum);
                    ans = sum;
                }
                if(sum > B){
                    p2--;
                }
                else{
                    p1++;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {

        //***********************************************************************************
        //Homework
        //Pair sum-2
        /* Problem Description
        Given a sorted array of integers (not necessarily distinct) A and an integer B, find 
        and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.
        Since the number of such pairs can be very large, return number of such pairs modulo 
        (109 + 7).
        Here we have to count the number of pairs that constitutes sum equal to B and as 
        mentioned the numbers can be in repeatations so we have to consider all such cases
        where a single number can be paired with two or more or more numbers can be paired with
        its repeating counter parts so array is sorted but the main concern is repeatation here
        so the observation here is suppose A = {1, 2, 3, 4, 5, 5, 5, 5, 6, 7, 8, 9, 9}; our 
        pointers p1 is at start and p2 is at end  and target sum B = 10 so the first pair itself 
        is the target sum but there is repeatation so when we find the pair we have to initialize 
        the temporary pointers l = p1 and r = p2 now both will iterate till there is a repeatation 
        and both will hold the count of the repeating elements that constitutes the pair sum now 
        take the difference of both the temporary pointers with their parent pointers p1 and p2 
        like l-p1 and p2-r will give the exact count of the repeating elements and the number of 
        pairs that can be formed with them is leftCount = l-p1 and rightCount = p2-r so the 
        total number of pairs can be given by multiplying both as suppose there are 3 1s and 4 9s 
        and target sum is 10 so each of the 1 can be paired with all 4 9s so 3*4 = 12 pairs so
        pairs += (leftCount*rightCount).
        The only case left to address is what if the pair sum have A[p1] == A[p2] means both are 
        contributing the pair sum and both elements are same now observation here is the array is 
        sorted and if both A[p1] and A[p2] are equal means they both are at same sequence of the 
        repeating number so we don't need to iterate over them instead just calculate the count
        by doing p2-p1+1 so let's say its 5 so first number can be paired with next 5-1 numbers
        and next number can be paired with its remaining successors so if it is like 5, 5, 5, 5, 5
        1st 5 is paired with next 4 5s, 2nd 5 is paires with next three 5s so it goes like 4 + 3 +
        2 + 1 unique pairs and this can be calculate with the formula (x*(x-1))/2 so for 5 same 
        numbers that contribute pair sum will form 10 such pairs.
        */
        // int[] A = {1, 2, 3, 4, 5, 5, 5, 5, 6, 7, 8, 9, 9};
        // System.out.println(countPairSum(A, 10));

        //**********************************************************************************
        //Homework
        //Another count rectangles 
        /* Problem Description
        Given a sorted array of distinct integers A and an integer B, find and return how many
        rectangles with distinct configurations can be created using elements of this array as 
        length and breadth whose area is lesser than B.
        (Note that a rectangle of 2 x 3 is different from 3 x 2 if we take configuration into view)
        Here we are given a sorted array with distinct elements and we have to find all the 
        rectangles who's area is less than B now to calcualte area we need two parameters
        length and breadth and that are given in array so in short we have to count such pairs
        who's product is less than B.
        Now this problem looks easy but there is one catch 1X2 rectangle is different from 
        2X1 rectangle so we have to also take care of reverse pairs so one thing that comes
        to mind is place two pointers at both ends and just move them towards center if the 
        product is less than B then update the counter by +2 but but but there is a catch in this
        idea too, if A[p1] = 1 and A[p2] = 9 and it is less than 24 but that means numbers before
        9 will also form pairs that is less than 24 because array is sorted so if the pair is
        valid at any point it means it constitutes p2+1 pairs in total as for 1 to 9 it has
        1x1 to 1x9 and the index at which pointer p2 will be at its +1 will give the total pairs
        so for 1 to 9 p2 is at 8 so 8+1 = 9 which is the answer for one valid position of pointers.
        The pointers will move if product is less than B then it is valid and move p1++ and if it
        is greater than B then move p2-- and for every valid pointer stop it will be p2+1 pairs
        to contribute all the pairs from the p2 to behind it.
        Still some reverse pairs are left so at a point p2 and p1 will cross each other and both
        will end at opposite ends from where they started because even after doing p2+1 still some
        pairs are left to address now everytime we were fixing the p1 and calculating the pairs and
        so on just make the same process now p2 is approaching 0 and p1 is approaching n-1 so 
        to calculate the reverse pairs now we will do the smae p2+1 and all the numbers behind 
        p2 that are forming the valid pair with p1 will be added.
        */
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(countRectangles(A, 24));

        //*********************************************************************************
        //Homework
        //3 sum
        /* Problem Description
        Given an array A of N integers, find three integers in A such that the sum is closest 
        to a given number B. Return the sum of those three integers.
        Assume that there will only be one solution.
        Here we are asked to find triplet sum such that it is closer to the given target sum
        B so it is clear we have to use 3 pointers fix one and utilise other two to search for 
        the required two numbers to constitute the sum.
        All that is fine but one thing is out of the track is closer means closer on number line
        whether is greater or smaller but with the least difference so if the exact number exist
        then return it no need to go ahead or go lower. The point here is that we need to get the
        absolute value means the pure difference between the sum of three pointers and the target 
        sum and initialize the ans to the sum only when the difference is less than previous ans
        so this goes like  sum = A[i]+A[p1]+A[p2] and diff = Integer.MAX_VALUE now if the
        Math.abs(B-sum) < diff then diff = Math.abs(B-sum) here the abs will give the exact 
        difference between two numbers so if the diff is least then update the answer and diff 
        is updated only if the new absolute difference is less than earlier.
        Now a for loop is iterated and i is fixed and the p1 and p2 pointers search in space
        i+1 to n-1 and find the sum that is closest possible to the target and this goes on till 
        i  < n-2 and the closest answer is found.
        */
        // int[] A = {-3, -1, 1, 2, 3, 5, 6, 7, 9, 11};
        // System.out.println(threeSumClosest(A, 5));

    }
}