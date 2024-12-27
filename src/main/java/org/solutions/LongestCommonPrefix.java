package org.solutions;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"a", "cccccccc"};


        System.out.println(longestCommonPrefix(strs));

    }

    public static String longestCommonPrefix(String[] strs) {

        int minLen = strs[0].length();
        String min = strs[0];


        for (String str : strs) {
            if (str.length() < minLen) {
                min = str;
            }
        }

        int pLen = 0;
        for(int i = 0; i < min.length(); i++) {
            char cur = min.charAt(i);
            for (String s : strs) {
                if(s.charAt(i) != cur) {
                    return min.substring(0, pLen);
                }
            }
            pLen++;
        }

        return min.substring(0, pLen);

    }


}
