package ires.corso.partone.WB210608;

import java.util.Scanner;

public class LoopTest {

    public static void main (String[] args) {
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
}
