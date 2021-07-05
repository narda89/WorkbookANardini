package ires.corso.parttwo.poliRepo;

import java.io.Serializable;

public abstract class Vehicle
        implements Serializable {

    private String targa;
    private int numeroRuote;

    protected Vehicle(String targa, int numeroRuote) {
        this.targa = targa;
        this.numeroRuote = numeroRuote;
    }

    public String getTarga() {
        return targa;
    }

    public int getNumeroRuote() {
        return numeroRuote;
    }

    public abstract void prettyPrint();


}
