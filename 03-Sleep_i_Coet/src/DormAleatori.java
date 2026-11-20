public class DormAleatori extends Thread {

    public int interval_aleatori;
    public int num_iteracio;
    public long temps_inici;

    public DormAleatori(String nom) {
        super(nom);
        temps_inici = System.currentTimeMillis();
    }

    public void run() {

        Long temps_total;

        for (int i = 0; i < 10; i++) {
            num_iteracio = i;
            interval_aleatori =  (int)(Math.random() * 1000);

            temps_total = System.currentTimeMillis() - temps_inici;

            System.out.println(getName() + "(" + num_iteracio + ") a dormir " + interval_aleatori + "ms total " + temps_total + "ms");

            try { 
                Thread.sleep(interval_aleatori); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        DormAleatori Joan = new DormAleatori();
    }
}
