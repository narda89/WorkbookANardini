package ires.corso.parttwo.poliRepo;

import java.io.*;
import java.util.ArrayList;

public class VechicleRepo
        implements Serializable {
    private ArrayList<? extends Vehicle> veicoli = null;

    public VechicleRepo(ArrayList<? extends Vehicle> veicoli) {
        this.veicoli = veicoli;
    }

    public void prettyPrint() {
        for (Vehicle v : veicoli)
            v.prettyPrint();
    }

    public void SerializeRepo() {
        ObjectOutputStream objOut = null;
        try {
            objOut = new ObjectOutputStream(new FileOutputStream("VehicleRepo.ser"));
            objOut.writeObject(veicoli);
            objOut.flush();
            objOut.close();
            System.out.println("Serialization completed!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static VechicleRepo DeserializeRepo() {
        ObjectInputStream objIn = null;
        VechicleRepo repo = null;
        try {
            objIn = new ObjectInputStream(new FileInputStream("VehicleRepo.ser"));
            ArrayList<? extends Vehicle> veicoli = new ArrayList<>();
            veicoli = (ArrayList<? extends Vehicle>)objIn.readObject();
            repo = new VechicleRepo(veicoli);
        } catch (Exception e) {
            System.out.println(e);
        }
        return repo;
    }
}
