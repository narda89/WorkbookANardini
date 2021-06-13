package ires.corso.parttwo.classes.geometric;

public class Trapezio extends MasterShape {
    private double bMaj;
    private double bMin;
    private double altezza;
    private double cateto1;
    private double cateto2;

    // metodi in override
    @Override
    public double computeArea() {
        return (this.bMaj + this.bMin) * this.altezza / 2.0;
    }

    @Override
    public double computePerimeter() {
        return this.bMaj + this.bMin + this.cateto1 + this.cateto2;
    }

    // costruttore
    public Trapezio (double bMaj, double bMin, double altezza, double cateto1, double cateto2) {
        this.bMaj    = bMaj;
        this.bMin    = bMin;
        this.altezza = altezza;
        this.cateto1 = cateto1;
        this.cateto2 = cateto2;
    }

    // metodi get - set

    public double getbMaj() {
        return bMaj;
    }

    public void setbMaj(double bMaj) {
        this.bMaj = bMaj;
    }

    public double getbMin() {
        return bMin;
    }

    public void setbMin(double bMin) {
        this.bMin = bMin;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }
}
