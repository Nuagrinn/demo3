package org.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

//    Напишите программу, которая:

//    Получает на вход массив целых чисел (допустим, из 1000 элементов) и количество потоков X,
//    в которых нужно вычислить сумму элементов массива.
//    Делит массив на X равных (или почти равных) частей.
//    Каждый поток должен вычислить сумму своей части массива.
//    Главный поток программы должен собрать результаты всех потоков и вычислить итоговую сумму.

public class CalcSum {

    static List<Integer> nums;
    static int threadsNum;
    static AtomicInteger sum;
    static Integer batchSize;

    public static void main(String[] args) throws InterruptedException {

        sum = new AtomicInteger(0);
        threadsNum = 5; // Количество потоков
        Random random = new Random();
        nums = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            nums.add(random.nextInt(10) + 1); // Диапазон [1, 10]
        }

        // Вывод общей суммы для проверки
        System.out.println("Ожидаемая сумма: " + intListSum(nums));

        batchSize = nums.size() / threadsNum;

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < threadsNum; i++) {
            Thread thread = new Thread(new Summer(i));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        // Итоговая сумма
        System.out.println("Итоговая сумма: " + sum.get());
    }

    static class Summer extends Thread {
        private final int threadIndex;

        public Summer(int threadIndex) {
            this.threadIndex = threadIndex;
        }

        @Override
        public void run() {
            int start = threadIndex * batchSize;
            int end = threadIndex == threadsNum - 1
                    ? nums.size() // Последний поток обрабатывает остаток
                    : start + batchSize;

            List<Integer> subArr = nums.subList(start, end);
            int partialSum = intListSum(subArr);
            sum.addAndGet(partialSum);

            System.out.println(Thread.currentThread().getName() + " вычислил сумму: " + partialSum);
        }
    }

    public static int intListSum(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).sum();
    }
}

