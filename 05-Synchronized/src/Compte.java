public class Compte {

    private static Compte instancia;
    private float saldo;

    private Compte() {
        this.saldo = 0.0f;
    }

    public static synchronized Compte getInstance() {
        if (instancia == null) {
            instancia = new Compte();
        }
        return instancia;
    }

    public synchronized void ingresa(float quantitat) {
        saldo += quantitat;
    }

    public synchronized void retira(float quantitat) {
        saldo -= quantitat;
    }

    public synchronized float getSaldo() {
        return saldo;
    }

}
