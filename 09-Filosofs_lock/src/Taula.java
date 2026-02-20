import java.util.ArrayList;
import java.util.List;

public class Taula {

    private List<Filosof> comensals = new ArrayList<>();
    private List<Forquilla> forquilles = new ArrayList<>();

    public Taula(int numFilosofs) {

        for (int i = 0; i < numFilosofs; i++) {
            forquilles.add(new Forquilla(i));
        }

        for (int i = 0; i < numFilosofs; i++) {
            Forquilla esquerra = forquilles.get(i);
            Forquilla dreta = forquilles.get((i + 1) % numFilosofs);

            comensals.add(new Filosof(i, esquerra, dreta));
        }
    }

    public void showTaula() {
        for (Filosof f : comensals) {
            System.out.println(
                f.getNom() +
                " | Esq: " + f.getForquillaEsquerra().getNumero() +
                " | Dreta: " + f.getForquillaDreta().getNumero()
            );
        }
    }

    public void cridarATaula() {
        for (Filosof f : comensals) {
            f.start();
        }
    }

    public static void main(String[] args) {
        Taula t = new Taula(5);
        t.showTaula();
        t.cridarATaula();
    }
}