package org.solutions;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 4, 5, 3, 8, 3, 7}));
    }

    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;

        while (l < r) {
            // Вычисляем текущую площадь
            int currentArea = Math.min(height[l], height[r]) * (r - l);
            // Обновляем максимальную площадь
            maxArea = Math.max(maxArea, currentArea);

            // Двигаем указатель с меньшей высотой
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }
}