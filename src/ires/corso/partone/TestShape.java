package ires.corso.partone;

import ires.corso.partone.geometric.Quadrato;
import ires.corso.partone.geometric.Trapezio;
import ires.corso.partone.geometric.Triangolo;

import java.util.Scanner;

public class TestShape {

    public static void main(String[] args) {
        System.out.println("Di quale figura geometrica si vuole calcolare l'area? Inserire il numero desiderato" +
                "(1. Quadrato |" + "2. Trapezio |" + "3. Triangolo");

        Scanner s = new Scanner(System.in);
        int switchCase = s.nextInt();

        // nb. in futuro modificare metodo calcolo area affinché accetti un array di double
        //     implementare metodo dedicato per la stampa dei risultati

        switch (switchCase) {

            case 1:     //quadrato
                double lato = Quadrato.extractValues();
                String messageQuad  = String.format("L'area del quadrato è pari a: %f", Quadrato.computeArea(lato));
                System.out.println(messageQuad);

                break;

            case 2:     //trapezio
                double[] valoriTrap = Trapezio.extractValues();
                double baseMagg = valoriTrap[0];
                double baseMin = valoriTrap[1];
                double altezzaTrap = valoriTrap[2];
                String messageTrap  = String.format("L'area del trapezio è pari a: %f", Trapezio.computeArea(baseMagg, baseMin, altezzaTrap));
                System.out.println(messageTrap);

                break;

            case 3:     //triangolo
                double[] valoriTriang = Triangolo.extractValues();
                double baseTriang = valoriTriang[0];
                double altezzaTriang = valoriTriang[1];
                String messageTriang  = String.format("L'area del triangolo è pari a: %f",  Triangolo.computeArea(baseTriang, altezzaTriang));
                System.out.println(messageTriang);

                break;

            default:
                //il programma non ha riconosciuto l'input
                System.out.println("Input non valido");
        }

    }
}
