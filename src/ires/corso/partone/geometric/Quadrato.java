package ires.corso.partone.geometric;

import java.util.Scanner;

public class Quadrato {

    // Metodo che ritorna l'area di un quadrato, dato il lato
    public static double computeArea(double lato) {
        double Area  = lato * lato;
        return Area;
    }

    // Metodo che estrae dall'input il valore del lato di un quadrato e lo restituisce come double
    public static double extractValues() {
        System.out.println("Inserire lato: ");
        Scanner s = new Scanner(System.in);
        double lato = s.nextDouble();
        return lato;
    }
}