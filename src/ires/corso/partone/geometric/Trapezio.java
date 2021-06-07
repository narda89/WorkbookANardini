package ires.corso.partone.geometric;

import java.util.Scanner;

public class Trapezio {

    // Metodo che ritorna l'area di un trapezio, date base maggiore, base minore e altezza

    public static double computeArea ( double bmaj, double bmin, double height) {
        double Area = (bmaj + bmin) * height / 2;
        return Area;
    }

    // Metodo che estrae dall'input i valori di base maggiore, base minore e altezza di un trapezio,
    // li restituisce tramite array di double

    public static double[] extractValues() {
        System.out.println("Inserire base magg, base min e altezza del trapezio: ");
        Scanner s = new Scanner(System.in);
        double baseMagg = s.nextDouble();
        double baseMin = s.nextDouble();
        double altezza = s.nextDouble();
        double[] valoriTrapezio = {baseMagg, baseMin, altezza};
        return valoriTrapezio;
    }

}