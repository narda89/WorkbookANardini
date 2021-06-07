package ires.corso.partone.WB210604;

public class StringTest02 {
    // Scrivere un programma in Java che:
    //  1. accetta in input 3 stringhe (da args)
    //  2. verifica che le stringhe siano 3
    //  3. calcola la lunghezza di ciascuna stringa
    //  4. trova il carattere iniziale e finale di ciascuna stringa
    //  5. per tutte e 3 le stringhe stampa un report del tipo:
    //  "La stringa " ...... " ha lunghezza " ..... " comincia per " ..... " e finisce per " .....

    public static void main (String[] args) {

        //verifica che args abbia effettivamente 3 elementi, altrimenti alla fine da messaggio di errore

        if (args.length == 3) {
            for ( int i  = 0; i < 3; i++) {
                if (args[i].length() == 0 ) {
                    System.out.println("La stringa immessa è una stringa vuota");
                } else {

                    String stringaInput = args[i];                          // Salva args[i] all'interno della Stringa stringaInput
                    int lunghezzaStringa = args[i].length();                // Salva la lunghezza di args[i] in una variabile int
                    char firstChar = args[i].charAt(0);                     // Salva il primo carattere di args[i] in una variabile char
                    char lastChar = args[i].charAt(args[i].length() - 1);   // Salva l'ultimo carattere di args[i] in una variabile char


                    String message  = String.format("La stringa %s ha lunghezza %s, comincia per %c e termina per %c",
                            stringaInput,                            //stampa il contenuto di args[i], ovvero la stringa n-esima
                            lunghezzaStringa,                        //stampa la lunghezza dell' n-esimo argomento di args
                            firstChar,                               //stampa il primo carattere dell'n-esimo argomento di args
                            lastChar );                              //stampa l'ultimo carattere dell'n-esimo args

                    System.out.println(message);

                }
            }

        } else {
            
            System.out.println("Attenzione, il programma richiede in input esattamente 3 stringhe. Hai inserito un " +
                    "numero di stringhe differente da quello richiesto");
        }

    }


}