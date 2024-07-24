import java.util.*;
import java.lang.*;

class Contest2 {

    public static int busDilemma(int[] A, int B) {
        int ways = 0;
        int Alen = A.length;
        int[] prefixSum = new int[Alen];
        prefixSum[0] = A[0];
        int min = prefixSum[0];
        int max = prefixSum[0];
        for(int i = 1; i < Alen; i++){
            prefixSum[i] = prefixSum[i-1] + A[i];
            if(max < prefixSum[i]){
                max = prefixSum[i];
            }
            if(min > prefixSum[i]){
                min = prefixSum[i];
            }
        }

        int minStart = 0;
        int maxStart = 0;
        // minStart = -1 * min;
        // if(minStart < 0){
        //     minStart = 0;
        // }
        if(min >= 0){
            minStart = 0;
        }
        else{
            minStart = -1 * min;
        }
        maxStart = B - max;
        if(maxStart > B){
            maxStart = B;
        }

        if(minStart > B || maxStart < 0){
            return 0;
        }
        return maxStart - minStart + 1;
    }

    public static void main(String[] args){
        //****************************************************************************
        //Bus Dilemma
        /* Problem Description
            A bus travels to N different stops, and at each stop some amount of people get 
            in and get out. 
            You are given an array A, where integer A[i] gives the amount of people who have 
            got onto the bus (if positive), or the amount of people who have gotten off the 
            bus (if negative) at the stop i.
            You are also given a positive integer B, that denotes the capacity of the bus, that 
            is the maximum number of people the bus can hold. The bus can hold 0 to B number of
            people at any time.
            Initially, the bus can have some number of people inside of it, you have to find the 
            total number of possible ways of how many people were initially in the bus before the 
            first stop, such that at any time there are always 0 to B number of people in the bus.
            If it is not possible to find any valid number of ways, return 0.
            
            Here we have to find that how many people were there before the starting of the trip.
            At first glance it feels like it is totally impossible to get that, but there is a 
            constraint that bus capacity is given that means at any point there cannot be more
            people in bus than capacity so we just need to trace the total possible ways that we
            can fill the bus initially is that 0 or 1 or 2 or 3 people that gives us 4 ways we can 
            fill the bus inintially. 
            
            Here the most important observation is that we need to get least no of people we 
            can start with and max no of people we can start and maxStart - minStart + 1 will
            give the possible no of ways.
            
            First we need to make prefixSum array so that we can get the information of no of 
            people at each stop and from that we are going to find no of people we can insert 
            in bus in all possible ways initially before start of the trip for that we need to
            obsereve in prefixSum array the max and min values. 
            
            Observation with MIN value in prefixSum array:-
            The min value in prefixSum array gives us the idea that what the least amount of 
            people we need at start like if the min value is positieve that means it is not 
            hitting edge cases and if the value is negative that means atleast that many people
            in positive are required initially.
            
            Observation with MAX value in prefixSum array:-
            Form the max value we can get maxStart = B - max that means it won't exceed the limit
            
            Quite a few obseravtions are left now:-
            Now for min value if the min value positive we will assign the minStart as 0 and if the 
            min value is negative then we will make it positive by mulitplying it with -1 so in 
            short - if(min >= 0){
                    minStart = 0;
                    }
                    else{
                        minStart = -1 * min;
                    }
            But in this porcess there is catch that if the value is negative and we converted it total
            positive and that exceeds the limit of bus that means we cannot get the min no of people 
            with we can start and solution is not possible for this case or given array.
            similarly for max value, we get maxStart = B - max and so if the maxStart exceeds
            the limit B then we will re-assign it with B in short - maxStart = B - max;
                                                                    if(maxStart > B){
                                                                        maxStart = B;
                                                                    }
            Here it is max that means max but we can operate inside its range so we assign it 
            B and make the maxStart = B; but if the max is positive and it is greater than B 
            so it will make maxStart as negative and we cannot start with negative value of people
            that is not possble logically so for that case solution is not possible in short-
            if(minStart > B || maxStart < 0){
                return 0;
            }
            
            If every thing is fine then return maxStart - minStart + 1;
        */
        int[] nums = {2, 3, -1, 2};
        int bus = 10;
        System.out.println(busDilemma(nums, bus));
    }
}