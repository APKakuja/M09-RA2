import java.util.LinkedList;
import java.util.Queue;

public class Barberia extends Thread {

    public static Barberia instancia;

    private int maxCadires;
    Queue<Client> salaEspera = new LinkedList<>();
    Object condBarber = new Object();

    public Barberia(int numCadires) {
        this.maxCadires = numCadires;
    }

    public Client seguentClient() {
        synchronized (salaEspera) {
            if (salaEspera.isEmpty()) {
                System.out.println("Ningú en espera");
                return null;
            }
            return salaEspera.poll();
        }
    }

    public void entrarClient(Client c) {
        synchronized (salaEspera) {
            if (salaEspera.size() < maxCadires) {
                salaEspera.add(c);
                System.out.println("Client " + c.getNom() + " en espera");

                synchronized (condBarber) {
                    condBarber.notify();
                }

            } else {
                System.out.println("No queden cadires, client " + c.getNom() + " se'n va");
            }
        }
    }

    @Override
    public void run() {

        for (int i = 1; i <= 10; i++) {
            entrarClient(new Client(i));
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }

        try { Thread.sleep(10000); } catch (InterruptedException e) {}

        for (int i = 11; i <= 20; i++) {
            entrarClient(new Client(i));
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }
    }

    public static void main(String[] args) {

        instancia = new Barberia(3);

        Barber barber = new Barber("Pepe", instancia);

        barber.start();
        instancia.start();
    }
}
