package org.solutions;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {

    public static void main(String[] args) {
        String result = convert("PAYPALISHIRING", 4);
        System.out.println(result); // Ожидается "PINALSIGYAHRPI"
    }


    public static String convert(String s, int numRows) {
        // Если строка слишком короткая или всего 1 ряд, просто вернуть строку
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        // Инициализация строк для каждого ряда
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        // Логика для движения вниз и вверх
        int currentRow = 0;
        boolean goingDown = false;

        // Итерация по символам строки
        for (char c : s.toCharArray()) {
            rows.get(currentRow).append(c); // Добавляем символ в текущий ряд

            // Изменяем направление на "вниз" или "вверх", если достигнут край
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Изменяем текущий ряд
            currentRow += goingDown ? 1 : -1;
        }

        // Собираем результат из всех рядов
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
