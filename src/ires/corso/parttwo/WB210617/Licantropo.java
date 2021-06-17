package ires.corso.parttwo.WB210617;

public class Licantropo
        implements Umano, Mostro {
    private boolean isUomo;
    protected int forzaUmano, forzaMostro;

    public Licantropo(boolean luna) {
        isUomo = !luna;

        if (luna) {
            forzaMostro = 15;
            forzaUmano = 0;
        } else {
            forzaUmano = 10;
            forzaMostro = 0;
        }
    }

    public String getForza() {
        return "Licantropo - Forza rimanente come Umano: " + forzaUmano + " | Forza rimanente come Mostro: " + forzaMostro;
    }

    public void azzanna() {
        if (!isUomo) {
            forzaMostro -= 2;
        }
    }

    public void combatti() {
        if (isUomo) {
            forzaUmano -= 3;
        }
    }
}
