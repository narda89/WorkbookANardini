package ires.corso.parttwo.classes;

public class Human {

    private int weight;
    private int height;
    private int age;
    private String name;
    private boolean alive;
    private char gender;

    // Human Class constructor <==> birth
    public Human ( int weight, int height, String name, char gender ) { //age set at 0 at birth, status set to alive
        this.weight = weight;
        this.height = height;
        this.age = 0;
        this.name = name;
        this.alive = true;
        this.gender = gender;
    }

    // get - set
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean status) {
        this.alive = status;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        if ( this.gender == 'M' && gender == 'F') {
            System.out.println("Zac!");
            this.gender = gender;       //you're a pretty girl now!
        } else if( this.gender == 'F' && gender == 'M' ) {
            System.out.println("Puf!");
            this.gender = gender;       //you're a pretty boy now!
        } else {
            System.out.println("Nothing changed!");
        }
    }

    public void prettyPrint () {

        String info = new String();

        info += System.out.format(  "Name:\t\t%s\n"         +
                "Age:\t\t%d years\n"    +
                "Weight:\t\t%d kg\n"    +
                "Height:\t\t%d cm\n"    +
                "Gender:\t\t%c\n", getName(), getAge(), getWeight(), getHeight(), getGender());
        if ( isAlive() ) {
            info += System.out.format("Status:\t\talive\n");
        } else {
            info += System.out.format("Status:\t\tdeceased\n");
        }
    }
}
