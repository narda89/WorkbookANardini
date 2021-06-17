package ires.corso.parttwo.WB210617;

public class RpgGame {

    public static void main (String [] args)
    {
        Eroe e = new Eroe();
        Licantropo l = new Licantropo(true);
        Vampiro v = new Vampiro();

        e.combatti();
        e.combatti();
        e.combatti();

        v.azzanna();

        l.azzanna();
        l.azzanna();

        System.out.println(v.getForza());
        System.out.println(l.getForza());
        System.out.println(e.getForza());

        return;
    }
}
