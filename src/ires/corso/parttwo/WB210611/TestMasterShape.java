package ires.corso.parttwo.WB210611;

import ires.corso.parttwo.classes.geometric.*;

public class TestMasterShape {

    public static void main (String[] args) {

        Quadrato q1 = new Quadrato(5.0);
        System.out.printf("L'area del quadrato è pari a %f.\n", q1.computeArea());
        System.out.printf("Il perimetro del quadrato è pari a %f.\n", q1.computePerimeter());

        Quadrato q2 = new Quadrato(6.0);
        System.out.printf("L'area del quadrato è pari a %f.\n", q2.computeArea());
        System.out.printf("Il perimetro del quadrato è pari a %f.\n", q2.computePerimeter());

        Quadrato q3 = new Quadrato(4.0);
        System.out.printf("L'area del quadrato è pari a %f.\n", q3.computeArea());
        System.out.printf("Il perimetro del quadrato è pari a %f.\n", q3.computePerimeter());

        Triangolo t1 = new Triangolo(1.0, 1.5, 1.5, 2.0);
        System.out.printf("L'area del triangolo è pari a %f.\n", t1.computeArea());
        System.out.printf("Il perimetro del triangolo è pari a %f.\n", t1.computePerimeter());

        Triangolo t2 = new Triangolo(2.0, 3.0, 3.0, 2.0);
        System.out.printf("L'area del triangolo è pari a %f.\n", t2.computeArea());
        System.out.printf("Il perimetro del triangolo è pari a %f.\n", t2.computePerimeter());

        Trapezio trap1 = new Trapezio(2.0, 1.0, 2.0, 1.5, 1.3);
        System.out.printf("L'area del trapezio è pari a %f.\n", trap1.computeArea());
        System.out.printf("Il perimetro del trapezio è pari a %f.\n", trap1.computePerimeter());


        MasterShape[] sommaAreePerimetri = new MasterShape[6];
        sommaAreePerimetri[0] = q1;
        sommaAreePerimetri[1] = q2;
        sommaAreePerimetri[2] = q3;
        sommaAreePerimetri[3] = t1;
        sommaAreePerimetri[4] = t2;
        sommaAreePerimetri[5] = trap1;

        double sommaA = 0.0;

        for (int i = 0; i < sommaAreePerimetri.length; i++) {
            sommaA += sommaAreePerimetri[i].computeArea();
        }

        System.out.printf("La somma delle aree è pari a: %f.\n", sommaA);

        double sommaP = 0.0;

        for (int i = 0; i < sommaAreePerimetri.length; i++) {
            sommaP += sommaAreePerimetri[i].computePerimeter();
        }

        System.out.printf("La somma dei perimetri è pari a: %f.\n", sommaP);
    }
}

