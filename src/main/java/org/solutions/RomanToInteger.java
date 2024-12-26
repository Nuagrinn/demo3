package org.solutions;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {

        System.out.println(romanToInt("LVIII"));
    }

    public static int romanToInt(String s) {

        Map<Character, Integer> dict = new HashMap<>();

        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X', 10);
        dict.put('L', 50);
        dict.put('C', 100);
        dict.put('D', 500);
        dict.put('M', 1000);

        if(s.length() == 1) {
            return dict.get(s.charAt(0));
        }

        int cur = dict.get(s.charAt(s.length() - 1));
        int num = cur;
        for (int i = s.length() - 2; i >= 0; i--) {
            if(cur > dict.get(s.charAt(i))) {
                num -= dict.get(s.charAt(i));
            } else {
                num += dict.get(s.charAt(i));
            }
            cur = dict.get(s.charAt(i));
        }

        return num;

    }
}
