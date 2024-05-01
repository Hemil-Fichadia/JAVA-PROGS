import java.util.*;
import java.lang.*;

import java.util.Scanner;

class TwoPointers_3 {

    static int countUniquePairDiff(int[] A, int targetDiff){
        if(targetDiff < 0){
            targetDiff *= -1;
        }
        int Alen = A.length;
        int p1 = 0;
        int p2 = 1;
        int pairs = 0;
        while(p2 < Alen){
            int diff = A[p2] - A[p1];
            if(diff == targetDiff){
                pairs++;
                int first = p1;
                while(p1 < Alen && A[first] == A[p1]){
                    p1++;
                }
                int second = p2;
                while(p2 < Alen && A[second] == A[p2]){
                    p2++;
                }
            }
            else if(diff < targetDiff){
                p2++;
            }
            else{
                p1++;
                if(p1 == p2){
                    p2++;
                }
            }
        }
        return pairs;
    }

    static ArrayList<ArrayList<Integer>> zeroSumTriplets(int[] A){
        int Alen = A.length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i < Alen-2; i++){
            if(i > 0 && A[i-1] == A[i]){
                continue;
            }
            int p1 = i+1;
            int p2 = Alen-1;
            while(p1 < p2){
                int sum = A[i] + A[p1] + A[p2];
                if(sum == 0){
                    ArrayList<Integer> triplet = new ArrayList<>();
                    triplet.add(A[i]);
                    triplet.add(A[p1]);
                    triplet.add(A[p2]);
                    ans.add(triplet);
                    int previous = A[p1];
                    while(A[p1] == previous && p1 <= p2){
                        p1++;
                    }
                }
                else if(sum < 0){
                    p1++;
                }
                else{
                    p2--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        //*********************************************************************************
        //Homework
        //Pairs with given differences
        /* Problem Description
        Given an one-dimensional integer array A of size N and an integer B.
        Count all distinct pairs with difference equal to B.
        Here a pair is defined as an integer pair (x, y), where x and y are both numbers in
        the array and their absolute difference is B.
        Here we are asked to find all the unique pairs that have the given difference now unique
        here means in terms of elements not in terms of index so we have to skip all the elements
        that are repeating so if a pair is found then we have to skip all the numbers ahead that
        are as same as first occurring pairs and if the p1 == p2 then incremenet p2 once and
        p2 < Alen.
        */
        // int[] A = {1, 1, 1, 2, 3, 3, 3, 4, 5, 5, 5, 6, 6, 6, 7};
        // System.out.println(countUniquePairDiff(A, 2));

        //*******************************************************************************
        //Homework
        //3 sum zero
        /* Given an array A of N integers, are there elements a, b, c in S such that
        a + b + c = 0
        Find all unique triplets in the array which gives the sum of zero.
        Note:
        Elements in a triplet (a,b,c) must be in non-descending order. (ie, a <= b <= c)
        The solution set must not contain duplicate triplets.
        We have to return a 2d arraylist that have all the unique triplets that constitutes
        0 sum and for that we are using the pointers technique here. First of all we will
        fix one pointer and then after that all numbers would be the search space but before
        fixing any pointer we have to check for repeatation so i pointer will skip those
        repeating elements but first triplet is added as the check starts from 1st index.
        Now if the triplet is found and then its added to the list then afterwards check if
        the current p1 and p2 elements are repeating and if they are just update the pointers
        till its unique element position but the inner while loop should go till p1 <= p2 so
        it will make sure that the current p1 to p2 search space has met its requirement and
        it should move the i pointer now and as we are searching for triplet our i shold stop at
        n-3 so it wil be able to form the last triplet possible.
        Here one thing is to be noted is even if the p1 and p2 position elements are repeating
        we are not updating p2 we are only updating p1 as if the p1 elements are repeating it
        will stop at a point where it is not same as previous but at that time it forming a
        new triplet even if the p2 elements are repeating and when this triplet is added to the
        list as usually the p1 pointer will get updated till it is equal to p2 and then outer
        while loop will be terminated as here p1 and p2 are not approraching each other at center
        instead p1 is approaching p2 and as we are adding all the elements, anyway it will
        form unique triplets.
        */
        int[] A = {-2, -2, -1, -1, 0, 0, 1, 1, 1, 2, 2, 2};
        ArrayList<ArrayList<Integer>> ans = zeroSumTriplets(A);
        for(int i = 0; i < ans.size(); i++){
            System.out.println(ans.get(i).get(0)+","+ans.get(i).get(1)+","+ans.get(i).get(2));
        }
    }
}
