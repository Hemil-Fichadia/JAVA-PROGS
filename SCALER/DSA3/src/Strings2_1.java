import java.util.*;
import java.lang.*;

class Strings2_1 {

    static int longestUniqueSubString(String A){
        int p1 = 0;
        int p2 = 0;
        HashSet<Character> set = new HashSet<>();
        int Alen = A.length();
        int maxLen = 0;
        while(p2 < Alen){
            char ch = A.charAt(p2);
            if(set.contains(ch) == false){
                set.add(ch);
                p2++;
            }
            else{
                set.remove(A.charAt(p1));
                p1++;
            }
            maxLen = Math.max(set.size(), maxLen);
        }
        return maxLen;
    }

    static boolean checkPermutation(String A, String B){
        int Alen = A.length();
        int Blen = B.length();
        if(Alen != Blen){
            return false;
        }
        HashMap<Character, Integer> freqMapA = new HashMap<>();
        for(int i = 0; i < Alen; i++){
            char ch = A.charAt(i);
            if(freqMapA.containsKey(ch)){
                int value = freqMapA.get(ch);
                freqMapA.put(ch, value+1);
            }
            else{
                freqMapA.put(ch, 1);
            }
        }
        HashMap<Character, Integer> freqMapB = new HashMap<>();
        int match = 0;
        for(int i = 0; i < Blen; i++){
            char ch = B.charAt(i);
            if(freqMapB.containsKey(ch)){
                int value = freqMapB.get(ch);
                freqMapB.put(ch, value+1);
            }
            else{
                freqMapB.put(ch, 1);
            }
            int freqA = 0;
            if(freqMapA.containsKey(ch)){
                freqA = freqMapA.get(ch);
            }
            int freqB = freqMapB.get(ch);
            if(freqB <= freqA){
                match++;
            }
        }
        if(match == Alen){
            return true;
        }
        return false;
    }

    static int countPermutations(String A, String B){
        //permutations of A in B
        int Alen = A.length();
        int Blen = B.length();

        HashMap<Character, Integer> permuMap = new HashMap<>();
        for(int i = 0; i < Alen; i++){
            char ch = A.charAt(i);
            if(permuMap.containsKey(ch)){
                int value = permuMap.get(ch);
                permuMap.put(ch, value+1);
            }
            else{
                permuMap.put(ch, 1);
            }
        }

        int match = 0;
        int permutations = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for(int i = 0; i < Alen; i++){
            char ch = B.charAt(i);
            if(freqMap.containsKey(ch)){
                int value = freqMap.get(ch);
                freqMap.put(ch, value+1);
            }
            else{
                freqMap.put(ch, 1);
            }
            int freqA = 0;
            if(permuMap.containsKey(ch)){
                freqA = permuMap.get(ch);
            }
            int freqB = freqMap.get(ch);
            if(freqB <= freqA){
                match++;
            }
        }
        if(match == Alen){
            permutations++;
        }
        int start = 1;
        int end = Alen;
        while(end < Blen){
            char previous = B.charAt(start-1);
            int value = freqMap.get(previous);
            freqMap.put(previous, value-1);

            int valueB = freqMap.get(previous);
            int valueA = 0;
            if(permuMap.containsKey(previous)){
                valueA = permuMap.get(previous);
            }
            if(valueB < valueA){
                match--;
            }

            char current = B.charAt(end);
            if(freqMap.containsKey(current)){
                value = freqMap.get(current);
                freqMap.put(current, value+1);
            }
            else{
                freqMap.put(current, 1);
            }
            valueB = freqMap.get(current);
            valueA = 0;
            if(permuMap.containsKey(current)){
                valueA = permuMap.get(current);
            }
            if(valueB <= valueA){
                match++;
            }
            if(match == Alen){
                permutations++;
            }
            start++;
            end++;
        }
        return permutations;
    }

    public static void main(String[] args) {

        //*******************************************************************************
        //Find the longest sub-string with all unique characters
        /* Here we have to find the longest sub-string with all the unique characters so the
        idea that comes to mind first is generate all possible sub-strings and then insert all
        the characters in hashset the biggest size of hashset would be the answer but it is
        of O(n^3) time complexity.
        The optimization goes with two pointers both starting at 0 one stoods at it place
        another moves forward and mean time it inserts characters in hashset while storing
        all the lenghts of hashset and as soon as it finds repeatation the start pointer
        forward until the current sub-string becomes unique now again same procedure is
        followed.
        */
        // String A = "abcaabcadecbkfbcadghi";
        // String A = "abcaabcadecbkf";
        // System.out.println(longestUniqueSubString(A));

        //*******************************************************************************
        //Is it permutation
        /* Permutation means the frequency of every respective character should be same like
        A = anat and B = tana so A and B are permutation of each other. So check if A and B
        are permutation of each other.Here there is an edge case like even if the lengths are

        */
        // String A = "dabbaa";
        // String B = "abbdak";
        // System.out.println(checkPermutation(A, B));

        //******************************************************************************
        //Find permutations of A in B
        /* You are given two strings, A and B, of size N and M, respectively.
        You have to find the count of all permutations of A present in B as a substring.
        You can assume a string will have only lowercase letters.
        Here we have to find all possible parmutations of String A in String B so Blen > Alen.
        Permutations means frequency of all the characters are identical in both, string and
        sub-string because the length of A would be less than B so we have to form fix len
        sub-strings and check whether it is a permutation or not so it encouters the use of
        sliding window with permutation check.
        We checked the permutation
        */
        String A = "abacd";
        String B = "aabdcbcdaacdbadbaacdba";
        System.out.println(countPermutations(A, B));
    }
}