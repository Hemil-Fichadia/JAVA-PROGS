import java.util.*;
import java.lang.*;

class Strings2_2 {

    static String minWindow(String A, String B){
        int Alen = A.length();
        int Blen = B.length();
        HashMap<Character, Integer> permuMap = new HashMap<>();
        for(int i = 0; i < Blen; i++){
            char ch = B.charAt(i);
            if(permuMap.containsKey(ch)){
                int value = permuMap.get(ch);
                permuMap.put(ch, value+1);
            }
            else{
                permuMap.put(ch, 1);
            }
        }

        int p1 = 0;
        int p2 = 0;
        int start = -1;
        int end = -1;
        int match = 0;
        int minLen = Integer.MAX_VALUE;
        HashMap<Character, Integer> freqMap = new HashMap<>();
        while(p2 < Alen && p1 < Alen){
            char endChar = A.charAt(p2);
            if(freqMap.containsKey(endChar)){
                int value = freqMap.get(endChar);
                freqMap.put(endChar, value+1);
            }
            else{
                freqMap.put(endChar, 1);
            }

            int valueA = freqMap.get(endChar);
            int valueB = 0;
            if(permuMap.containsKey(endChar)){
                valueB = permuMap.get(endChar);
            }

            if(valueA <= valueB){
                match++;
            }

            while(match == Blen){
                int len = p2-p1+1;
                if(len < minLen){
                    minLen = len;
                    start = p1;
                    end = p2;
                }
                char startChar = A.charAt(p1);
                int value = freqMap.get(startChar);
                freqMap.put(startChar, value-1);
                valueA = freqMap.get(startChar);

                valueB = 0;
                if(permuMap.containsKey(startChar)){
                    valueB = permuMap.get(startChar);
                }
                if(valueA < valueB){
                    match--;
                }
                p1++;
            }
            p2++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = start; i <= end; i++){
            sb.append(A.charAt(i));
        }
        return sb.toString();
    }
    static ArrayList<ArrayList<Integer>> anagrams(String[] A){
        int Alen = A.length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        HashMap<String, ArrayList<Integer>> indexListMap = new HashMap<>();
        for(int i = 0; i < Alen; i++){
            char[] sortedArr = A[i].toCharArray();
            Arrays.sort(sortedArr);
            String sortedStr = Arrays.toString(sortedArr);

            if(indexListMap.containsKey(sortedStr)){
                ArrayList<Integer> indexList = indexListMap.get(sortedStr);
                indexList.add(i+1);
                indexListMap.put(sortedStr, indexList);
            }
            else{
                ArrayList<Integer> indexList = new ArrayList<>();
                indexList.add(i+1);
                indexListMap.put(sortedStr, indexList);
            }
        }

        for(String str : indexListMap.keySet()){
            ans.add(indexListMap.get(str));
        }

        return ans;
    }

    static boolean checkPalindrome(String A){
        int Alen = A.length();
        int[] freqMap = new int[26];
        for(int i = 0; i < Alen; i++){
            freqMap[A.charAt(i)-'a']++;
        }
        int odd = 0;
        for(int value : freqMap){
            if(value % 2 == 1){
                odd++;
            }
        }
        return odd <= 1;
    }

    public static void main(String[] args) {

        //*******************************************************************************
        //Window string
        /* Problem Description
        Given a string A and a string B, find the window with minimum length in A, which will
        contain all the characters in B in linear time complexity.
        Note that when the count of a character c in B is x, then the count of c in the minimum
        window in A should be at least x.
        Note:
        If there is no such window in A that covers all characters in B, return the empty string.
        If there are multiple such windows, return the first occurring minimum window ( with
        minimum start index and length )
        Here in this problem we have to find the minimum length sub-string in string A that
        contains all the characters of string B in the minimum possible length sub-string
        and with least possible index.
        Now minimum length sub-string means there can be extra characters between the required
        characters of string B in string A so we have to search for a sub-string that have the
        minimum length so the idea here is about the same match count technique of the permutation
        string question but there it was fixed length string here it is not so the algorithm
        will include the use of pointers and the logic for moving pointers goes like this,
        p1 and p2 poitners are standing at 0 of string A and now p2 moves ahead by adding
        the character and its frequency to the hashmap if the character is the required one's
        and its frequency is less than or equal to the required frequency then match++ and
        when the match is satisfied the length is noted and start and end points are stored
        in order to return string at the end.
        when the match is satisfied we try to reduce the size of the sub-string by removing
        the contribution of charAt p1. The size is reduced till the match is maintained meanwhile
        the lengths and start and end poitns are noted if the new is less than previous. As
        we are removing characters at p1 and if the valid charcater is removed the match is reduced
        and when it is reduced again p1 is fixed and p2 moves forward till next match is found
        and the same process takes palce till end of the string.
        */
        // String A = "ADOBECODEBANC";
        // String B = "ABC";
        // System.out.println(minWindow(A, B));

        //********************************************************************************
        //Anagrams
        /* Here we have to return a 2d arraylist that contains the indices of all the anagrams
        of a particular word means a word will have its separate index list that will contain
        all the indices of all its anagrams. Anagram simply means jumbled form of a particular
        word like "cat" anagram is "tac" and "act" so we have to cluster the indexes of an
        anagram and return a 2d arraylist of it.
        So a simple approach is take each string convert it to character array and sort it
        insert it in a hashmap with an arraylist containing current index similarly as we are
        sorting each string so if a word is an anagram its index would be added to the arraylist
        and hashmap will update in this way. At the end, inset all the arraylists in an ans
        arraylist and return it.
        */
        // String[] A = {"cat", "rat", "hen", "tca", "neh", "tar"};
        // ArrayList<ArrayList<Integer>> ans = anagrams(A);
        // for(int i = 0; i < ans.size(); i++){
        //     for(int j = 0; j < ans.get(i).size(); j++){
        //         System.out.print(ans.get(i).get(j)+" ");
        //     }
        //     System.out.println();
        // }

        //********************************************************************************
        //Check if palindrome
        /* Here we have given a jumbled character string, and we have to check whether the given
        string is palindrome or not. So in order to be a palindrome string either a string can
        contain all characters in even frequency or there can be atmost one odd frequency
        character like "naman" contains one odd frequency character 'm' and rest of them are of
        even frequency and "adda" contains all the characters in even frequency.
        Here I have used a fancy way of storing frequencies of the characters in an array
        instead of hashmap now we know that there are 26 alphabets in english so I have created
        a 26 size of array and in order to give index from 0 to 25 to characters 'a' to 'z' I
        have subtracted each letter with 'a' so if there is 'a' so 'a'-'a' will  result to 0
        and if there is some other character like 'k' so 'k'-'a' = 10 and the frequency of 'k'
        will be stored at that index only.
        */
        String A = "adbbd";
        System.out.println(checkPalindrome(A));
    }
}