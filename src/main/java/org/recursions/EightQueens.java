package org.recursions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// пример решения задачи N ферзей
public class EightQueens {

    private static final int N = 8; // Размер доски 8x8

    public static void main(String[] args) {
        List<int[]> solutions = solveNQueens(N);

        // Выведем все найденные решения
        int count = 1;
        for (int[] solution : solutions) {
            System.out.println("Решение №" + (count++));
            printSolution(solution);
            System.out.println();
        }

        // Общее количество решений
        System.out.println("Всего решений: " + solutions.size());
    }

    /**
     * Основной метод для решения задачи расстановки N ферзей.
     */
    public static List<int[]> solveNQueens(int n) {
        // positions[i] = столбец, в котором расположен ферзь в строке i
        int[] positions = new int[n];
        Arrays.fill(positions, -1);

        List<int[]> solutions = new ArrayList<>();
        placeQueen(0, positions, solutions, n);
        return solutions;
    }

    /**
     * Рекурсивная функция для размещения ферзя в строке row.
     * Если row == n, значит все ферзи расставлены.
     */
    private static void placeQueen(int row, int[] positions, List<int[]> solutions, int n) {
        // Базовый случай: все n ферзей успешно расставлены
        if (row == n) {
            // Добавляем копию массива positions в список решений
            solutions.add(positions.clone());
            return;
        }

        // Перебираем все столбцы для текущей строки row
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, positions)) {
                // Ставим ферзя
                positions[row] = col;

                // Переходим к следующей строке
                placeQueen(row + 1, positions, solutions, n);

                // После выхода из рекурсии можно попробовать другой столбец
                // (но в данном случае мы просто идём в следующую итерацию цикла for)
            }
        }
        // Если не нашли ни одного подходящего столбца, алгоритм "откатывается" назад
    }

    /**
     * Проверяем, можно ли поставить ферзя в клетку (row, col).
     * Для этого он не должен бить уже поставленных ферзей.
     */
    private static boolean isSafe(int row, int col, int[] positions) {
        // Сравниваем с уже расставленными ферзями в предыдущих строках
        for (int r = 0; r < row; r++) {
            int c = positions[r];

            // 1. Тот же столбец?
            if (c == col) {
                return false;
            }

            // 2. Главная или побочная диагональ?
            // Разница по строкам == разница по столбцам => значит, на одной диагонали
            if (Math.abs(row - r) == Math.abs(col - c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Вывод решения в консоль в "шахматном" виде.
     * Каждый элемент массива positions содержит номер столбца для соответствующей строки.
     */
    private static void printSolution(int[] positions) {
        int n = positions.length;
        for (int row = 0; row < n; row++) {
            // Печатаем точку или 'Q'
            for (int col = 0; col < n; col++) {
                if (positions[row] == col) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
