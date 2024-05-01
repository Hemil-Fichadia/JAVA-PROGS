import java.util.*;
import java.lang.*;

class PatternMatching {

    static int[] createLPSArray(String A){
        int Alen = A.length();
        int[] lps = new int[Alen];
        lps[0] = 0;
        for(int i = 1; i < Alen; i++){
            int x = lps[i-1];
            //update the lps only when characters match so find match and do x+1.
            while(A.charAt(i) != A.charAt(x)){
                if(x == 0){
                    x = -1;
                    break;
                }
                x = lps[x-1];
            }
            lps[i] = x+1;
        }
        return lps;
    }

    static int countPattern(String A, String B){
        String comb = A+"@"+B;
        int Alen = A.length();
        int[] lps = createLPSArray(comb);
        int lpsLen = lps.length;
        int count = 0;
        for(int i = 0; i < lpsLen; i++){
            if(lps[i] == Alen){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        //*******************************************************************************
        //Pattern Matching
        /* This is the most heavy algortihm of all DSA.
        On pressing ctrl+f the search function uses this algorithm to search for a word.
        We have to determine whehter the text contains the desired pattern of string or not
        and for this there is introduction of a concept called prefix and suffix stirngs and 
        the pattern can be found with the help of this concept of generating the LPS[] array.
        Before diving into the LPS array there comes the prefix and suffix strings and as the 
        name suggests, the prefix strings start at index 0 and suffix stirngs end at n-1 index
        and so if given A = "aabaabc" the possible prefix and suffix are :-
        
        Prefix strings          ||       Suffix strings 
                                ||
        [0-0]="a",              ||       [6-6]="c",
        [0-1]="aa",             ||       [5-6]="bc",
        [0-2]="aab",            ||       [4-6]="abc",
        [0-3]="aaba",           ||       [3-6]="aabc",
        [0-4]="aabaa",          ||       [2-6]="baabc",
        [0-5]="aabaab",         ||       [1-6]="abaabc",
        [0-6]="aabaabc"         ||       [0-6]="aabaabc"
        
        So the LPS means the longest prefix that is suffix it means we have find a similar stirng
        that is prefix and and even suffix and when we think of this in mind the only thing comes
        in mind is the full string itself as at the end of generating both the strings the prefix 
        string [0-6]="aabaabc" is equal to suffix string [0-6]="aabaabc" so it is the longest
        prefix that is suffix but there is a catch, while calulating LPS we cannot consider the
        full string so the last [0-6] is ignored and the rest are considered and from that 
        we have to find the length of the longest prefix string that is suffix and that is 0
        as no strings are matching.
        
        observation-2
        String A = "aabaab"
        Prefix strings          ||       Suffix strings 
                                ||
        [0-0]="a",              ||       [5-5]="b",
        [0-1]="aa",             ||       [4-5]="ab",
        -----------------------------------------------
       | [0-2]="aab",           ||       [3-5]="aab",  | <------------ Matching length=3
        -----------------------------------------------
        [0-3]="aaba",           ||       [2-5]="baab",
        [0-4]="aabaa",          ||       [1-5]="abaab",
        ................................................
        [0-5]="aabaab",         ||       [0-5]="aabaab", <---- Ignore this 
        
        So the longest LPS here is length 3 that is "aab" and in this way we have to construct
        a LPS array that contians all the lps values till that index means if we say lps of
        ith index is 'x' it means it is lps of [0-i] by considering the rule that we cannot
        consider full string to get the lps value.
        ------------------------------------------------------------------------------
        LPS Array :- 
        lps[n] lps array would be of the same size of the given string
        String A = "aabaaba"
        
        for range s[0-0]="a"  lps[0]=0
        Prefix strings          ||       Suffix strings 
                                ||
        [0-0]="a"               ||       [0-0]="a"  <-------No match as we cannot consider full
                                                             String So lps[0]=0
        ------------------------------------------------------------------------------
        for range s[0-1]="aa"  lps[1]=1
        Prefix strings          ||       Suffix strings 
                                ||
        [0-0]="a",              ||       [1-1]="a",  <-----Match length=1 So lps[1]=1
        [0-1]="aa"              ||       [0-1]="aa"  <-----neglect the full string
        ------------------------------------------------------------------------------
        for range s[0-2]="aab"  lps[2]=0
        Prefix strings          ||       Suffix strings 
                                ||
        [0-0]="a",              ||       [2-2]="b",   
        [0-1]="aa",             ||       [1-2]="ab", <----------No Match length=0 So lps[2]=0
        [0-2]="aab"             ||       [0-2]="aab" <----------neglect the full string
        ------------------------------------------------------------------------------
        for range s[0-3]="aaba"  lps[3]=1
        Prefix strings          ||       Suffix strings 
                                ||
        [0-0]="a",              ||       [3-3]="a",  <----------Matching length=1 so lps[3]=1
        [0-1]="aa",             ||       [2-3]="ba", 
        [0-2]="aab"             ||       [1-3]="aba" 
        [0-3]="aaba"            ||       [0-3]="aaba" <----------neglect the full string
        ------------------------------------------------------------------------------
        for range s[0-4]="aabaa"  lps[4]=2
        Prefix strings          ||       Suffix strings 
                                ||
        [0-0]="a",              ||       [4-4]="a",  
        [0-1]="aa",             ||       [3-4]="aa", <----------Matching length=2 so lps[4]=2
        [0-2]="aab"             ||       [2-4]="baa" 
        [0-3]="aaba",           ||       [1-4]="abaa" 
        [0-4]="aabaa"           ||       [0-4]="aabaa" <----------neglect the full string
        ------------------------------------------------------------------------------
        for range s[0-5]="aabaab"  lps[5]=3
        Prefix strings          ||       Suffix strings 
                                ||
        [0-0]="a",              ||       [5-5]="b",  
        [0-1]="aa",             ||       [4-5]="ab", 
        [0-2]="aab"             ||       [3-5]="aab"  <----------Matching length=3 so lps[5]=3
        [0-3]="aaba",           ||       [2-5]="baab" 
        [0-4]="aabaa"           ||       [1-5]="abaab"  
        [0-5]="aabaab"          ||       [0-5]="aabaab" <----------neglect the full string
        ------------------------------------------------------------------------------
        for range s[0-6]="aabaaba"  lps[6]=4
        Prefix strings          ||       Suffix strings 
                                ||
        [0-0]="a",              ||       [6-6]="a",  
        [0-1]="aa",             ||       [5-6]="ba", 
        [0-2]="aab"             ||       [4-6]="aba"  
        [0-3]="aaba",           ||       [3-6]="aaba" <----------Matching length=4 so lps[6]=4
        [0-4]="aabaa"           ||       [2-6]="baaba"  
        [0-5]="aabaab"          ||       [1-6]="abaaba" 
        [0-6]="aabaaba"         ||       [0-6]="aabaaba" <----------neglect the full string
        -------------------------------------------------------------------------------
        So the LPS[] Array of String A = "aabaaba" is given as 
            A = "a a b a a b a"
        lps[7] = 0 1 0 1 2 3 4 <---- This the lps[] array of a given string A.
        
        Observation-3 :-
        let's say this is string assume lps value of s(i)=5
        s0 s1 s2 s3 s4 s5 ........s(i-5) s(i-4) s(i-3) s(i-2) s(i-1) s(i)..............s(n-1)
        and its given that lps value of s(i)=5 means the first five and the last five till ith 
        index are same that means the s0 to s4 are same as s(i-4) to s(i). If we want to get the 
        lps value of i-1 consider characters from s0 to s3 and s(i-4) to s(i-1) those are going 
        to be the same as well according to above s(i)=5 terminology so from this we can derive 
        that lps value of S(i-1)=4 but there is even a possiblity of s(i-5) matching with s4 so 
        that may even contribute in lps value so it would result to 5 now we don't know how many
        are going to be matching behind it can be even greater than 4 so the on the basis of 
        assumption we made, lps of s(i-1) >= 4 or lps[i-1] >= 4.
        Suppose lps[i] = x , so lps[i-1] >= x-1 according to assumption so 
        lps[i-1] >= x-1, but lps[i] = x.
        lps[i-1] >= lps[i] - 1,
        lps[i-1] + 1 >= lps[i]
        lps[i] <= lps[i-1] + 1 
        so this observation shows that the lps[i] can be max as lps[i-1]+1 
        
        Observation-4 :-
        Now suppose this is the string with index and we are calculating the last lps value
        index -->  0 1 2 3 4 5 6 7 8 9 
        String --> b c a d c b c a d ?
        lps -----> 0 0 0 0 0 1 2 3 4
        the lps value of the 9th index can have maximum value of lps[i-1]+1 = 5 here and in order
        to be 5 the 9th index character should be 'c' only then it would be 5. The way we compared
        two characters is s(i) lps value can be max of lps of s(i-1)+1 so assume the lps[i-1]=x
        lets suppose the lps[i-1]=4 and we are finding for lps[i] now we know that the last 4 
        characters are matching with the first 4 characters till 0 to i-1 that's why the value is 
        4 here now the indexing is playing an crucial role here so the lps[i-1]=4 now the s0 to s3
        are equal to s(i-4) to s(i-1) so we are comparing s4 with s(i) and that's why we will compare
        if(s(i) == s(x)){
            lps[i] = lps[i-1]+1; 
        }
        it means that the s(i) and s(x) and here x = 4 as we found are matching so it will contribute
        to it and lps[i]=5 so in this way if the s(i) and s(x) are equal the ith lps would be just
        +1 of its previous.
        
        Observation-5 :- 
        what if the s(i) and s(x) are not equal then follow a simple principle just check the one 
        previous index character like here lps[16-1] = 7 = x so s(16) != s(7) so just check one
        index -->  0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
        String --> c a c y c a c a b c a  c  y  c  a  c  y
        lps -----> 0 0 1 0 1 2 3 2 0 1 2  3  4  5  6  7  ? <-- means we are calculating it.
        index back of it by doing x = lps[x-1] here x is 7 so lps[7-1] => lps[6] = 3 = new x
        now compare s(16) and s(x) which is s(3) now so is s(16) == s(3) yes it is so the 
        lps of s(16) would be equal to x+1 as we have assumed lps[i-1] = x and we are comparing
        s(i) ans s(x) so lps[16] = 3 + 1 = 4 and continue the same process till they don't match
        but once it has reached 0th index make x=-1 and later do the lps[i] = x+1 = -1+1 = 0 so
        it will store 0 in place.
        This algorithm is used to search a pattern of word in given text and for that there is
        a method we concat pattern+text and then create a lps array of combination and try to
        find the lps value == pattern length means the text contains pattern but there is an edge
        case her as we are concatenating pattern and text they are inseparable so if the pattern =
        "abab" and text = "abaca" now if we concat it becomes "abababaca" now lps array will store
        4 in place as it thinks that it is single string but the text does not contain pattern so
        for this introduce a deliminator like "@" and concat both with it now the lps array won't
        store pattern length as the combination is now "abab@abaca" so there is no "abab" in suffix
        part and answer would be false.
        */
//        String A = "cacycacabcacycacy";
//        int[] lps = createLPSArray(A);
//        System.out.println(Arrays.toString(lps));
        String pattern = "hemil";
        String text = "hemilisagoodboyhemilisgreatcomputerscientisthemilhavemasterdegree";
        System.out.println(countPattern(pattern, text));
    }
}