package src;


public class main {

    public static void main(String[] args) {

        Futbolista jugadors[] = new Futbolista[11];
        for (int i = 0; i < 11; i++) {
            jugadors[i] = new Futbolista("Jugador" + (i+1));
        }
   for (Futbolista jugador : jugadors)
    jugador.start();

    }
    
}
