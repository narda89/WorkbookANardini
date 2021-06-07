package ires.corso.partone.geometric;

import java.util.Scanner;

public class Triangolo {

    // Metodo che ritorna l'area di un triangolo, date base e altezza

    public static double computeArea ( double base, double height) {
        double Area = base * height / 2;
        return Area;
    }

    // Metodo che estrae dall'input i valori di base e altezza di un triangolo, li restituisce tramite array di double
    public static double[] extractValues() {
        System.out.println("Inserire base e altezza del triangolo: ");
        Scanner s = new Scanner(System.in);
        double base = s.nextDouble();
        double altezza = s.nextDouble();
        double[] valoriTriangolo = {base,altezza};
        return valoriTriangolo;
    }
}

