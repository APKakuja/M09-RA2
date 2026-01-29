public class Associacio {

    private final int numSocis = 1000;
    private Soci[] socis;

    public Associacio() {
        socis = new Soci[numSocis];
        for (int i = 0; i < numSocis; i++) {
            socis[i] = new Soci();
        }
    }

    public void iniciaCompteTempsSocis() {
        for (Soci s : socis) {
            s.start();
        }
    }

    public void esperaPeriodeSocis() {
        for (Soci s : socis) {
            try {
                s.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void mostraBalanceComptes() {
        float saldoFinal = Compte.getInstance().getSaldo();
        System.out.printf("Saldo final del compte: %.2f Euros\n", saldoFinal);
    }

    public static void main(String[] args) {
        Associacio a = new Associacio();
        a.iniciaCompteTempsSocis();
        a.esperaPeriodeSocis();
        a.mostraBalanceComptes();
    }

}
