package org.javaBasics;


//Реализуйте метод addDigits(), который принимает на вход неотрицательное целое число и возвращает другое число, полученное
// из первого следующим преобразованием: Итеративно сложите все входящие в него цифры до тех пор пока, не останется одна цифра.
public class App2 {

    public static void main(String[] args) {
        addDigits(919);
    }
    public static int addDigits(int n) {
        String nStr = String.valueOf(n);
        while (nStr.length() != 1) {
            int nInt = 0;
            for (int i = 0; i < nStr.length(); i++) {
                nInt += Integer.parseInt(String.valueOf(nStr.charAt(i)));
            }
            nStr = String.valueOf(nInt);
        }
        return Integer.parseInt(nStr);
    }
}
