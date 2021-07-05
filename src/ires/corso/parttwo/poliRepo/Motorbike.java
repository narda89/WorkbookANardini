package ires.corso.parttwo.poliRepo;

import java.io.Serializable;

public class Motorbike
        extends Vehicle
        implements Serializable {
    private String tipo; // da strada, motocross, ecc..

    public Motorbike(String targa, int numeroRuote, String tipo) {
        super(targa, numeroRuote);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public void prettyPrint() {
        System.out.println("BIKE" + getTipo());
    }
}
