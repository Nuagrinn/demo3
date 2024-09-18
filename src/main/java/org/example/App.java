package org.example;

public class App {
    public static void fizzBuzz(int begin, int end) {

        if (begin > end) {
            return;
        }
        for (int number = begin; number <= end; number++) {
            if (number % 3 == 0 && number % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (number % 3 == 0) {
                System.out.println("Fizz");
            } else if (number % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(number);
            }
    }
}
}