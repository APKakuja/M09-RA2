import java.util.ArrayList;
import java.util.List;

public class Taula {
    
    public List<Filosof> comensals = new ArrayList<>();
    public List<Forquilla> forquilles = new ArrayList<>();

    public Taula(int numFilosofs) {
    
        for (int i = 0; i < numFilosofs; i++) {
            forquilles.add(new Forquilla(i));
        }

        for (int i = 0; i < numFilosofs; i++) {
            Forquilla esquerra = forquilles.get(i);
            Forquilla dreta = forquilles.get((i + 1) % numFilosofs);
            
            Filosof f = new Filosof(i, esquerra, dreta);
            comensals.add(f);
        }
    }

    public void showTaula(List<Filosof> comensals) {
        for (Filosof f : comensals) {
             System.out.println( "Filòsof :" + f.getNom() +
              " | Esquerra: " + f.forquillaEsquerra().getForquilla() + 
              " | Dreta: " + f.forquillaDreta().getForquilla()); 
            }
    }

    public void cridarATaula() {
    for (Filosof f : comensals) {
        f.start();  
       }
    }

    public static void main(String[] args) {
    Taula t = new Taula(5);
    t.showTaula(t.comensals);
    t.cridarATaula();
    }



}
