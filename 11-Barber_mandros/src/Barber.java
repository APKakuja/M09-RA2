public class Barber extends Thread {

    private String nom;
    private Barberia barberia;

    public Barber(String nom, Barberia barberia) {
        this.nom = nom;
        this.barberia = barberia;
    }

    @Override
    public void run() {
        while (true) {

            Client c = barberia.seguentClient();

            if (c != null) {
                System.out.println("Li toca al client " + c.getNom());
                System.out.println("Tallant cabell a " + c.getNom());

                try {
                    long temps = 900 + (long)(Math.random() * 100);
                    Thread.sleep(temps);
                } catch (InterruptedException e) {}

                c.tallarseElCabell();

            } else {
                synchronized (barberia.condBarber) {
                    try {
                        System.out.println("Barber " + nom + " dormint");
                        barberia.condBarber.wait();
                    } catch (InterruptedException e) {}
                }
            }
        }
    }
}
