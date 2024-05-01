import java.util.*;
class CarryForward {

    public static int stepsToMakeUnique(int[] A) {
        int steps = 0;
        Arrays.sort(A);
        for(int index = 1; index < A.length; index++){
            if(A[index] <= A[index-1]){
                steps += A[index-1]-A[index]+1;
                A[index] = A[index-1]+1;
            }
        }
        return steps;
    }

    public static int maxProfit(final int[] A) {
        int minSoFar = A[0];
        int overallProfit = 0;
        int profitIfSoldToday = 0;

        for(int i = 1; i < A.length; i++){
            if(A[i] < minSoFar){
                minSoFar = A[i];
            }

            profitIfSoldToday = A[i] - minSoFar;

            if(overallProfit < profitIfSoldToday){
                overallProfit = profitIfSoldToday;
            }
        }
        return overallProfit;
    }

    public static int pickFromBothSides(int[] A, int B) {
        int sum = 0;
        int maxSum = 0;
        int n = A.length;

        for(int i = 0; i <= B; i++){
            System.out.print(i);
            System.out.println("//////////////////////////////////////////");
            sum = 0;

            for(int left = 0; left < i; left++){
                System.out.print(A[left]);
                System.out.println("################################");
                sum += A[left];
            }

            for(int right = n-1-B+1 + i; right < n; right++){
                System.out.print(A[right]);
                System.out.println("********************************");
                sum += A[right];
            }

            if(maxSum < sum){
                maxSum = sum;
            }
            System.out.println();
        }
        return maxSum;
    }

    public static int pickFromBothSidesOptimised(int[] A, int B){
        int sum = 0;
        int maxSum = 0;
        int n = A.length;
        for(int i = 0; i < B; i++){
            sum += A[i];
        }
        maxSum = sum;
        int left = B - 1;
        int right = n-1;
        while(left >= 0){
            sum = sum - A[left] + A[right];
            left--;
            right--;
            if(maxSum < sum){
                maxSum = sum;
            }
        }
        return maxSum;
    }

    public static void main(String args[]) {
        // Your code goes here
        //This gives error
        Scanner input = new Scanner(System.in);

        //********************************************************************************
        //Homework
        //Q5. Unique Elements
        /* You are given an array A of N elements. You have to make all elements unique. 
        To do so, in one step you can increase any number by one.
        Find the minimum number of steps. 
        Return the minimum number of steps required to make all elements unique.
        
        I mentioned this array as this was not satisfied by my logic and so I asked for help.
        Ex: A = [1, 1, 2, 2, 3, 3]
        
        The SCALER TA gave the ans to this problem and it is just great.
        Here in this problem we have to make all the elements unique and for that we can
        increment any number by one in one step.
        So for that all the numbers should be in ascending order so we can analyze it in 
        a approachable way. So we need to sort the array using Arrays.sort(A) as sorting is 
        not yet taught. 
        
        Now as the array is sorted in ascending order we can expect one thing is that the 
        current number is bigger than previous number and if it is not that means we need to 
        manipulate it such a way that all numbers are unique and if all the numbers are unique,
        that means they would be in increasing order.
        
        So for that we need to check if the current number is less than or equal <= to the
        previous number and if it is true than first we will increase the  
        step counter = A[i-1] - A[i] + 1; 
        which means current number is smaller than prevoius number
        and here the steps increase according to the difference between current and previous 
        number + 1 which means if current num = 2 and prev num = 2 so current number will
        be updated to (prevoius number/A[i-1] + 1) so it automatically staisfies the increasing order
        and also becomes unique and steps are increased according to the differnce and so here in 
        this case it is 2 - 2 + 1 as  step counter = A[i-1] - A[i] + 1; and if current number is
        3 and previous number is 5 so current number is updated to 5 + 1 = 6; and steps are increased
        as 5 - 3 + 1 = 3 as this +1 is for making current number  1 higher than the previous number
        and then only it will become unique as if the current number is 3 and previous number is
        5 so in order to make 3 to 6 we need 3 steps so that element becomes unique.
        */
        // int[] A = {1, 1, 2, 2, 3, 3};
        // System.out.println(stepsToMakeUnique(A));




        //********************************************************************************
        //Homework
        //Q1 Best Time to Buy and Sell Stocks I
        //Carry Forward
        /* Problem Description
        
           Say you have an array, A, for which the ith element is 
           the price of a given stock on day i.
           If you were only permitted to complete at most one 
           transaction (ie, buy one and sell one share of the stock), 
           design an algorithm to find the maximum profit.

           Return the maximum possible profit.
           
           So this solution is given by SCALER TA, and it is just great.
           Starting from the top, he declared minSoFar = Integer.MAX_VALUE so that itself is the
           greatest value and compared to it all are smaller, but I experimented and initialised
           it with A[0] as this works fine and in that way I managed to reduce one iteration.
           
           Then he declared two profit variables one with overall value and other with profit 
           if sold on that day. So the iteration of my code starts from 1, and it checks if the
           previous element is less than it and if it is updated to current value. 
           
           Now profitIfSoldToday is calculated as current value - minSoFar and it is compared with
           overall profit if profitIfSoldToday is more than the overall profit than it is updated to it.
           
           In this way it eliminates the need of nested for loop and this is the better way of taking
           one element from array and comparing it with other values of array without using nested for loop
           
           
         */
        // int[] A = {7, 6, 4, 3, 1};
        // int[] A = {100, 5, 20, 1, 3};
        // System.out.println(maxProfit(A));



        //********************************************************************************
        //Assignment 
        //Q6 pick from both sides 
        /* You are given an integer array A of size N.

        You have to perform B operations. In one operation, 
        you can remove either the leftmost or the rightmost element of the array A.

        Find and return the maximum possible sum of the elements 
        that were removed after B operations.

        NOTE: Suppose B = 4, and array A contains 10 elements, then

        You can remove the first four elements or can remove the last four elements, 
        or can remove 1 from front and 3 from the back, etc. 
        You need to return the maximum possible sum of elements you can remove. 
        
        To build the intuition, I used special characters like // ** and ##.
        
        Here the intuition is, to return maximum possible sum by removing B elements in any
        combination say from either of the sides or combining both sides.
        
        So for that I iterated a main for loop that is denoting the count of left elements and
        inside that for loop I made two sub loops which actually denotes elements from and left 
        and the right of the array.
        
        The left sub loop and the right sub loop are in synchronisation with the outer main i loop.
        So as the count of main loop increases, gradually left increases and right decreases and in
        this way I achieved all the combinations of left, right and combined and compared in oreder
        to get the max possible sum.
        
        I used nested for loop as I was confident about iterations were going to maximum of B+1 so 
        irrespective the size of array, my solution works fine.
        
        so the first sub loop
        */

        //I have written the detailed solution
        // int[] A = {2, 3, -1, 4, 2, 1};
        // System.out.println(pickFromBothSides(A, 4));
        //My earlier solution was missing this case
        // int[] A = {2, 3, 4, 3, 4, 4, 1};
        // System.out.println(pickFromBothSides(A, 6));

        //Optimised solution
        int[] A = {2, 3, 4, 3, 4, 4, 1};
        System.out.println(pickFromBothSidesOptimised(A, 6));



    }
}