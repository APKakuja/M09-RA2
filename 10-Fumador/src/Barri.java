public class Barri {

    private Estanc estanc;
    private Fumador[] fumadors;

    public Barri() {
        estanc = new Estanc();
        fumadors = new Fumador[3];

        fumadors[0] = new Fumador(0, estanc);
        fumadors[1] = new Fumador(1, estanc);
        fumadors[2] = new Fumador(2, estanc);

        estanc.start();
        for (Fumador f : fumadors) {
            f.start();
        }

        for (Fumador f : fumadors) {
            try {
                f.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        estanc.tancarEstanc();
    }

    public static void main(String[] args) {
        new Barri();
    }
}
