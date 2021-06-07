package ires.corso.partone.geometric;

public class Trapezio {
    // Area trapezio: (B + b) * A / 2

    public static double computeArea ( double bmaj, double bmin, double height) {
        double Area = (bmaj + bmin) * height / 2;
        return Area;
    }
}
