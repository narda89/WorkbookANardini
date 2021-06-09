package ires.corso.partone.WB210609;

import java.util.Arrays;
import java.util.Scanner;

public class TestArray {

    public static void main(String[] args) {
        /*
        System.out.println("Inserire numero completo: ");
        Scanner theScan = new Scanner(System.in);
        String theString = theScan.nextLine();
        System.out.println("Inserire la cifra singola che si vuole cercare nel numero: ");
        int theNum = theScan.nextInt();
        int indice = posizioneNumero(theString, theNum);
        System.out.printf("L'indice è: %d\n", indice);
        */

        int[] prova = {1, 1, 1, 5, 2, 2, 3, -3, 3, 5, 5, 5, 2, 4, 1, 7};

        System.out.println(Arrays.toString(prova));

        int[] finale = removeDuplicates(prova);
        System.out.println(Arrays.toString(finale));
        removeDuplicates2(prova);
    }

    public static int posizioneNumero(String s, int n) {

        char[] sChar = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (Character.getNumericValue(sChar[i]) == n) {
                System.out.printf("Il valore %d sta alla %d - esima posizione nella stringa\n", n, i);
                return i;
            }
        }
        System.out.println("Impossibile trovare numero inserito nella stringa");
        return -1;
    }

    //prende l'array di int e trascrive i numeri su una stringa separandoli con '|'; non trascrive i doppioni
    public static String removeDuplicatesToString(int[] arrayWithDuplicates) {

        String stringa = new String();
        boolean repFound = false;
        stringa += arrayWithDuplicates[1] + "|";

        for (int i = 1; i < arrayWithDuplicates.length; i++, repFound = false) {
            for (int j = i - 1; j >= 0; j--) {
                if (arrayWithDuplicates[j] == arrayWithDuplicates[i]) {
                    repFound = true;
                    break;
                }
            }
            if (!repFound) {
                stringa += arrayWithDuplicates[i] + "|";
            }
        }
        return stringa;
    }

    //legge la stringa formattata con il separatore "|" e inserisce gli int che rileva dentro ad un array
    public static int[] stringToArrayInt(String stringInput) {
        String[] splitted = stringInput.split("\\|");
        int[] finale = new int[splitted.length];

        for( int i = 0; i < splitted.length; i++ ) {
            finale[i] = Integer.parseInt(splitted[i]);
        }

        return finale;
    }

    public static int[] removeDuplicates(int[] arrayWithDuplicates) {
        return stringToArrayInt(removeDuplicatesToString(arrayWithDuplicates));
    }

    public static int[] removeDuplicates2(int[] arrayWithDuplicates) {

        // crea vettore provvisorio sorted delle stesse dimensioni di quello che viene passato al metodo
        int[] sorted = new int[arrayWithDuplicates.length];
        sorted[0] = arrayWithDuplicates[0];
        int doppione = 0;       //contatore delle occorrenze di doppioni;
        boolean[] flag = new boolean[arrayWithDuplicates.length]; //vettore di controllo, lo si mette in AND col vettore che si crea col for seguente

        for ( int i = 1 ; i < (arrayWithDuplicates.length); i++ ) {
            flag[i] = false;
            for (int j = i; j >= 0; j--) {
                if (arrayWithDuplicates[i] == sorted[j]) {
                    doppione++;
                    flag[i] = true;
                    break;
                }
            }
            if (!flag[i]) {
                sorted[i]=arrayWithDuplicates[i];           //scrive sul vettore nuovo solo se non è stato rilevato doppione nel ciclo for precedente
            }
        }

        System.out.printf("%d\n", doppione);            //stampe di controllo
        System.out.println(Arrays.toString(sorted));    //stampe di controllo
        System.out.println(Arrays.toString(flag));      //stampe di controllo

        int[] finale = new int[arrayWithDuplicates.length - doppione];  //piu piccolo di quello iniziale di un valore pari al n. di doppioni
        for (int i = 0, j = 0; i < arrayWithDuplicates.length; i++) {
            if (!flag[i]) {                         //ci scrive solo se il vettore di controllo è falso (per quella posizione nn era stato rilevato doppione
                finale[j] = sorted[i];
                j++;
            }
        }

        System.out.println(Arrays.toString(finale));
        return finale;
    }

}





