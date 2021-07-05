package ires.corso.parttwo.poliRepo;

import java.io.Serializable;

public class Truck
        extends Vehicle
        implements Serializable {
    private String volumeRimorchio;

    public Truck(String targa, int numeroRuote, String volumeRimorchio) {
        super(targa, numeroRuote);
        this.volumeRimorchio = volumeRimorchio;
    }

    public String getVolumeRimorchio() {
        return volumeRimorchio;
    }

    @Override
    public void prettyPrint() {
        System.out.println("TRUCK - " + super.getTarga() + " - " + super.getNumeroRuote() + " - " + getVolumeRimorchio());
    }
}
