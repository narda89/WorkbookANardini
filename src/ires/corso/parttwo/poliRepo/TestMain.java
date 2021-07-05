package ires.corso.parttwo.poliRepo;

import java.util.ArrayList;
import java.util.Arrays;

public class TestMain {
    public static void main(String[] args) {

        // Date:
        // -----
        // - una classe Vehicle
        // - tre classi Car, Truck, Motorbike (mantenetele + scarne possibile) che la estendono
        // - organizzare un repository "polimorfico", che gestisca le tre tipologie di veicolo
        //   utilizzando un'unica collezione (di Vehicle)
        // - prevedere almeno le seguenti funzionalità:
        //
        //   OK 1) restituire lista di veicoli di un solo tipo
        //   OK 2) restituire lista totale
        //   3) aggiungere/rimuovere/sostituire (swap) un qualsiasi veicolo
        //   OK 4) serializzazione... writeObject
        //
        // - suggerimento (ma non obbligatorio): ci sono anche i METODI generic...
        // - opzionale: rendere "generic" il repository

        /*
        Car c1 = new Car("UD234X", 4, "Berlina");
        Truck t1 = new Truck("TS54GX", 6, "4500");
        Motorbike m1 = new Motorbike("PD14XD9", 2, "motocross");

        ArrayList<? extends Vehicle> veicoli = new ArrayList<>(Arrays.asList(c1,t1,m1));

        VechicleRepo repo1 = new VechicleRepo(veicoli);

        repo1.SerializeRepo();

         */







        VechicleRepo repo1 = VechicleRepo.DeserializeRepo();

        repo1.prettyPrint();
        System.out.println("AUTOMOBILI:");
        ArrayList<Car> cars = repo1.returnOnlyCars();
        System.out.println("-------------------------");
        System.out.println("MOTO:");
        ArrayList<Motorbike> bikes = repo1.returnOnlyMotorbikes();
        System.out.println("-------------------------");
        System.out.println("CAMION:");
        ArrayList<Truck> trucks = repo1.returnOnlyTrucks();
        System.out.println("-------------------------");





    }
}
