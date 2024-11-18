package org.solutions;

public class Hamming_code {

    public static void main(String[] args) {

        Integer n = 1010;
        System.out.println(getHammingWeight(n));

    }

    public static int getHammingWeight(int num) {
        var strNum = Integer.toBinaryString(num).toCharArray();
        int cnt = 0;
        for (var c : strNum) {
            if (c == '1') {
                cnt++;
            }
        }
        return cnt;
    }

}



