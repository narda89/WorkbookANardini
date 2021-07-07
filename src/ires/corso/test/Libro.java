package ires.corso.test;

import java.io.Serializable;
import java.util.Date;

public class Libro implements Serializable {

    public enum Genere {
        HORROR,
        FANTASY,
        AVVENTURA,
        GIALLO
    }

    public enum Giudizio {
        A,
        B,
        C,
        D,
        E,
        PENDING
    }

    private String titolo;
    private String autore;
    private String sinossi;
    private String ISBN; // è univoco
    private Date dataPubblicazione;
    private Genere genereLibro;
    private Giudizio giudizioLibro;
    private int avanzamentoLettura;

    //// COSTRUTTORE CLASSICO //////////////////////////////////////////////////////////////////////////////////////////
    public Libro(String titolo, String autore, String sinossi, String ISBN, Date dataPubblicazione, Genere genereLibro) {
        this.titolo = titolo;
        this.autore = autore;
        this.sinossi = sinossi;
        this.ISBN = ISBN;
        this.dataPubblicazione = dataPubblicazione;
        this.genereLibro = genereLibro;
        this.giudizioLibro = Giudizio.PENDING;
        this.avanzamentoLettura = 0;
    }

    //// COSTRUTTORE COPIA /////////////////////////////////////////////////////////////////////////////////////////////
    public Libro(Libro another) {
        this.titolo = another.titolo;
        this.autore = another.autore;
        this.sinossi = another.sinossi;
        this.ISBN = another.ISBN;
        this.dataPubblicazione =  new Date(another.dataPubblicazione.getTime());
        this.genereLibro = another.genereLibro;
        this.giudizioLibro = another.giudizioLibro;
        this.avanzamentoLettura = another.avanzamentoLettura;
    }

    //// PRETTYPRINT ///////////////////////////////////////////////////////////////////////////////////////////////////
    public void prettyPrint() {
        System.out.println("----------------------------------------");
        System.out.printf("Titolo: %s\nAutore: %s\nSinossi: %s\nISBN: %s\nData Pubblicazione: %s\n" +
                            "Genere: %s\nGiudizio: %s\nPercentuale Avanzamento: %d %%\n",
                            getTitolo(), getAutore(), getSinossi(), getISBN(), getDataPubblicazione(),
                            getGenereLibro(), getGiudizioLibro(), getAvanzamentoLettura());

        System.out.println("----------------------------------------");
    }

    //// GETTERS ///////////////////////////////////////////////////////////////////////////////////////////////////////
    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public String getSinossi() {
        return sinossi;
    }

    public String getISBN() {
        return ISBN;
    }

    public Date getDataPubblicazione() {
        return dataPubblicazione;
    }

    public Genere getGenereLibro() {
        return genereLibro;
    }

    public Giudizio getGiudizioLibro() {
        return giudizioLibro;
    }

    public int getAvanzamentoLettura() {
        return avanzamentoLettura;
    }

    //// SETTERS ///////////////////////////////////////////////////////////////////////////////////////////////////////
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setSinossi(String sinossi) {
        this.sinossi = sinossi;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setDataPubblicazione(Date dataPubblicazione) {
        this.dataPubblicazione = dataPubblicazione;
    }

    public void setGenereLibro(Genere genereLibro) {
        this.genereLibro = genereLibro;
    }

    public void setGiudizioLibro(Giudizio giudizioLibro) {
        this.giudizioLibro = giudizioLibro;
    }

    public void setAvanzamentoLettura(int avanzamentoLettura) {
        this.avanzamentoLettura = avanzamentoLettura;
    }
}
