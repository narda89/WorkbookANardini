package ires.corso.parttwo.WB210615;

import java.util.Arrays;

public class Esercitazione {

    public static void main(String[] args) {

        int[] intArr1 = {1,2,3,4,5};
        String[] strArr1 = {"java","test","ires", "corso"};

        System.out.println("Hai inserito questo array: " + intArr1.toString());
        System.out.println("Hai inserito questo array: " + Arrays.toString(intArr1));

        System.out.println("Hai inserito questo array: " + strArr1.toString());
        System.out.println("Hai inserito questo array: " + Arrays.toString(strArr1));


        int[] inputGame = {1,3,5,4,11,2,7};
        int[] init = Arrays.copyOf(inputGame,inputGame.length + 1);

        System.out.println("Hai inserito questo array: " + Arrays.toString(inputGame));
        System.out.println("Hai inserito questo array: " + Arrays.toString(init));

        int index = init.length - 1; //inizializzazione

        //questo dentro un while tipo

            int numeroscelto = 4;
            int switcheroo;
            switcheroo = init[numeroscelto];
            init[numeroscelto] = 0;
            init[index] = switcheroo;
            index = numeroscelto;
            System.out.println("Hai inserito questo array: " + Arrays.toString(init));





    }
}
