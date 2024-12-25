package org.demo;

import java.util.ArrayList;
import java.util.List;

public class CombinationsWithRepetition {

    public static void main(String[] args) {
        int n = 4; // Размер исходного множества (1, 2, ..., n)
        int k = 3; // Размер сочетания

        List<List<Integer>> result = generateCombinations(n, k);

        // Вывод результатов
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }

/*    Принимает параметры start (указатель на текущую позицию) и current (текущее сочетание).
    Генерирует сочетания с повторениями, начиная с числа start для гарантии того, что каждое сочетание будет упорядоченным.*/

    public static List<List<Integer>> generateCombinations(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        generateCombinationsRecursive(n, k, 1, new ArrayList<>(), combinations);
        return combinations;
    }

    private static void generateCombinationsRecursive(int n, int k, int start, List<Integer> current, List<List<Integer>> result) {
        // Базовый случай: если длина текущего сочетания равна k, добавляем его в результат
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Рекурсивно добавляем числа от start до n
        for (int i = start; i <= n; i++) {
            current.add(i);
            generateCombinationsRecursive(n, k, i, current, result); // Передаем i вместо i+1 для повторений
            current.remove(current.size() - 1); // Убираем последний элемент для следующей итерации
        }
    }
}