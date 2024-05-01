package com.company;
//Leet code question amazon cyclic sort
public class MissingNumber {
    public static void main(String[] args) {
        //here the numbers are in continuous range from 1 --> n and so cyclic sort is used
        /*here the array starts form 0 so the numbers are same as its respective index like 0 at 0th index, 1 at 1st
          index. so the correct index is considered as the number itself. */
        int [] arr = {4, 2, 0, 1};
        System.out.println(missingNumber(arr));

    }


    static int missingNumber(int[] arr){
        /*It is cyclic sort only but here the numbers are in continuous range and the number is exactly equal to its
          index.
         */
        int i = 0;
        while(i < arr.length){
            //Here correct is exactly the number itself
            int correct = arr[i];
            /*If the number at current index is less than the length of array => is arr[0] is 4 and the length of
              array is 4, than here in this situation, algorithm will search for the 4th index and that is not
              available, and it will throw an exception to array index out of bound so to avoid this error, a check
              is added that if the element at current index doesn't exceed the limit like 4th index is not there.
              so it will jump to next index because it cannot be swapped, and eventually it will be placed at its
              correct index as all other elements are having their own index.
             */
            if(arr[i] < arr.length && arr[i] != arr[correct]){
                swap(arr,i,correct);
            }
            //else it will jump to next element
            else{
                i++;
            }
        }
        //Now after this pass, the array is sorted, and now we can search for missing element.
        //case 1
        //search for first missing number
        for (int index = 0; index < arr.length; index++) {
            /*Here it is directly checked if the number at the index is equal to the index itself, and if it is not
              means we have found the missing number
            */
            if(arr[index] != index){
                return index;
            }
        }
        //case 2
        /*  If all the numbers are at their respective index except for the number at the last index, than the
        answer is the last index. Like 4 is at 3rd index so the ans is length of array is 3.
         */
        return arr.length;
    }


    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
