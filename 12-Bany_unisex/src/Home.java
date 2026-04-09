import java.util.concurrent.ThreadLocalRandom;

public class Home extends Thread {
    private final String nom;
    private final BanyUnisex bany;

    public Home(String nom, BanyUnisex bany) {
        this.nom = nom;
        this.bany = bany;
        setName(nom);
    }

    @Override
    public void run() {
        System.out.println(nom + " vol entrar al bany");
        bany.entraHome();

        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2001));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            bany.surtHome();
            System.out.println(nom + " ha acabat d'usar el bany");
        }
    }
}
