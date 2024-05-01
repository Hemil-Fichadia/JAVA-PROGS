import java.util.*;
import java.lang.*;

class Strings1 {
    static int longestPalindrome(String A){
         int odd = 0;
         int even = 0;
         int Alen = A.length();
         for(int i = 0; i < Alen; i++){
             int p1 = i;
             int p2 = i;
             while(p1 >= 0 && p2 < Alen){
                 if(A.charAt(p1) == A.charAt(p2)){
                     p1--;
                     p2++;
                 }
                 else{
                     break;
                 }
             }
             odd = Math.max(odd, p2-p1-1);
         }

         for(int i = 0; i < Alen; i++){
             int p1 = i;
             int p2 = i+1;
             while(p1 >= 0 && p2 < Alen){
                 if(A.charAt(p1) == A.charAt(p2)){
                     p1--;
                     p2++;
                 }
                 else{
                     break;
                 }
             }
             even = Math.max(even, p2-p1-1);
         }
        return Math.max(even, odd);
    }

    static String reverseString(String A){
        StringBuilder sb = new StringBuilder(A);
        int Alen = A.length();
        int p1 = 0;
        int p2 = Alen-1;
        while(p1 < p2){
            char temp = sb.charAt(p1);
            sb.setCharAt(p1, sb.charAt(p2));
            sb.setCharAt(p2, temp);
            p1++;
            p2--;
        }
        return sb.toString();
    }

    static String toggleCase(String A){
        int Alen = A.length();
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < Alen; i++){
            char ch = A.charAt(i);
            if('a' <= ch && ch <= 'z'){
                sb.append((char)((int)ch-32));
            }
            else if('A' <= ch && ch <= 'Z'){
                sb.append((char)((int)ch+32));
            }
        }
        return sb.toString();
    }

    static String longestCommonPrefix(String[] A){
        int minLen = Integer.MAX_VALUE;
        int Alen = A.length;
        for(int i = 0; i < Alen; i++){
            int len = A[i].length();
            if(len < minLen){
                minLen = len;
            }
        }
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < minLen; i++){
            char ch = A[0].charAt(i);
            for(int j = 0; j < Alen; j++){
                if(A[j].charAt(i) != ch){
                    return sb.toString();
                }
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    static int minimizeDistinctCharacters(String A, int power){
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int Alen = A.length();
        for(int i = 0; i < Alen; i++){
            char ch = A.charAt(i);
            if(freqMap.containsKey(ch)){
                int value = freqMap.get(ch);
                freqMap.put(ch, value+1);
            }
            else{
                freqMap.put(ch, 1);
            }
        }
        ArrayList<Integer> freqList = new ArrayList<>();
        for(char ch : freqMap.keySet()){
            freqList.add(freqMap.get(ch));
        }
        Collections.sort(freqList);
        int distinct = freqMap.size();
        int index = 0;
        int len = freqList.size();
        while(power >= 0 && distinct > 1 && index < len){
            int freq = freqList.get(index);
            if(freq <= power){
                power -= freq;
            }
            else{
                break;
            }
            index++;
            distinct--;
        }
        return distinct;
    }

    static int countOccurrences(String A, String word){
        if(word.equals("")){
            return -1;
        }
        int p1 = 0;
        int p2 = 1;
        int wordLen = word.length();
        int Alen = A.length();
//        int limit = Alen-wordLen+1;
        int count = 0;
        char initial = word.charAt(0);
        int i = 0;
        while(i < Alen){
            int len = 0;
            char ch = A.charAt(i);

            if(ch == initial){
                int j = 0;
                while(j < wordLen && i < Alen){

                    if(word.charAt(j) == A.charAt(i)){
                        len++;
                        j++;
                        i++;
                    }
                    else{
                        break;
                    }
                }
                if(len == wordLen){
                    count++;
                }
            }

            i++;
        }
        return count;
    }
    public static void main(String[] args) {

        //**************************************************************************
        //Longest Palindrome
        /* Here we have to find the longest possible palindrome string in the given string
        and for that either by trying out all the combinations with the logic of generating
        all the sub arrays and then checking the reverse string will take O(n^3) time complexity.
        It needs some optimization so pointers technique will help for sure so we have two
        cases here of checking of palindrome strings there are two kind of palindrome strings odd
        and even center 1) odd cadbdac 2) even dabbad so two different configurations require different
        checking scheme and when we don't know which index is the center of a palindromic string, so we
        take all the elements as center of string and then expand in both the directions in the case of
        odd center the expansion of two pointers begins form the same point i and in the case of even
        pointer it begins from i and i+1 respectively so at the end the max of odd and even length of
        strings would be considered.
         */
//        String A = "xbdyzzydebdyzydx";
//        System.out.println(longestPalindrome(A));

        //*************************************************************************************
        //Reverse string in given range
        /* Using two pointers logic keep p1 at start and p2 at end then swap till p1 < p2 the
        string would be reversed.
        */
//        String A = "Hellow";
//        System.out.println(reverseString(A));

        //**************************************************************************************
        //Toggle case
        /* Toggle the case of the letter if its 'A' --> 'a' if its 'e' --> 'E' in the given
        string
        */
//        String A = "HelloW";
//        System.out.println(toggleCase(A));

        //******************************************************************************
        //Longest Common prefix
        /* We have given a string array, and we have to find the longest possible common
        prefix string means the string that is common from starting in all most of the
        strings and return that common string. First of all we have to find the string
        with the smallest length string as the smallest string would be the one to decide
        the common as it have the least characters so the combinations it would have justified
        the most common prefix.
        Now our answer will be the size of minLen so we will iterate on 0 to minLen and will
        take A[0] as reference string as the size is minLen and the characters matching till
        the point will fall in minLen range only so taking first string as reference and
        taking
        out one character at a time and then iterating a second loop inside it that iterate
        over
        the string array and checks the respective ith position character if it matches then
        it is added to the ans else the loop is terminated by returning the answer updated
        till then.
        So in this way we are comparing all strings in a controlled fashion and get the most
        common prefix part among the strings.
        */
        // String[] A = {"abcde, abcd, abcdefg, abcdfghi", "abcdklm"};
        // System.out.println(longestCommonPrefix(A));

        //*****************************************************************************
        //Change character
        /* Problem Description
        You are given a string A of size N consisting of lowercase alphabets.
        You can change at most B characters in the given string to any other lowercase
        alphabet such that the number of distinct characters in the string is minimized.
        Find the minimum number of distinct characters in the resulting string.
        Here we are asked to return the count of distinct characters after replacing B
        characters so as the count is asked so we don't need to replace characters just
        understand like we have to make a frequency map of the characters and if we really
        want to replace the characters then we should go for the least frequency characters and
        even replace it with the highest frequency character so the number of distinct characters
        will reduce as we can only replace cahracters so as we replace the least frequencies
        characters, it automatically merges those replaced characters to the highest frequencies
        characters and the unique characters are minimized.
        So for that we need to store all the frequencies in an array list and then sort it now
        iterate and subtract amount from B accoding to the array list elements and at the same
        time at each iteration reduce the distinct count and at the end when power to change
        characters break the while loop and return the distinct count.
        There is an edge case what if the power B is more than the total distinct characters so
        break the while loop when distinct count is at 1 because atleast 1 distinct character
        will be there at the end.
        */
//        String A = "aabbbccdd";
//        int B = 5;
//        System.out.println(minimizeDistinctCharacters(A, B));

        //********************************************************************************
        //Count occurrence
        /* Find the number of occurrence of 'bob' in given string A.
        Here we have to count the number of occurrences of word 'bob' now its simple we have
        to use three pointers p1 will move by i, p2 will move by i+1 and p3 will move by i+2
        so if p1=b p2=o and p3=b, increment the counter if the requirement is met.
        */
        String A = "Hemil is a good boy and Hemil is having a strong personality and HHHemil";
//        String A = "Hemil HHHemil";
        String word = "Hemil";
        System.out.println(countOccurrences(A, word));
    }
}
