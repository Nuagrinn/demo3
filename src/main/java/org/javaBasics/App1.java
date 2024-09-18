package org.javaBasics;

//dnaToRna
public class App1 {


    public static void main(String[] args) {
        dnaToRna("CCGTA");
    }
    public static String dnaToRna(String dna) {
        StringBuilder rna = new StringBuilder();
        for(int i = 0; i < dna.length(); i++) {
            switch (dna.charAt(i)) {
                case 'G' -> rna.append("C");
                case 'C' -> rna.append("G");
                case 'T' -> rna.append("A");
                case 'A' -> rna.append("U");
                default -> {
                    return null;
                }
            }
        }
        return rna.toString();
    }
}
