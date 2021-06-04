package ires.corso.partone.WB210603;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Il programma mi chiede di inserire 3 valori interi su terminale; li legge e salva su 3 variabili int
        //nb: il programma non fa controlli di validità sull'input

        Scanner in;
        in = new Scanner(System.in);
        System.out.print("Inserisci il primo numero: ");
        int n1 = in.nextInt();
        System.out.println("Hai inserito il numero " + n1);

        System.out.print("Inserisci il secondo numero: ");
        int n2 = in.nextInt();
        System.out.println("Hai inserito il numero " + n2);

        System.out.print("Inserisci il terzo numero: ");
        int n3 = in.nextInt();
        System.out.println("Hai inserito il numero " + n3);

        //Stampata di riepilogo

        System.out.println("Sono stati inseriti i numeri " + n1 + ", " + n2 + ", " + n3);

        //Il programma confronta n1 ed n2, il più grande viene salvato in una variabile int aggiuntiva e confrontato
        // con n3. Il "vincitore" dell'ultimo confronto viene stampato a schermo

        int nc;

        //La stringa position tiene traccia dell'ordine di inserimento del numero
        String position;


        //primo round di confronto
        if (n1 >= n2){
            nc = n1;
            position = "primo";
        } else {
            nc = n2;
            position = "secondo";
        }

        //secondo e ultimo round di confronto
        if (nc < n3){
            nc = n3;
            position = "terzo";
        } //in caso contrario, nc rimane il numero piu' grande


        //caso estremo di 3 numeri uguali
        if (n1 == n2 && n2 == n3){
            System.out.println("I tre numeri inseriti sono uguali");
        } else {
            //Stampa a video nc, ovvero il numero più grande tra i tre inseriti
            System.out.println("Il numero più grande tra quelli inseriti è il " +position + ", ovvero " + nc);

        }

    }
}