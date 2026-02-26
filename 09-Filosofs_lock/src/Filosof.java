import java.time.Instant;

public class Filosof extends Thread {

    private final String nom;
    private final Forquilla esquerra;
    private final Forquilla dreta;

    private long iniciGana;
    private long fiGana;
    private long gana;

    public Filosof(String nom, Forquilla esquerra, Forquilla dreta) {
        this.nom = nom;
        this.esquerra = esquerra;
        this.dreta = dreta;
        this.gana = 0;
    }

    public String getNom() {
        return nom;
    }

    public Forquilla getForquillaEsquerra() {
        return esquerra;
    }

    public Forquilla getForquillaDreta() {
        return dreta;
    }

    public void agafarForquillaEsquerra() {
        esquerra.agafar();
        System.out.println(nom + " agafa la forquilla esquerra " + esquerra.getNumero());
    }

    public void agafarForquillaDreta() {
        dreta.agafar();
        System.out.println(nom + " agafa la forquilla dreta " + dreta.getNumero());
    }

    public void agafarForquilles() {
        agafarForquillaEsquerra();
        agafarForquillaDreta();
    }

    public void deixarForquilles() {
        dreta.deixar();
        esquerra.deixar();
        System.out.println(nom + " deixa les forquilles");
    }

    public void pensar() {
        iniciGana = Instant.now().getEpochSecond();
        System.out.println(nom + " pensant...");
        try {
            Thread.sleep((long)(1000 + Math.random() * 1000));
        } catch (InterruptedException e) {}
    }

    public void menjar() {
        agafarForquilles();

        fiGana = Instant.now().getEpochSecond();
        gana = calcularGana();

        System.out.println(nom + " MENJANT (gana: " + gana + "s)");

        try {
            Thread.sleep((long)(1000 + Math.random() * 1000));
        } catch (InterruptedException e) {}

        deixarForquilles();
        resetGana();
    }

    public long calcularGana() {
        return fiGana - iniciGana;
    }

    public void resetGana() {
        iniciGana = 0;
        fiGana = 0;
        gana = 0;
    }

    @Override
    public void run() {
        while (true) {
            pensar();
            menjar();
        }
    }
}
