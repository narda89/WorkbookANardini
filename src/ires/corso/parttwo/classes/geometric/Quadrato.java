package ires.corso.parttwo.classes.geometric;

public class Quadrato extends MasterShape {

    private double lato;

    // metodi in override
    @Override
    public double computeArea() {
        return this.lato * this.lato;
    }

    @Override
    public double computePerimeter() {
        return this.lato * 4;
    }

    // costruttore
    public Quadrato (double lato) {
        this.lato = lato;
    }

    // metodi get - set
    public double getLato() {
        return lato;
    }

    public void setLato(double lato) {
        this.lato = lato;
    }
}
