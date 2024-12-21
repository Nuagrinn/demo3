package org.demo;


import java.awt.Point;
import java.util.*;

public class RemoveCycles {

    /**
     * Удаляет из пути все циклы
     *
     * @param path Исходный путь, состоящий из L, R, U, D – left, right, up и down соответственно
     */


    public static String removeCycles(String path) {
        // Список точек пути
        List<Point> pathList = new LinkedList<>();
        // Map для хранения точки и индекса шага, на котором она была посещена
        Map<Point, Integer> visitedIndices = new HashMap<>();

        // Начальная точка
        Point current = new Point(0, 0);
        pathList.add(new Point(current));
        visitedIndices.put(new Point(current), 0);

        // Будем использовать StringBuilder для возможности удаления подстрок
        StringBuilder result = new StringBuilder(path);

        int stepIndex = 0;

        // Проходим по шагам
        while (stepIndex < result.length()) {
            char c = result.charAt(stepIndex);
            // Делаем копию текущей точки
            Point next = new Point(current);

            switch (c) {
                case 'L':
                    next.x -= 1;
                    break;
                case 'R':
                    next.x += 1;
                    break;
                case 'U':
                    next.y += 1;
                    break;
                case 'D':
                    next.y -= 1;
                    break;
            }

            // Проверяем, встречали ли эту точку ранее
            if (visitedIndices.containsKey(next)) {
                // Цикл найден
                int cycleStart = visitedIndices.get(next);
                int cycleEnd = stepIndex; // текущий индекс - конец цикла

                // Удаляем подстроку шага, образующую цикл
                result.delete(cycleStart, cycleEnd + 1);

                // Теперь надо обновить путь и visitedIndices заново, так как
                // удаление повлияло на индексы шагов и точки.
                pathList.clear();
                visitedIndices.clear();

                current.setLocation(0, 0);
                pathList.add(new Point(current));
                visitedIndices.put(new Point(current), 0);

                // Пересчитываем все заново до текущего шага
                for (int i = 0; i < result.length(); i++) {
                    char ch = result.charAt(i);
                    Point tmp = new Point(current);
                    switch (ch) {
                        case 'L':
                            tmp.x -= 1;
                            break;
                        case 'R':
                            tmp.x += 1;
                            break;
                        case 'U':
                            tmp.y += 1;
                            break;
                        case 'D':
                            tmp.y -= 1;
                            break;
                    }
                    if (visitedIndices.containsKey(tmp)) {
                        // Если снова встретили цикл, пересчет идет заново
                        // Поэтому уменьшим i на 1 и пусть цикл продолжит со всеми правками
                        // Однако такая ситуация будет обработана вновь.
                        int start = visitedIndices.get(tmp);
                        int end = i;
                        result.delete(start, end + 1);

                        // Сброс и начало пересчета заново
                        pathList.clear();
                        visitedIndices.clear();
                        current.setLocation(0, 0);
                        pathList.add(new Point(current));
                        visitedIndices.put(new Point(current), 0);
                        i = -1; // при i++ i=0, начнем с начала строку проверять
                    } else {
                        pathList.add(tmp);
                        visitedIndices.put(new Point(tmp), i + 1);
                        current.setLocation(tmp);
                    }
                }

                // После пересчета начинаем с конца результирующего пути,
                // так как все уже пересчитано заново
                stepIndex = result.length();
            } else {
                // Если новой точки не было, добавляем и идём дальше
                pathList.add(new Point(next));
                visitedIndices.put(new Point(next), stepIndex + 1);
                current.setLocation(next);
                stepIndex++;
            }
        }

        return result.toString();
    }

    static void check(String expected, String actual) {
        if (!actual.equals(expected)) {
            throw new AssertionError("Expected: " + expected + ", got: " + actual);
        }
    }

    public static void main(String[] args) {
        check("D", removeCycles("LRLLRRUDD"));
        check("LDRR", removeCycles("LDRR"));
    }
}