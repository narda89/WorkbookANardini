package ires.corso.parttwo.classes.geometric;

public class Triangolo extends MasterShape {

    // nb: base per convenzione coincide con lato1, l'altezza è quella riferita a detta base
    private double altezza;
    private double lato1;
    private double lato2;
    private double lato3;

    //metodi in override
    @Override
    public double computeArea() {
        return this.lato1 * this.altezza / 2.0;
    }

    @Override
    public double computePerimeter() {
        return this.lato1 + this.lato2 + this.lato3;
    }

    // costruttore
    public Triangolo (double lato1, double lato2, double lato3, double altezza) {
        this.lato1 = lato1;
        this.lato2 = lato2;
        this.lato3 = lato3;
        this.altezza = altezza;
    }

    // metodi get - set
    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

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
