package ires.corso.parttwo.WB210701;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TestLambda {

    public static void main(String[] args) {

        //// PRIMO ESERCIZIO

        List<String> names = new ArrayList<>(Arrays.asList("Alberto","Niki", "Alessandro", "Alessio", "Veronica", "Pio",
                "Agnese","Stefano","Anna","AbbiamoPochePersoneAventiNomeCorto"));

        int l = 5;
        System.out.printf("Nomi aventi meno di %d caratteri:\n", l);
        names
                .stream()
                .filter( n -> n.length() < l)
                .map( n -> n.toUpperCase())
                .forEach(System.out::println);

        //// SECONDO ESERCIZIO

        Scanner scan = new Scanner(System.in);
        System.out.println( "Inserisci un po' di numeri interi, >0, separandoli con la virgola:");
        String input = scan.nextLine();
        String[] splitted = input.split(",");

        List<Integer> numbers = new ArrayList<>();

        for(String s : splitted)
            numbers.add(Integer.parseInt(s));

        double res =
                numbers
                        .stream()
                        .distinct()
                        .map(n -> n*n)
                        .mapToDouble(n -> n)
                        .average()
                        .getAsDouble();

        System.out.printf("Media dei numeri filtrati: %f\n", res);
    }
}