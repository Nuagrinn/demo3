package org.solutions;

public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }

    public static boolean isHappy(int n) {
        try {
            // Если длина числа меньше 2 и это не 1, то сразу возвращаем false{
            String sN = String.valueOf(n);
            int newN = 0;
            for (char c : sN.toCharArray()) {
                newN += Integer.parseInt(String.valueOf(c)) * Integer.parseInt(String.valueOf(c));
            }
            if (newN == 1) {
                return true;
            } else {
                // Важно вернуть результат рекурсивного вызова!
                return isHappy(newN);
            }
        } catch (OutOfMemoryError | StackOverflowError e) {
            return false;
        }
    }
}
