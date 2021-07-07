package ires.corso.parttwo.poliRepo;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class VechicleRepo
        implements Serializable {

    private ArrayList<Vehicle> veicoli = new ArrayList<>();

    public VechicleRepo(ArrayList<Vehicle> veicoli) {
        this.veicoli = veicoli;
    }

    public void prettyPrint() {
        for (Vehicle v : veicoli)
            v.prettyPrint();
    }

    public void add(Vehicle v) {
        veicoli.add(v);
    }

    public void delete(String targa) {
        boolean vehicleFound = false;
        for (Vehicle v : veicoli) {
            if (v.getTarga().equals(targa)) {
                vehicleFound = true;
                veicoli.remove(v);
                System.out.println("Veicolo avente targa " + targa + " rimosso dalla repository.");
                return;
            }
        }
        if(!vehicleFound)
            System.out.println("Non è stato trovato alcun veicolo avente targa " + targa);
    }

    public void swap(Vehicle vNew, String targa) {
        for(Vehicle v : veicoli) {
            if(v.getTarga().equals(targa)) {
                veicoli.remove(v);
                veicoli.add(vNew);
                System.out.println("Sostituzione effettuata!");
                return;
            }
        }
        System.out.println("Nessun veicolo avente targa " + targa + " trovato in repository. Swap non effettuato.");
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
            ArrayList<Vehicle> veicoli = new ArrayList<>();
            veicoli = (ArrayList<Vehicle>)objIn.readObject();
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

// prova commit push

