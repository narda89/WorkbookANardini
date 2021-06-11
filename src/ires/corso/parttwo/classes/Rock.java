package ires.corso.parttwo.classes;

public class Rock {

    private double weight;
    private double volume;
    private String type;
    private boolean smashed;

    //Rock constructor, smashed set to false since it's a brand new rock
    public Rock (double weight, double volume, String type) {
        this.weight = weight;
        this.volume = volume;
        this.type = type;
        this.smashed = false;
    }

    // get - set

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isSmashed() {
        return smashed;
    }

    public void smashIt() {
        if (smashed)
            System.out.println("Rock is already smashed");
        else
            this.smashed = true;
    }

    public void prettyPrint() {
        String info = new String();

        info += System.out.format(  "Type:\t\t%s\n"         +
                "Weight:\t\t%f kg\n"    +
                "Volume:\t\t%f dm^3\n", getType(), getWeight(), getVolume());
        if ( isSmashed() ) {
            info += System.out.format("Status:\t\tbroken\n");
        } else {
            info += System.out.format("Status:\t\tintact\n");
        }
    }

}
