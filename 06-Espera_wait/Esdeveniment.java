import java.util.ArrayList;
import java.util.List;

public class Esdeveniment {
    
    private List<Assistent> assistents = new ArrayList<>();
    private int placesDisponibles;

    public Esdeveniment(int placesMax) {
        this.placesDisponibles = placesMax;
    }

    synchronized  void ferReserva(Assistent a) {
        while (placesDisponibles == 0) {
            try {
                wait();
        } catch (InterruptedException e) {}
    }
    assistents.add(a);
    placesDisponibles--;
  }

  synchronized void cancelaReserva(Assistent a) {
    while (assistents.contains(a)) {
        assistents.remove(a);
        placesDisponibles++;

        notifyAll();
    }

  }
}
