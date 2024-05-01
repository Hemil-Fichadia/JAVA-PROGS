import java.util.*;
import java.lang.*;

class TwoPointers_1 {

    static boolean checkPairSum(int[] A, int target){
        int Alen = A.length;
        int p1 = 0;
        int p2 = Alen-1;
        while(p1 < p2){
            int sum = A[p1] + A[p2];
            if(sum == target){
                return true;
            }
            else if(sum > target){
                p2--;
            }
            else{
                p1++;
            }
        }
        return false;
    }

    static boolean checkPairDiff(int[] A, int target){
        if(target < 0){
            target *= -1;
        }
        int Alen = A.length;
        int p1 = 0;
        int p2 = 1;
        while(p2 < Alen){
            int pairDiff = A[p2] - A[p1];
            if(pairDiff == target){
                return true;
            }
            else if(pairDiff > target){
                p1++;
                if(p1 == p2 &&  p2 < Alen){
                    p2++;
                }
            }
            else{
                p2++;
            }
        }
        return false;
    }

    static int waterLogging(int[] h){
        int len = h.length;
        int p1 = 0;
        int p2 = len-1;
        int water = 0;
        while(p1 < p2){
            int height = Math.min(h[p1], h[p2]);
            int width = p2-p1;
            water = Math.max(water, height*width);
            if(h[p1] < h[p2]){
                p1++;
            }
            else{
                p2--;
            }
        }
        return water;
    }

    static int findMinDifference(int[] A, int[] B, int[] C){
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int Alen = A.length;
        int minDiff = Integer.MAX_VALUE;
        while(p1 < Alen && p2 < Alen && p3 < Alen){
            int max = Math.max(A[p1], Math.max(B[p2], C[p3]));
            int min = Math.min(A[p1], Math.min(B[p2], C[p3]));
            int diff = max - min;
            if(diff < minDiff){
                minDiff = diff;
            }
            if(A[p1] < B[p2] && A[p1] < C[p3]){
                p1++;
            }
            else if(B[p2] < C[p3]){
                p2++;
            }
            else{
                p3++;
            }
        }
        return minDiff;

    }

    public static void main(String args[]) {

        //*********************************************************************************
        //Introduction to two pointers
        /*Two pointer simply means two variables storing indexes, and we have to utilise them
        in such a way that you can get your desired output. There are many ways we can 
        manipulate two pointers accordingly but one thing is necessary like some relation
        some distinct calculation is required as we cannot just initialize anywhere, we need
        to be certain about it as the simplest it looks creepier it gets with increasing
        toughness of problem.
        */

        //**********************************************************************************
        /*Given a sorted array check if there exist a pair(i,j) such that i != j and 
        a[i] + a[j] = k. There are some techniques that can be applied to this question
        like brute force trying out all the pairs with O(n^3) time complexity then using
        hashing it goes like O(n) time complexity and with space complexity O(n) but with two
        pointers it can be done with O(n) time complexity and O(1) space complexity.
        */
        // int[] A = {-3, 0, 1, 3, 6, 8, 11, 14, 18, 25};
        // System.out.println(checkPairSum(A, 0));

        //**********************************************************************************
        /*Check pair difference where pair(i, j) i != j, A[i] - A[j] = k, where k can be 
        anything means k > 0, k = 0 or k < 0. Using two pointers technique we have to check
        whether there exist a pair with given difference. This time we have to initialize the 
        pointers at first and second index respectively as we are checking the difference and
        if the difference asked is negative then just change it to positive and then search for
        the target.
        */
        // int[] A = {-3, 0, 1, 3, 6, 8, 11, 14, 18, 25};
        // System.out.println(checkPairDiff(A, -5));

        //**********************************************************************************
        //Assignment
        //Container with most water or water Logging
        /* Here we are given an array containing the heights of the wall with 0 thickness
        we have to find out the maximum amount of water that can be stored between any two 
        walls. while comparing any two walls, the walls that come in between those two can be 
        ignored or just the comparison of two walls can be kept in mind.
        As the amount of water trapped depends on the height of the wall and length between them 
        so the length between them is maximum at extreme points of array so place two pointers
        at extreme ends so place one at start and one at end now start taking the area between
        walls by simply taking the smallest among the two walls compared and multiply the distance
        between them now move the pointer with the smallest height one step towards center now 
        again take the area between two walls again move the pointer with the smallest height 
        continue till they are just one step closer to each other means while(p1<p2).
        */
        // int[] height = {3, 5, 4, 7, 3, 6, 4, 1, 2};
        // System.out.println(waterLogging(height));

        //***********************************************************************************
        /* Find the min of the given expression max(A[i],B[j],C[k]) - min(A[i],B[j],C[k])
        three arrays are given with sorted data, and we have to find the min of the given
        expression means we have to take any three numbers from arrays respectively and 
        according to expression find the minimum difference.
        We have to use three pointers here each of them starts from 0 of three arrays and then
        as we are calculating the min difference 
        */
         int[] A = {3, 14, 16, 23};
         int[] B = {-6, 23, 24, 30};
         int[] C = {-15, 15, 26, 31};
         System.out.println("The Min difference : "+findMinDifference(A, B, C));

    }
}