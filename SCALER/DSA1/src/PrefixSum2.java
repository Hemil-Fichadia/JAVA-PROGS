import java.util.*;

class PrefixSum2 {

    public static int[] productArrayPuzzle(int[] A) {
        int Asize = A.length;
        int[] prefixProduct = new int[Asize];
        int[] suffixProduct = new int[Asize];

        prefixProduct[0] = A[0];
        for(int i = 1; i < Asize; i++){
            prefixProduct[i] = prefixProduct[i-1]*A[i];
        }

        suffixProduct[Asize-1] = A[Asize-1];
        for(int i = Asize-2; i >= 0; i--){
            suffixProduct[i] = suffixProduct[i+1]*A[i];
        }

        int[] ans = new int[Asize];
        for(int i = 0; i < Asize; i++){
            if(i == 0){
                ans[i] = suffixProduct[i+1];
            }
            else if(i == Asize-1){
                ans[i] = prefixProduct[i-1];
            }
            else{
                ans[i] = prefixProduct[i-1]*suffixProduct[i+1];
            }
        }
        return ans;
    }

    public static int[] sumOfEvenIndices(int[] A, int[][] B) {
        int Asize = A.length;
        for(int i = 0; i < Asize; i++){
            if(i % 2 != 0){
                A[i] = 0;
            }
        }

        int[] prefixEvenSum = new int[Asize];
        prefixEvenSum[0] = A[0];
        for(int i = 1; i < Asize; i++){
            prefixEvenSum[i] = prefixEvenSum[i-1] + A[i];
        }

        int[] ans = new int[B.length];
        for(int row = 0; row < B.length; row++){
            int start = B[row][0];
            int end = B[row][1];

            if(start == 0){
                ans[row] = prefixEvenSum[end];
            }
            else{
                ans[row] = prefixEvenSum[end] - prefixEvenSum[start-1];
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        // Your code goes here
        //This gives error
        Scanner input = new Scanner(System.in);

        //********************************************************************************
        //Homework
        //Q4. Sum of even indices
        //similar to Q4 ---> Q5. Sum of odd indices
		/* Problem Description
		You are given an array A of length N and Q queries given by the 2D array B of size Q*2. 
		Each query consists of two integers B[i][0] and B[i][1].
		For every query, the task is to calculate the sum of all even indices in the 
		range A[B[i][0]…B[i][1]].

		Note : Use 0-based indexing
		
		Here we have to find sum of even indices so I thought of modifying the main array by
		keeping the even indices elements as it is and assigning 0 to to all odd indices and
		then generating prefixSum array so that will have cumulative addition of all the even 
		elements. 
		
		*/
        // int[] A = {1, 2, 3, 4, 5, 6};
        // int Asize = A.length;
        // for(int i = 0; i < Asize; i++){
        //     if(i % 2 != 0){
        //         A[i] = 0;
        //     }
        // }

        // int[] prefixEvenSum = new int[Asize];
        // prefixEvenSum[0] = A[0];
        // for(int i = 1; i < Asize; i++){
        //     prefixEvenSum[i] = prefixEvenSum[i-1] + A[i];
        // }

        // //0 - 2
        // int ans = prefixEvenSum[2];
        // System.out.println(ans);


        //********************************************************************************
        //Homework
        //Q6. Product array puzzle
        /* Given an array of integers A, find and return the product array of 
        the same size where the ith element of the product array will be equal 
        to the product of all the elements divided by the ith element of the array.

        Note: It is always possible to form the product array with 
        integer (32 bit) values. Solve it without using the division operator.


        Input Format

        The only argument given is the integer array A.
        Output Format

        Return the product array.
        Constraints

        2 <= length of the array <= 1000
        1 <= A[i] <= 10
        For Example

        Input 1:
            A = [1, 2, 3, 4, 5]
        Output 1:
            [120, 60, 40, 30, 24]

        Input 2:
            A = [5, 1, 10, 1]
        Output 2:
            [10, 50, 5, 50]
        
        
        DETAILED EXPLANATION : -
        
        So this problem is simple and easily approachable by thinking of iterating whole array 
        and multiplying all the elements and storing it into a product variable and dividing that 
        product with each element of array resulting the ans array.
        
        But, there is a catch, the above appraoch will definitely justify the case but the approach
        is incorrect as it is mentioned here that we are not supposed to use division operator here.
        So without using division operator we have to think about dividing the elements of array
        with the calculated product from the array.
        
        So the first intution that comes into mind is, if multiply all other elements of array
        except for the ith element that is dividing the main product according to the idea then
        it exactly mimics the division operation like suppose 120 is the product of the array
        A = 1, 2, 3, 4, 5 and 120 is the product of the array so iterating over array, let's say
        we are at second element that is index 1 A[1] = 2 so ans will be 120 / 2 and this can be
        achieved without division simply by multiplying all other elements of array except for 
        the i th element.
        
        This is not prefix sum so we cannot apply any addition or subtraction formula
        
        So if we are at i th element, we need to multiply all the elements except for i that means
        product of 0 to i-1 and product of i+1 to n-1, so for product of 0 to i-1 we are suppose to 
        construct a prefixProduct array where cumulative product of the elements will be stored
        like prefixProduct of A = 1, 2, 3, 4, 5 will be Prefix product : [1, 2, 6, 24, 120]. so
        with the help of prefixProduct we can get product from 0 to i-1.
        
        In order to get the product of the elements from i+1 to n-1 it is not possible to just
        take product of those elements due to TLE and it is even not possible using prefixProduct
        array as it is prefix so here comes the need of constructing suffixProduct and that is 
        created just as prefix but the array is iterated in revrse order and elements are stored
        in revrse order like suffixProduct for A = 1, 2, 3, 4, 5 is 
        Suffix product : [120, 120, 60, 20, 5] so it goes in reverse oreder like 5 then 5*4 = 20, 
        20 * 3 = 60, 60 * 2 = 120, 120 * 1 = 120. 
        
        Now the ans for the ith index will be ans[i] = prefixProduct[i-1] * suffixProduct[i+1];
        But, there are edge cases like 0 for prefixProduct ans = suffixProduct[i+1]; and 
        n-1 for suffixProduct ans = prefixProduct[i-1];
        
        So this expression will do the same as division. At i th element, the ans is multiplication
        of numbers till i-1 and multiplication of numbers from i+1 to n-1;
        
        */
         int[] A = {1, 2, 3, 4, 5};

        // int Asize = A.length;
        // int[] prefixProduct = new int[Asize];
        // int[] suffixProduct = new int[Asize];

        // prefixProduct[0] = A[0];
        // for(int i = 1; i < Asize; i++){
        //     prefixProduct[i] = prefixProduct[i-1]*A[i];
        // }


        // suffixProduct[Asize-1] = A[Asize-1];
        // for(int i = Asize-2; i >= 0; i--){
        //     suffixProduct[i] = suffixProduct[i+1]*A[i];
        // }

        // System.out.println("Prefix product : "+Arrays.toString(prefixProduct));
        // System.out.println("Suffix product : "+Arrays.toString(suffixProduct));
         System.out.println("Product Array Puzzle : "+Arrays.toString(productArrayPuzzle(A)));


    }
}