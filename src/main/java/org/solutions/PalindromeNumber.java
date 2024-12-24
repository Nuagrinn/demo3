package org.solutions;

public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(100));
    }

    public static boolean isPalindrome(int x) {

        String xS = String.valueOf(x);

        if(xS.length() < 2) {
            return true;
        }
        boolean isP = false;

        boolean isEven = xS.length() % 2 == 0;

        char[] xSarr = xS.toCharArray();
        if(isEven) {
            int j = xSarr.length / 2;
            int i = j - 1;
            while (i >= 0 && j <= xSarr.length) {
                if (xSarr[i] != xSarr[j]) {
                    isP = false;
                    return isP;
                } {
                    isP = true;
                }
                i--;
                j++;
            }
            return isP;
        } else {
            int i = xSarr.length / 2 - 1;
            int j = xSarr.length / 2 + 1;
            while (i >= 0 && j <= xSarr.length ) {
                if(xSarr[i] != xSarr[j]) {
                    isP = false;
                    return isP;
                } {
                    isP = true;
                }
                i--;
                j++;
            }
            return isP;
        }
    }
}
