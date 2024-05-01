package com.company;

public class StringBuilderSB {
    public static void main(String[] args) {
        /*String builder doesn't create a new object every time, it adds the new data to the current existing object
        * so the memory is saved in this case. The main advantage of it is that it is mutable */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char ch = (char)('a' + i);
            sb.append(ch);
        }
        System.out.println(sb.toString());
    }
}
