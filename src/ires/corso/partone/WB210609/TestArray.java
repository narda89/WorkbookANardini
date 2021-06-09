package ires.corso.partone.WB210609;

import java.util.Scanner;

public class TestArray {

    public static void main(String[] args) {
        System.out.println("Inserire numero completo: ");
        Scanner theScan = new Scanner(System.in);
        String theString = theScan.nextLine();
        System.out.println("Inserire la cifra singola che si vuole cercare nel numero: ");
        int theNum = theScan.nextInt();
        int indice = posizioneNumero(theString, theNum);
        System.out.printf("L'indice è: %d\n", indice);
    }

    public static int posizioneNumero (String s, int n) {

        char[] sChar = s.toCharArray();

        for ( int i = 0 ; i < s.length(); i++) {
            if (Character.getNumericValue(sChar[i]) == n) {
                System.out.printf("Il valore %d sta alla %d - esima posizione nella stringa\n", n, i);
                return i;
            }
        }
        System.out.println("Impossibile trovare numero inserito nella stringa");
        return -1;
    }
}


