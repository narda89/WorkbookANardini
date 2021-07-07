package ires.corso.test;

import java.util.ArrayList;
import java.util.Comparator;

public class BiblioList {

    static Comparator<Libro> perGenere = (Libro l1, Libro l2) -> (l1.getGenereLibro().compareTo(l2.getGenereLibro()));
    static Comparator<Libro> perTitolo = (Libro l1, Libro l2) -> (l1.getTitolo().compareTo(l2.getTitolo()));


    static void showAll(ArrayList<Libro> libri) {
        for(Libro l : libri)
            l.prettyPrint();
    }


    static void showByTitle(ArrayList<Libro> libri) {
        libri.stream().sorted(perTitolo).forEach(l ->l.prettyPrint());
    }

}
