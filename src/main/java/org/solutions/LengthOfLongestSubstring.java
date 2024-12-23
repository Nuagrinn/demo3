package org.solutions;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(compute(s));
    }
    public static int compute(String s) {
        Set<Character> chars = new HashSet<>();
        int max = 0;
        int cntr = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            while (chars.contains(c)) {
                chars.remove(s.charAt(start));
                start++;
                cntr--;
            }
            chars.add(c);
            cntr++;
            max = Math.max(max, cntr);
        }

        return max;
    }

}
