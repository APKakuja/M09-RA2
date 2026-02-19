public class Filosof extends Thread {

    private final String nom;
    private final int id;
    private final Forquilla esquerra;
    private final Forquilla dreta;
    private int gana;

    public Filosof(int id, Forquilla esquerra, Forquilla dreta) {
        this.id = id;
        this.nom = "Fil" + id;
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
        try {
            esquerra.agafar(id);
            System.out.println(nom + " agafa la forquilla esquerra " + esquerra.getNumero());
        } catch (InterruptedException e) {}
    }

    public void agafarForquillaDreta() {
        try {
            dreta.agafar(id);
            System.out.println(nom + " agafa la forquilla dreta " + dreta.getNumero());
        } catch (InterruptedException e) {}
    }

    public void agafarForquilles() {
        agafarForquillaEsquerra();
        agafarForquillaDreta();
    }

    public void deixarForquilles() {
        esquerra.deixar();
        dreta.deixar();
        System.out.println(nom + " deixa les forquilles");
    }


    private void pensar() {
        try {
            gana++;
            System.out.println(nom + " pensant...");
            Thread.sleep((long)(1000 + Math.random() * 1000));
        } catch (InterruptedException e) {}
    }

    private void menjar() {
        agafarForquilles();

        try {
            System.out.println(nom + " MENJANT");
            Thread.sleep((long)(1000 + Math.random() * 1000));
        } catch (InterruptedException e) {}

        deixarForquilles();
    }

    @Override
    public void run() {
        while (true) {
            pensar();
            menjar();
        }
    }
}
