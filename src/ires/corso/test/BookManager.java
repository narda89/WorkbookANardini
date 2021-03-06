package ires.corso.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookManager {

    public static void addBook(Biblioteca biblio) throws ParseException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Inserisci ISBN");
        String isbn = scan.nextLine();
        if(biblio.ISBNpresent(isbn)) {
            System.out.println("Spiacente, il libro è già in libreria");
            return;
        }

        System.out.println("Inserisci titolo:");
        String titolo = scan.nextLine();

        System.out.println("Inserisci autore:");;
        String autore = scan.nextLine();

        System.out.println("Inserisci sinossi:");
        String sinossi = scan.nextLine();

        System.out.println("Inserisci data:");
        String sData = scan.nextLine();
        Date data = new SimpleDateFormat("dd/MM/yyyy").parse(sData);

        System.out.println("Inserisci genere:");
        Libro.Genere genere = Libro.Genere.valueOf(scan.nextLine());

        Libro l = new Libro(titolo, autore, sinossi, isbn, data, genere);

        biblio.addBook(l);
    }

    public static void updateReadStatus(Biblioteca biblio) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci l'ISBN del libro:");
        String isbn = scan.nextLine();
        if(biblio.ISBNpresent(isbn)) {
            biblio
                    .getLibri()
                    .stream()
                    .filter(l -> l.getISBN().equals(isbn))
                    .forEach(libro -> {
                        if (libro.getAvanzamentoLettura()<100) {
                            System.out.println("Inserire nuovo valore avanzamento:");
                            int i = scan.nextInt();
                            if (i > 0 && i <101 ) {
                                libro.setAvanzamentoLettura(i);
                                System.out.println("Aggiornato!");
                                return;
                            } else {
                                System.out.println("Valore non valido!");
                            }
                        } else {
                            System.out.println("Libro già terminato!");
                        }
                    });
        }

    }

    public static void deleteBook(Biblioteca biblio) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserire isbn del libro da rimuovere:");
        String isbnToRemove = scan.nextLine();
        if(biblio.ISBNpresent(isbnToRemove)) {
            for(Libro l : biblio.getLibri()) {
                if (l.getISBN().equals(isbnToRemove)) {
                    System.out.println("Vuoi rimuovere? Digita si per confermare");
                    if(scan.nextLine().equals("si")) {
                        biblio.removeBook(l);
                        System.out.println("Libro rimosso!");
                        return;
                    } else {
                        System.out.println("Ok, non lo rimuovo");
                        return;
                    }
                }
            }
        } else {
            System.out.println("ISBN non trovato");
        }
    }

    public static void evaluateBook(Biblioteca biblio) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci isbn del libro che vuoi valutare:");
        String isbn = scan.nextLine();
        if(biblio.ISBNpresent(isbn)) {
            for (Libro l : biblio.getLibri()) {
                if (l.getISBN().equals(isbn)) {
                    if (l.getAvanzamentoLettura() == 100) {
                        // giudica
                        System.out.println("Ok, hai finito il libro. Qual è il tuo giudizio?");
                        String sEvaluation = scan.nextLine();
                        l.setGiudizioLibro(Libro.Giudizio.valueOf(sEvaluation));
                        System.out.println("Giudizio aggiornato!");
                        return;
                    } else {
                        System.out.println("Devi finire di leggerlo prima di giudicarlo!");
                        return;
                    }
                }
            }
        } else {
            System.out.println("ISBN non trovato");
            return;
        }

    }

    public static void modifyBook(Biblioteca biblio) throws ParseException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ok, intanto dammi un isbn");
        String isbn = scan.nextLine();
        if(!(biblio.ISBNpresent(isbn))) {
            System.out.println("Libro non trovato in biblioteca");
            return;
        } else {
            System.out.println("Ok, trovato. Cosa vuoi modificare?\n" +
                    "(titolo, autore, sinossi, dataPubblicazione, genere\n" +
                    "devi proprio scriver 'titolo' o 'autore' ecc...");

            String userInput = scan.nextLine();

            if (userInput.equals("titolo")) {
                // modifica titolo
                for (Libro l : biblio.getLibri()) {
                    if (l.getISBN().equals(isbn)) {
                        System.out.println("Inserisci nuovo titolo");
                        l.setTitolo(scan.nextLine());
                        System.out.println("Titolo aggiornato!");
                        return;
                    }
                }
            } else if (userInput.equals("autore")) {
                // modifica autore
                for (Libro l : biblio.getLibri()) {
                    if (l.getISBN().equals(isbn)) {
                        System.out.println("Inserisci nuovo autore");
                        l.setAutore(scan.nextLine());
                        System.out.println("Autore aggiornato!");
                        return;
                    }
                }

            } else if (userInput.equals("sinossi")) {
                // modifica sinossi
                for (Libro l : biblio.getLibri()) {
                    if (l.getISBN().equals(isbn)) {
                        System.out.println("Inserisci nuova sinossi");
                        l.setSinossi(scan.nextLine());
                        System.out.println("Sinossi aggiornata!");
                        return;
                    }
                }

            } else if (userInput.equals("dataPubblicazione")) {
                // modifico data pubblicazione
                for (Libro l : biblio.getLibri()) {
                    if (l.getISBN().equals(isbn)) {
                        System.out.println("Inserisci nuova data pubblicazione");
                        String sData = scan.nextLine();
                        Date data = new SimpleDateFormat("dd/MM/yyyy").parse(sData);
                        l.setDataPubblicazione(data);
                        System.out.println("Data aggiornata!");
                        return;
                    }
                }
            }else if (userInput.equals("genere")) {
                // modifica genere
                for (Libro l : biblio.getLibri()) {
                    if (l.getISBN().equals(isbn)) {
                        System.out.println("Inserisci nuovo genere");
                        l.setGenereLibro(Libro.Genere.valueOf(scan.nextLine()));
                        System.out.println("Genere aggiornato!");
                        return;
                    }
                }
            } else {
                // input non riconosciuto
                System.out.println("Input non riconosciuto, sorry.");
                return;
            }
        }
    }
}
