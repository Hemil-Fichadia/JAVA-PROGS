import java.util.*;

class Contest1 {

    public static int[] maximumPositivity(int[] A) {
        int n = A.length;

        int[] modified = new int[n];
        for(int i = 0; i < n; i++){
            if(A[i] < 0){
                modified[i] = 0;
            }
            else{
                modified[i] = 1;
            }
        }

        int start = 0;
        int end = 0;
        int reqLength = 0;
        for(int i = 0; i < n; i++){
            if(modified[i] == 0){
                continue;
            }
            for(int j = i; j < n; j++){
                if(modified[j] == 0){
                    break;
                }
                else{
                    int subLength = j - i + 1;
                    if(reqLength < subLength){
                        reqLength = subLength;
                        start = i;
                        end = j;
                    }
                }


            }
        }

        int[] ans = new int[end - start + 1];
        int ansIndex = 0;
        for(int i = start; i <= end; i++){
            ans[ansIndex] = A[i];
            ansIndex++;
        }
        return ans;
    }

    public static int[] maximumPositivityOptimised(int[] A) {
        //In this solution I solved it without creating modified array
        int n = A.length;

        int start = 0;
        int end = 0;
        int reqLength = 0;
        for(int i = 0; i < n; i++){
            if(A[i] < 0){
                continue;
            }
            for(int j = i; j < n; j++){
                if(A[j] < 0){
                    break;
                }
                else{
                    int subLength = j - i + 1;
                    if(reqLength < subLength){
                        reqLength = subLength;
                        start = i;
                        end = j;
                    }
                }


            }
        }

        int[] ans = new int[end - start + 1];
        int ansIndex = 0;
        for(int i = start; i <= end; i++){
            ans[ansIndex] = A[i];
            ansIndex++;
        }
        return ans;
    }

    public static int[] maximumPositivityRamaSir(int[] A){
        int n = A.length;
        int ansStart = 0;
        int ansLen = 0;
        int i = 0;
        while(i < n){
            if(A[i] < 0){
                i++;
            }
            int start = i;
            int len = 0;
            while(i < n && A[i] >= 0){
                len++;
                i++;
            }
            if(ansLen < len){
                ansStart = start;
                ansLen = len;
            }
        }

        int ansEnd = ansStart + ansLen - 1;
        int[] ansArr = new int[ansLen];
        int index = 0;
        for(int j = ansStart; j <= ansEnd; j++){
            ansArr[index] = A[j];
            index++;
        }

        return ansArr;
    }

    public static void main(String args[]) {
        // Your code goes here
        //This gives error
        Scanner input = new Scanner(System.in);

        //****************************************************************************
        //Q3 Maximum Positivity
		/* Given an array of integers A of size N.
		   Retrun the maximum size subarray of A having only non-negative elements.
		   If there are more than one such subarray, return the one having the smallest starting
		   index in A.
		   
		   Here problem asks to return a maximum size of sub array with only non-negative numbers
		   and starting from the least index. 
		   
		   For this problem the intution I had was to get the start and end index of the 
		   sub array that is expected as output.
		   
		   So I first thought of modifying the given array but later it came to me that we need
		   to return sub array with all the elements as it is so I created a modified array 
		   where all the negative elements are stored as 0 and rest are stored as 1.
		   
		   In order to mimic all the combinations of sub array, I decided to go for nested loop
		   with i and j loop varables and iterated it over modified array if modified[i] == 0; 
		   I skipped that index as there is no sense of starting from negative element as it 
		   already fails the required condition and iterating over inner for loop that goes
		   from i till n that means it is creating all the sub array combinations, 
		   I wrote an if condition that even if the inner loop iterates over 0 that is negative 
		   element that means it is including negative so that sub array fails the requirement
		   so I break the loop else I calculated the length of current sub array by j - i + 1; 
		   and wrote an if condition that if the current length of sub array is greater than the 
		   reqLength than I updated reqLength = subLength and assigned i to start and j to end.
		   
		   If there are more such sub arrays, I will compare if its length is greater than reqLength
		   than do the same update and if not it will not change the start and end variables that are
		   found.  
		   
		   At the end I iterated from start to end and stored those elements in ans array and 
		   returned it. I was totally aware about storing of elements and for that, it is better
           to get start and end of the expected sub array insted of getting start and length,
           that's why I chose to use for loop it provides more control than while loop.
           
           Rama Krishna sir used while loop and solved it.
		*/
        int[] A = {1, 2, -3, 6, 7, 8, 9, 10, 11, -12, 13};
        int[] ans = maximumPositivity(A);
        System.out.println(Arrays.toString(ans));


        //****************************************************************************
        //Q3 Maximum Positivity
        /* Later on I realised that this can be optimised further by removing the modified array,
           the space complexity is improved.
        */
        int[] B = {1, 2, -3, 6, 7, 8, 9, 10, 11, -12, 13};
        int[] optimised = maximumPositivityOptimised(B);
        System.out.println(Arrays.toString(optimised));



        //****************************************************************************
        //Q3 Maximum Positivity
        //Rama Krishna Sir's solution.
        /*
         */
        int[] C = {1, 2, -3, 6, 7, 8, 9, 10, 11, -12, 13};
        int[] sirWay = maximumPositivityRamaSir(C);
        System.out.println(Arrays.toString(sirWay));



    }
}