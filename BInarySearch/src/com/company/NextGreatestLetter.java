package com.company;

public class NextGreatestLetter {
    public static void main(String[] args) {
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        char target = 'd';
        char ans = nextGreatestLetter(letters, target);
        System.out.println(ans);

    }

    static char nextGreatestLetter(char[] letters, char target){
        int start = 0;
        int end = letters.length-1;


        while(start <= end){
            // find the middle index
            //here addition of start and end can generate a number possible out of range of integer
            int mid = start + (end - start) / 2;

            if(target < letters[mid]){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }

        }
        System.out.println(start);
        System.out.println(start % letters.length);

        /*This modulo operation is done for the sake of wrapping of array around itself so if the letter greater
        * than the greatest letter of array is expected, then the modulo of the start when the condition is
        * violated is one ahead of end/mid, so it is basically length of the array so its modulo will
        * automatically return 0 so the starting element is the answer*/

        /*Now suppose if the element is targeted, and the answer is one ahead of it which is 'e', so the search
        * will begin, and the logic applied here will make sure that the target greater than or equal to mid
        * is always incremented by 1 so when the search reaches at d it will automatically increase the start
        * by 1 so while loop condition is violated and now the start would be as expected one ahead of the ending
        * element d so 4 it is and 4 % 6 = 4 as 4 divided by 6, remainder is 4 so any index lesser than the
        * length of array will return the start index element itself but if the start is itself stopped at
        * length of array then it will return 0th element*/
        return letters[start % letters.length];
    }
}
