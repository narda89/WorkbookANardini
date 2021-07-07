package ires.corso.test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ImportExport {
    //// SERIALIZZAZIONE ///////////////////////////////////////////////////////////////////////////////////////////////
    public static void serializeBiblio(Biblioteca biblio) {
        ObjectOutputStream objStream = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci nome file:");
        String nomeFile = scan.nextLine();
        try {
            objStream = new ObjectOutputStream(new FileOutputStream(nomeFile));
            objStream.writeObject(biblio);
            objStream.flush();
            objStream.close();
            System.out.println("Serialization completa!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //// DESERIALIZZAZIONE /////////////////////////////////////////////////////////////////////////////////////////////
    public static void deSerializeBiblio(Biblioteca biblio) {
        ObjectInputStream objStream = null;
        Biblioteca biblioLocal = new Biblioteca();
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci nome file da deserializzare:");
        String nomeFile = scan.nextLine();
        try {
            objStream = new ObjectInputStream(new FileInputStream(nomeFile));
            biblioLocal = (Biblioteca) objStream.readObject();
            System.out.println("De-serialization completa!");
        } catch (Exception e) {
            System.out.println(e);
        }
        for(Libro l : biblioLocal.getLibri())
            biblio.addBook(l);
    }

    //// EXPORT ////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void exportNIOBiblio(Biblioteca biblio) throws IOException {
        BufferedWriter buffWrite = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci nome file dove vuoi esportare i dati:");
        String sNomeFile = scan.nextLine();

        try {
            Path nomeFile = Paths.get(sNomeFile);
            buffWrite = Files.newBufferedWriter(nomeFile, Charset.defaultCharset());
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            for(Libro l : biblio.getLibri()) {
                StringBuilder stringLine = new StringBuilder(   l.getTitolo() + "|" +
                                                                l.getAutore() + "|" +
                                                                l.getSinossi() + "|" +
                                                                l.getISBN() + "|" +
                                                                dateFormat.format(l.getDataPubblicazione()) + "|" +
                                                                l.getGenereLibro() + "|" +
                                                                l.getGiudizioLibro() + "|" +
                                                                l.getAvanzamentoLettura() + "\n");
                buffWrite.append(stringLine);
            }
            System.out.println("Esportazione dati su file effettuata!");
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if(buffWrite != null)
                buffWrite.close();
        }
    }

}
