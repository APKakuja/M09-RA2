
import java.util.Random;

public class Soci extends Thread {

    private Compte compte;
    private final float aportacio = 10f;
    private final int esperaMax = 100;
    private Random rnd;

    public Soci() {
        this.compte = Compte.getInstance();
        this.rnd = new Random();
    }

@Override
public void run() {
    for (int mes = 1; mes <= 12; mes++) {

        if (mes % 2 == 0) {
            compte.ingresa(aportacio);
        } else {
            compte.retira(aportacio);
        }

        try {
            Thread.sleep(rnd.nextInt(esperaMax));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

}
