package ires.corso.parttwo.WB210617;

public class Eroe
        implements Umano
{
    protected int forza;

    public Eroe()
    {
        forza= 10;
    }

    public void combatti()
    {
        forza -= 3;
    }

    public String getForza ()
    {
        return "Eroe - Forza rimanente: " + forza;
    }
}
