import java.util.*;

class DSAFirst {

    // public static int[] solve(final int[] A) {
    //     int left = 0;
    //     int right = A.length-1;
    //     while(left <= right){
    //         int temp = A[left];
    //         A[left] = A[right];
    //         A[right] = temp;
    // 		left++;
    // 		right--;
    //     }
    //     return A;
    // }
    public static int[] revArrayInRange(int[] A, int s, int e){
        int left = s;
        int right = e;
        int temp = 0;
        while(left < right){
            temp = A[left];
            A[left] = A[right];
            A[right] = temp;
            left++;
            right--;
        }
        return A;
    }
    public static int[] rotateArray(int[] A, int B) {
        int n = A.length;
        // B = B % n;
        revArrayInRange(A, 0, n-1);
        revArrayInRange(A, 0, B-1);
        revArrayInRange(A, B, n-1);
        return A;
    }


    public static int isPerfectNumber(int A) {
        int sum = 0;
        for(int i = 1; i < A; i++){
            if(A % i == 0){
                sum += i;
            }
        }
        if(A == sum){
            return 1;
        }
        return 0;
    }

    public static int countFactors(int A) {
        int count = 0;
        for(int i = 1; i*i <= A; i++){
            if(A % i == 0){
                if(i == A/i){
                    count += 1;
                }
                else{
                    count += 2;
                }
            }
        }
        return count;
    }

    public static int isPrime(long A) {
        if(A == 1){
            return 0;
        }
        for(long i = 2; i*i <= A; i++){
            if(A % i == 0){
                return 0;
            }
        }
        return 1;
    }

    public static int countThePrimes(int A) {

        int primeCount = 0;
        if(A == 0 || A == 1){
            return 0;
        }
        else{

            for(int num = 2; num <= A; num++){
                boolean isPrime = true;
                for(int i = 2; i < num; i++){
                    if(num % i == 0){
                        isPrime = false;
                    }
                }
                if(isPrime){
                    primeCount++;
                }
            }
        }
        return primeCount;
    }

    public static int[] rangeSumQuery(int[] A, int[][] B) {
        int[] ans = new int[B.length];
        int sum = 0;
        int index = 0;
        for(int row = 0; row < B.length; row++){
            int start = B[row][0];
            int end = B[row][1];
            sum = 0;
            for(int i = start; i <= end; i++){
                sum += A[i];
            }
            ans[index] = sum;
            index++;
        }
        return ans;
    }

    public static int countOfElements(int[] A) {

        int max = A[0];
        for(int index = 0; index < A.length; index++){

            if(max < A[index]){
                max = A[index];
            }
        }

        int count = 0;
        for(int index = 0; index < A.length; index++){
            if(A[index] < max){
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        // Your code goes here
        //This gives error
        Scanner input = new Scanner(System.in);

        //********************************************************************************
        // int[] A = {1, 2, 3, 4, 5, 6};

        // System.out.println(Arrays.toString(rotate(A, 2)));
        // revArray(A, 0, A.length-1);
        // System.out.println(Arrays.toString(revArray(A, 0, A.length-1)));



        //********************************************************************************
        //Q4. Count of elements
        /*You are given an integer A. You have to tell whether it is a perfect number or not.

        Perfect number is a positive integer which is equal to the sum of its proper 
        positive divisors.

        A proper divisor of a natural number is the divisor that is strictly less than 
        the number. 
        
        Input 2:
        A = 6
        
        Explanation 2:
        For A = 6, the sum of its proper divisors = 1 + 2 + 3 = 6, is equal to 6. 
        
        Output 2: 1 
        */
        // System.out.println(isPerfectNumber(6));


        //********************************************************************************
        //Assignment
        //Q1. Count Factors - 2
        /*Given an integer A, you need to find the count of it's factors.

        Factor of a number is the number which divides it perfectly leaving no remainder.

        Example : 1, 2, 3, 6 are factors of 6  */
        // System.out.println(countFactors(6));



        //********************************************************************************
        //Assignment
        //Q2. IsPrime
        /* Given an Integer A. Return 1 if A is prime and return 0 if not. */
        // System.out.println(isPrime(13));


        //********************************************************************************
        //Assignment
        //Q3. Reverse in a range
        /* Given an array A of N integers. Also given are two integers B and C. 
           Reverse the array A in the given range [B, C] 
         */
        // int[] A = {1, 2, 3, 4, 5, 6};
        // System.out.println(Arrays.toString(revArrayInRange(A, 1, 4)));



        //********************************************************************************
        //Assignment
        //Q5. Array Rotation
        /* Given an integer array A of size N and an integer B, 
           you have to return the same array after rotating it B times towards the right.
           
           Example Input
            Input 1:
            A = [1, 2, 3, 4]
            B = 2
            
            Example Explanation
            Explanation 1:
            Rotate towards the right 2 times - [1, 2, 3, 4] => [4, 1, 2, 3] => [3, 4, 1, 2]
            
            Example Output
            Output 1:
            [3, 4, 1, 2]
         */
        // int[] A = {1, 2, 3, 4, 5, 6};
        // System.out.println(Arrays.toString(rotateArray(A, 2)));



        //********************************************************************************
        //Homework
        //Q1. Find Perfect Numbers
        /* You are given an integer A. You have to tell whether it is a perfect number or not.

        Perfect number is a positive integer which is equal to the sum of its proper positive 
        divisors.

        A proper divisor of a natural number is the divisor that is strictly less than the number. 
        */
        // System.out.println(isPerfectNumber(6));


        //********************************************************************************
        //Homework
        //Q2. Count of primes
        /*You will be given an integer n. You need to return the count of prime numbers 
          less than or equal to n. 
          
          Example Input
            Input 1: 19
            Input 2: 1
            
          Example Explanation
            Explanation 1: Primes <= 19 are 2, 3, 5, 7, 11, 13, 17, 19
            Explanation 2: There are no primes <= 1 
            
          Example Output
            Output 1: 8
            Output 2: 0
         */
        // System.out.println(countThePrimes(13));



        //********************************************************************************
        //Homework
        //Q3. Range Sum Query - II
        /*  You are given an integer array A of length N.
            You are also given a 2D integer array B with dimensions M x 2, where each 
            row denotes a [L, R] query.
            For each query, you have to find the sum of all elements from L to R indices 
            in A (0 - indexed).
            More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query. 
            
            
            Here array B is a 2d array and it have the dimensions of M X 2 that means it will
            have exactly 2 columns and variable rows. So each of the rows of array B represents
            a range of  index that we have to access from array  in order to calculate sum.
            we have to return an array of size M with each elements representing sum of given
            range. for ex : first row of B is [0, 3] so add all the elements from 0 to 3 of 
            array A and add to ans array.
        */
        // int[] A = {1, 2, 3, 4, 5};
        // int[][] B = {
        //             {0, 3},
        //             {1, 2}
        // };
        // System.out.println(Arrays.toString(rangeSumQuery(A, B)));


        //*****
        //********************************************************************************
        //Homework
        //Q4. Count of elements
        /* Given an array A of N integers. Count the number of elements that have 
           at least 1 elements greater than itself. 
           
           This question is somewhat difficult to understand so here we have to find the maximum
           number from the array and then compare it with all elements that it is greater than
           which elements and increment the counter for all those elements which are less than 
           the max.
        */
        // int[] A = {5, 3, 3, 5, 4, 1};
        // System.out.println(countOfElements(A));






    }
}