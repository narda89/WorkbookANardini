package ires.corso.parttwo.poliRepo;

import java.util.ArrayList;
import java.util.Arrays;

public class TestMain {
    public static void main(String[] args) {
        /*
        Car c1 = new Car("UD234X", 4, "Berlina");
        Truck t1 = new Truck("TS54GX", 6, "4500");
        Motorbike m1 = new Motorbike("PD14XD9", 2, "motocross");

        ArrayList<? extends Vehicle> veicoli = new ArrayList<>(Arrays.asList(c1,t1,m1));

        VechicleRepo repo1 = new VechicleRepo(veicoli);

        repo1.SerializeRepo();

         */

        VechicleRepo.DeserializeRepo().prettyPrint();



    }
}
