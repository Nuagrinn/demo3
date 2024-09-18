package org.javaBasics;


//Напишите метод diff(), который принимает два угла (integer), каждый от 0 до 360, и возвращает разницу между ними.
public class App3 {


    public static void main(String[] args) {
        System.out.println(diff(120, 280));
    }
    public static int diff(int a, int b) {
        int angl1 = Math.min(a, b) + 360 - Math.max(a, b);
        int angl2 = 360 - angl1;
        return Math.min(angl1, angl2);
    }

}
