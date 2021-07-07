package ires.corso.test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class BiblioApp {
    public static void main(String[] args) throws ParseException, IOException {

        //// NOTA: /////////////////////////////////////////////////////////////////////////////////////////////////////
        // per come è fatto l'add dentro alla repository Biblioteca, l'isbn funziona come identificatore univoco dei  //
        // libri. Se si prova ad aggiungere a mano o ad importare libri aventi isbn già in repository, quei libri non //
        // vengono importati e compare il messaggio di fail del metodo add della repo.                                //
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Biblioteca biblio = new Biblioteca();

        // ROBA PER BOOTSTRAP SE NON SI VUOLE DESERIALIZZARE ///////////////////////////////////////////////////////////

        String sData = "15/07/1980";
        Date d = new SimpleDateFormat("dd/MM/yyyy").parse(sData);

        Libro l1 = new Libro("CTitolo1","Autore1", "Sinossi1", "ISBN1", d, Libro.Genere.AVVENTURA);
        biblio.addBook(l1);
        Libro l2 = new Libro("ATitolo2","Autore2", "Sinossi2", "ISBN2", d, Libro.Genere.GIALLO);
        biblio.addBook(l2);

        Libro l3 = new Libro("BTitolo3","Autore3", "Sinossi3", "ISBN3", d, Libro.Genere.GIALLO);
        biblio.addBook(l3);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        //// MENU IMPORT / EXPORT //////////////////////////////////////////////////////////////////////////////////////
        MenuElement IE1 = new MenuElement("A","Serializza su file", () -> ImportExport.serializeBiblio(biblio));
        MenuElement IE2 = new MenuElement("B", "Deserializza da file", () -> ImportExport.deSerializeBiblio(biblio));
        MenuElement IE3 = new MenuElement("C", "Esporta su file", () -> {
            try {
                ImportExport.exportNIOBiblio(biblio);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Menu IEMenu = new Menu("Import/Export", new ArrayList<>(Arrays.asList(IE1,IE2, IE3)));

        //// MENU BIBLIO LIST //////////////////////////////////////////////////////////////////////////////////////////
        MenuElement BL1 = new MenuElement("A", "Visualizza collezione", () ->BiblioList.showAll(biblio.getLibri()) );
        MenuElement BL2 = new MenuElement("B", "Visualizza ordinati per Titolo", () ->BiblioList.showByTitle(biblio.getLibri()) );
        Menu BiblioMenu = new Menu("Visualizza Libri", new ArrayList<>(Arrays.asList(BL1,BL2)));

        //// MENU BIBLIO MANAGER ///////////////////////////////////////////////////////////////////////////////////////
        MenuElement BM1 = new MenuElement("A", "Aggiorna avanzamento Lettura", () ->BookManager.updateReadStatus(biblio));
        MenuElement BM2 = new MenuElement("B", "Rimuovi libro", () -> BookManager.deleteBook(biblio));
        MenuElement BM3 = new MenuElement("C", "Valuta libro", () -> BookManager.evaluateBook(biblio));
        MenuElement BM4 = new MenuElement("D", "Aggiungi libro", () -> {
            try {
                BookManager.addBook(biblio);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
        MenuElement BM5 = new MenuElement("E", "Modifica dati libro", () -> {
            try {
                BookManager.modifyBook(biblio);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });

        Menu BiblioManager = new Menu("Book Manager", new ArrayList<>(Arrays.asList(BM1,BM2, BM3, BM4, BM5)));


        //// MENU PRINCIPALE ///////////////////////////////////////////////////////////////////////////////////////////
        MenuElement MP1 = new MenuElement("A", "Import/Export", IEMenu :: runMenu);
        MenuElement MP2 = new MenuElement("B", "Visualizza", BiblioMenu :: runMenu);
        MenuElement MP3 = new MenuElement("C","BiblioManager", BiblioManager::runMenu);

        Menu MainMenu = new Menu("Main menu", new ArrayList<>(Arrays.asList(MP1, MP2, MP3)));

        MainMenu.runMenu();
    }
}
