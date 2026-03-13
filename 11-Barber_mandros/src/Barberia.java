import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Barberia extends Thread {

    private static Barberia instancia;
    private int cadires;
    private int maxCadires;
    Object condBarber = new Object();

    public Barberia(int numCadires) {
        this.cadires = numCadires;
        this.maxCadires = numCadires + 5;
    }

    public int getCadires() {
        return cadires;
    }

    public int getMaxCadires() {
        return maxCadires;
    }

    Queue<Client> salaEspera = new LinkedList<>();

    public void esperar() {
    Random rand = new Random();
    int id = rand.nextInt(6) + 5;
    salaEspera.add(new Client(id));
}

    public void barberoEspera() {
        synchronized(condBarber) {  
            try {
                condBarber.wait();  
            } catch (InterruptedException e) {}
        }
    }

    public void entrarClient(Client c) {
        if (salaEspera.size() < maxCadires) {
            salaEspera.add(c);
            System.out.println(c.getNom() + " Entra a la barberia ");

            synchronized(condBarber) {
                condBarber.notify();
            }

        }  else {
            System.out.println(c.getNom() + " no pot entrar");
        }
    }
}
