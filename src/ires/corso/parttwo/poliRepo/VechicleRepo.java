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

    public ArrayList<Car> returnOnlyCars() {
        ArrayList<Car> cars = new ArrayList<>();
        for (Vehicle v : veicoli) {
            if (v instanceof Car)
                cars.add((Car)v);
        }

        for(Car c : cars)
            c.prettyPrint();

        return cars;
    }

    public ArrayList<Truck> returnOnlyTrucks() {
        ArrayList<Truck> trucks = new ArrayList<>();
        for (Vehicle v : veicoli) {
            if (v instanceof Truck)
                trucks.add((Truck)v);
        }

        for(Truck t : trucks)
            t.prettyPrint();

        return trucks;
    }

    public ArrayList<Motorbike> returnOnlyMotorbikes() {
        ArrayList<Motorbike> bikes = new ArrayList<>();
        for (Vehicle v : veicoli) {
            if (v instanceof Motorbike)
                bikes.add((Motorbike) v);
        }

        for(Motorbike b : bikes)
            b.prettyPrint();

        return bikes;
    }
}
