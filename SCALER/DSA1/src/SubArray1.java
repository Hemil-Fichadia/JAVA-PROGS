import java.util.*;

class SubArray1 {

    public static ArrayList<ArrayList<Integer>> storeAllSubArrays(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();

        int n = A.size();
        for(int start = 0; start < n; start++){
            for(int end = start; end < n; end++){

                ArrayList<Integer> col = new ArrayList<>();

                for(int iterate = start; iterate <= end; iterate++){
                    col.add(A.get(iterate));
                }

                ansList.add(col);
            }
        }
        return ansList;
    }

    public static long maxSubArraySum(int[] A) {
        int sum = A[0];
        int mainSum = A[0];
        int n = A.length;
        for(int start = 0; start < n; start++){
            for(int end = start; end < n; end++){
                sum = 0;
                for(int iterate = start; iterate <= end; iterate++){
                    sum += A[iterate];
                }
                if(mainSum < sum){
                    mainSum = sum;
                }
            }
        }
        return mainSum;
    }

    public static long allSubArraySum(int[] A) {
        int n = A.length;
        long sum = 0;
        for(int i = 0; i < n; i++){
            long occurrence = (long)(i + 1) * (long)(n - i);
            sum += occurrence * A[i];
        }
        return sum;
    }

    public static void main(String args[]) {
        // Your code goes here
        //This gives error
        Scanner input = new Scanner(System.in);


        // int[] A = {2, 8, -1, 4};
        // //Printing sum of all the possible sub-array sums.
        // int n = A.length;
        // int sum = 0;
        // int totalSum = 0;
        // for(int start = 0; start < n; start++){
        //     sum = 0;
        //     for(int end = start; end < n; end++){
        //         sum += A[end];
        // 		totalSum += sum;
        //     }
        // }
        // System.out.println(totalSum);


        //****************************************************************************
        //Assignment
        //Q1. All Subarray
		
        /* Problem Description
			Given an integer array A of length N. Print all possible subarray.
			
		*/
        // int[] A = {1, 2, 3, 4, 5};
        // //Printing all the possible sub-arrays.
        // int n = A.length;
        // for(int start = 0; start < n; start++){
        //     for(int end = start; end < n; end++){

        //         for(int iterate = start; iterate <= end; iterate++){
        //             System.out.print(A[iterate]+" ");
        //         }
        //         System.out.println();
        //     }
        // }


        //****************************************************************************
        //Assignment
        //Q2. Generate all subarrays
		
        /* Problem Description
			You are given an array A of N integers.
			Return a 2D array consisting of all the subarrays of the array
			
			This question was also possible with 2D array but we have to create a 2d array first
			and for that we have to calculate the total rows and columns and for row n(n+1)/2
			and columns = n;
			To avoid those step I chose java jdk that have arraylist option.
		*/
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(1);
        list.add(4);
        ArrayList<ArrayList<Integer>> ans = storeAllSubArrays(list);
        for(int i = 0; i < ans.size(); i++){
            for(int j = 0; j < ans.get(i).size(); j++){
                System.out.print(ans.get(i).get(j)+" ");
            }
            System.out.println();
        }


        //****************************************************************************
        //Assignment
        //Q3. Subarray Sums
		/* Problem Description
			Given an integer array A of length N. Print array of numbers in which each element 
			is sum of a subarray. 
		*/
        //int[] A = {1, 2, 3, 4, 5};
        //int n = A.length;
        //int sum = 0;
        //for(int start = 0; start < n; start++){
        //     for(int end = start; end < n; end++){
        //        sum = 0;
        //        for(int iterate = start; iterate <= end; iterate++){
        //            sum += A[iterate];
        //        }
        //        System.out.print(sum+" ");
        //    }
        //}


        //****************************************************************************
        //Assignment
        //Q4. Maximum subarray sum
		/* Problem Description
			Given an array A of length N, Find the maximum subarray sum out of all 
			possible non-empty subarray.
		*/
        // int[] A = {1, 2, 3, 4, 5};
        // System.out.println(maxSubArraySum(A));


        //****************************************************************************
        //Assignment
        //Q5. Sum of All Subarrays
		/* You are given an integer array A of length N.
		    You have to find the sum of all subarray sums of A.
			More formally, a subarray is defined as a contiguous part of an array which 
			we can obtain by deleting zero or more elements from either end of the array.
			A subarray sum denotes the sum of all the elements of that subarray.
		*/
        //int[] A = {1, 2, 3, 4, 5};
        //System.out.println(allSubArraySum(A));



    }
}