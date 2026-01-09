package src;

public class main {

    public static void main(String[] args) {

        Futbolista jugadors[] = new Futbolista[Futbolista.NUM_JUGADORS];
        for (int i = 0; i < Futbolista.NUM_JUGADORS; i++) {
            jugadors[i] = new Futbolista("Jugador" + (i+1));
        }
   for (Futbolista jugador : jugadors)
    jugador.start();

    }



    
}
