package ires.corso.test;


// commit prova

import java.io.Serializable;
import java.util.ArrayList;

public class Biblioteca implements Serializable {

    private ArrayList<Libro> libri = new ArrayList<>();
    //private int insertCounter = 0;

    //// COSTRUTTORE CLASSICO //////////////////////////////////////////////////////////////////////////////////////////
    public Biblioteca(ArrayList<Libro> libri) {
        this.libri = libri;
    }

    //// COSTRUTTORE VUOTO /////////////////////////////////////////////////////////////////////////////////////////////
    public Biblioteca() {
        this.libri = new ArrayList<>();
    }

    //// COSTRUTTORE COPIA /////////////////////////////////////////////////////////////////////////////////////////////
    public Biblioteca(Biblioteca another) {
        for (Libro l : another.getLibri())
            this.libri.add(new Libro(l));
    }

    //// GETTER ////////////////////////////////////////////////////////////////////////////////////////////////////////
    public ArrayList<Libro> getLibri() {
        return libri;
    }

    //// ADD ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void addBook(Libro l) {
        if (ISBNpresent(l.getISBN())) {
            System.out.println("ISBN già presente in sistema! Impossibile aggiungere libro");
            return;
        } else {
            libri.add(l);
        }
    }

    //// REMOVE ////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void removeBook(Libro l) {
        if (ISBNpresent(l.getISBN())) {
            libri.remove(l);
            System.out.println("Libro avente ISBN " + l.getISBN() + " rimosso dalla biblioteca.");
            return;
        } else {
            System.out.println("Il libro fornito non è presente nella biblioteca. Impossibile rimozione");
        }
    }

    //// ISBN CHECK ////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean ISBNpresent(String isbn) {
        for(Libro l : libri) {
            if ( l.getISBN().equals(isbn) )
                return true;
        }
        return false;
    }

    //// ISBN RETURN ///////////////////////////////////////////////////////////////////////////////////////////////////

}
