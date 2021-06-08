package ires.corso.partone.WB210608;

import java.util.Scanner;

public class LoopTest {

    public static void TestLoopOne() {
        int i, j, n;
        int m = 1;
        System.out.print("Per quanto vuoi iterare? ");
        Scanner theScan = new Scanner(System.in);
        n= theScan.nextInt();

        for ( i = 1; i <= n ; i++)
        {
            for (j = 1; j <= i; j++)
            {
                System.out.print(m + " ");
                m++;
            }
            System.out.println("");
        }

    }

    public static void TestLoopTwo() {
        int i, j, k, n;

        System.out.print("Dimensioni? ");
        Scanner theScan = new Scanner(System.in);
        n = theScan.nextInt();
        int size = (n * 2) - 1;


        //Stampa meta superiore diamante
        for (i = 0; i < n; i++ )
        {
            //stampa gli spazi
            for ( j = 0; j <= (size / 2) - i; j++)
            {
                System.out.print(" ");
            }

            // stampa *
            for ( k = 0; k < ((i+1) * 2) - 1; k++)
            {
                System.out.print("*");
            }
            System.out.println("");
        }

        //stampa meta inferiore diamante
        for (i = n ; i  >= 0; i-- )
        {
            //stampa gli spazi
            for ( j = (size / 2) - i; j >= 0; j--)
            {
                System.out.print(" ");
            }

            // stampa *
            for ( k = ((i+1) * 2) - 1; k > 0; k--)
            {
                System.out.print("*");
            }
            System.out.println("");
        }

    }



    public static void TestLoopThree() {
        int i, j, k, n;

        System.out.print("Dimensioni? ");
        Scanner theScan = new Scanner(System.in);
        n = theScan.nextInt();
        int size = (n * 2) - 1;
        int into;


        //Stampa meta superiore diamante
        for (i = 0; i < n; i++ )
        {
            //stampa gli spazi
            for ( j = 0; j <= (size / 2) - i; j++)
            {
                System.out.print(" ");
            }

            // stampa *
            for ( k = 0, into = i; k < ((i+1) * 2) - 1; k++, into--)
            {
                System.out.print(Math.abs(into)+1);
            }
            System.out.println("");
        }

        //stampa meta inferiore diamante
        for (i = n ; i  >= 0; i-- )
        {
            //stampa gli spazi
            for ( j = (size / 2) - i; j >= 0; j--)
            {
                System.out.print(" ");
            }

            // stampa *
            for ( k = ((i+1) * 2) - 1, into = i; k > 0; k--, into-- )
            {
                System.out.print(Math.abs(into)+1);
            }
            System.out.println("");
        }

    }

    public static void main (String[] args) {
        TestLoopOne();
        TestLoopTwo();
        TestLoopThree();

    }
}
