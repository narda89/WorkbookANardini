package ires.corso.parttwo.poliRepo;

import java.io.Serializable;

public class Car
        extends Vehicle
        implements Serializable {

    private String tipoAuto; // berlina, sportiva ecc


    public Car(String targa, int numeroRuote, String tipoAuto) {
        super(targa, numeroRuote);
        this.tipoAuto = tipoAuto;
    }

    public String getTipoAuto() {
        return tipoAuto;
    }

    @Override
    public void prettyPrint() {
        System.out.println("CAR - " + super.getTarga() + " - " +  super.getNumeroRuote() + " - " + getTipoAuto());
    }
}
