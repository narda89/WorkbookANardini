package ires.corso.parttwo.classes.geometric;

public class Triangolo extends MasterShape {

    // nb: base per convenzione coincide con lato1, l'altezza è quella riferita a detta base
    private double lato1;
    private double lato2;
    private double lato3;

    //metodi in override
    @Override
    // usando la formula di Erone
    public double computeArea() {
        double semiPerimetro = (computePerimeter())/2.0;
        return Math.sqrt(semiPerimetro * (semiPerimetro - this.lato1) * (semiPerimetro - this.lato2) * (semiPerimetro - this.lato3) );
    }

    @Override
    public double computePerimeter() {
        return this.lato1 + this.lato2 + this.lato3;
    }

    // computeArea e computePerimeter sono anche stati implementati in forma static
    // in quanto usati nel metodo di controllo isATrapezio della classe trapezio
    public static double computePerimeter(double lato1, double lato2, double lato3) {
        return lato1 + lato2 + lato3;
    }

    public static double computeArea(double lato1, double lato2, double lato3) {
        double semiPerimetro = (computePerimeter(lato1, lato2, lato3))/2.0;
        return Math.sqrt(semiPerimetro * (semiPerimetro - lato1) * (semiPerimetro - lato2) * (semiPerimetro - lato3) );
    }

    // funzione che controlla se i valori forniti in input sono compatibili con un triangolo
    public static boolean isATriangle(double lato1, double lato2, double lato3) {

        //controllo preventivo
        if ( !(lato1 > 0 && lato2 > 0 && lato3 > 0) )
            return false;

        double lato[] = new double[3];
        lato[0] = lato1;
        lato[1] = lato2;
        lato[2] = lato3;

        // se almeno uno dei tre lati è maggiore ( uguale ) al semiperimetro, allora i valori
        // non sono compatibili con i valori di lato di un triangolo (ho un triangolo degenere)

        for (int i = 0; i < 3; i++) {
            if ( lato[i] >= computePerimeter(lato1, lato2, lato3)/2 )
                return false;
        }
        return true;
    }

    // costruttore
    public Triangolo (double lato1, double lato2, double lato3) {
        this.lato1 = lato1;
        this.lato2 = lato2;
        this.lato3 = lato3;
    }

    // metodi get - set
    public double getLato1() {
        return lato1;
    }

    public void setLato1(double lato1) {
        this.lato1 = lato1;
    }

    public double getLato2() {
        return lato2;
    }

    public void setLato2(double lato2) {
        this.lato2 = lato2;
    }

    public double getLato3() {
        return lato3;
    }

    public void setLato3(double lato3) {
        this.lato3 = lato3;
    }

}
