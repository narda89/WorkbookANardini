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

        int[] prova = {1 , 55, 66, 66, 12, 66};
        System.out.println(Arrays.toString(prova));
        int[] pulito = removeDuplicates(prova);
        System.out.println(Arrays.toString(pulito));
        int[] finale = removeSpecial(pulito);
        System.out.println(Arrays.toString(finale));
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

    //restituisce un secondo array uguale all'array fornito in ingresso, ma dal quale son stati rimossi eventuali duplicati
    public static int[] removeDuplicates(int[] arrayWithDuplicates) {

        int[] arrayProvv = arrayWithDuplicates;

        for (int i = 0; i < arrayProvv.length; i++) {
            for(int j = i + 1; j < arrayWithDuplicates.length; j++){
                if (arrayWithDuplicates[j] == arrayProvv[i]) {
                    arrayProvv[i] = -1;
                    break;
                }
            }

        }
        return arrayProvv;
    }
    public static int[] removeSpecial(int[] arrayProvv) {
        int j = 0;
        for (int i = 0; i < arrayProvv.length; i++) {
            if(arrayProvv[i] == -1) {
                j++;
            }
        }
        int[] arrayFinal = new int[arrayProvv.length - j];
        for (int i= 0, k = 0; i < arrayProvv.length; i++) {
            if(arrayProvv[i] != -1) {
                arrayFinal[k]= arrayProvv[i];
                k++;
            }
        }

        return arrayFinal;
    }
}


