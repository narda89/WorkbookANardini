package ires.corso.parttwo.WB210617;

public class Vampiro
        implements Mostro
{
    protected int forza;

    public Vampiro()
    {
        forza=15;
    }

    public void azzanna()
    {
        forza -= 2;
    }

    public String getForza()
    {
        return "Vampiro - Forza rimanente: " + forza;
    }
}
