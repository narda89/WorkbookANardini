package ires.corso.partone;

import ires.corso.partone.geometric.Quadrato;
import ires.corso.partone.geometric.Trapezio;
import ires.corso.partone.geometric.Triangolo;

import java.util.Scanner;

public class InputTest {

    /*
     * Scrivere un programma Java che esegua le seguenti operazioni:
     * 1. Chiede all'utente il tipo di forma geometrica del quale si vuole calcolare l'area
     * 2. Le figure da trattare sono 3: triangolo, trapezio, quadrato
     * 3. Per la figura prescelta chiede i parametri necessari al calcolo dell'area
     * 4. Calcola l'area utilizzando l'apposita formula
     * 5. stampa il risultato
     *
     * Per l'input utilizzare la classe Scanner; usare switch per discriminare tra le classi da chiamare
     */

    public static void main(String[] args) {
        System.out.println("Di quale figura geometrica si vuole calcolare l'area? Inserire il numero desiderato\n" +
                            "1. Quadrato\n" + "2. Trapezio\n" + "3. Triangolo\n");
        Scanner s = new Scanner(System.in);
        int switchCase = s.nextInt();
        switch (switchCase) {
            case 1:
                System.out.println("Inserire valore lato:");
                Scanner scan1 = new Scanner(System.in);
                double lato = scan1.nextDouble();
                double aSquare = Quadrato.computeArea(lato);
                System.out.println("Area triangolo: " + aSquare);

                break;
            case 2:
                //chiede  dati per area trapezio
                System.out.println("Inserire valori B, b, h:");
                Scanner scan2 = new Scanner(System.in);
                double bMagg = scan2.nextDouble();
                double bMin = scan2.nextDouble();
                double altezza = scan2.nextDouble();
                double aTrap = Trapezio.computeArea(bMagg, bMin, altezza);
                System.out.println("Area trapezio: " + aTrap);

                break;
            case 3:
                //chiede dati per area triangolo
                System.out.println("Inserire valori base e altezza:");
                Scanner scan3 = new Scanner(System.in);
                double base = scan3.nextDouble();
                double altezzaT = scan3.nextDouble();
                double aTriangle = Triangolo.computeArea(base, altezzaT);
                System.out.println("Area triangolo: " + aTriangle);

                break;
        }

        double aTrap = Trapezio.computeArea(0, 0, 0);
        double aSquare = Quadrato.computeArea(5);
        double aTriangle  = Triangolo.computeArea(0,0);
    }
}
