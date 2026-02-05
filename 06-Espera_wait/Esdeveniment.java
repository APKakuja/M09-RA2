import java.util.ArrayList;
import java.util.List;

public class Esdeveniment {

    private List<Assistent> assistents = new ArrayList<>();
    private int placesDisponibles;

    public Esdeveniment(int placesMax) {
        this.placesDisponibles = placesMax;
    }

    public synchronized void ferReserva(Assistent a) {
        while (placesDisponibles == 0) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }

        assistents.add(a);
        placesDisponibles--;
        System.out.println(a.getNom() + " ha fet una reserva. Places disponibles: " + placesDisponibles);
    }

    public synchronized void cancelaReserva(Assistent a) {
        if (assistents.contains(a)) {
            assistents.remove(a);
            placesDisponibles++;
            System.out.println(a.getNom() + " ha cancel·lat una reserva. Places disponibles: " + placesDisponibles);
            notifyAll();
        } else {
            System.out.println(a.getNom() + " no ha pogut cancel·lar una reserva inexistent. Places disponibles: " + placesDisponibles);
        }
    }
}
