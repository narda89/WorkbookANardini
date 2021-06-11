package ires.corso.parttwo.WB210610;

import ires.corso.parttwo.classes.Human;
import ires.corso.parttwo.classes.Rock;

public class TestClassGod {

    public static void main(String[] args) {

        Rock r1 = new Rock(12.0, 2.0, "Quarzo");
        r1.prettyPrint();
        System.out.println("--------------------");

        r1.smashIt();
        r1.prettyPrint();
        System.out.println("--------------------");

        r1.smashIt();

        //birth of ciccio
        Human h1 = new Human(4,50, "ciccio", 'M');
        h1.prettyPrint();

        System.out.println("--------------------");

        //ciccio gets older and grows
        h1.setAge(18);
        h1.setHeight(170);
        h1.setWeight(70);
        h1.prettyPrint();

        System.out.println("--------------------");

        //ciccio changes his name
        h1.setName("Pippo");
        h1.prettyPrint();

        System.out.println("--------------------");

        //ciccio changes sex and name
        h1.setGender('F');
        h1.setName("Pippa");
        h1.prettyPrint();

        System.out.println("--------------------");

        //sorry Pippa :(
        h1.setAlive(false);
        h1.prettyPrint();

        System.out.println("--------------------");

        //lets save Pippa :)
        h1.setAlive(true);
        h1.prettyPrint();

        System.out.println("--------------------");

    }
}
