package src;

public class main {

    public static void main(String[] args) {

         String[] nombres = {
            "Piqué",
            "Vinicius", 
            "Torres",
            "Ramos",
            "Ronaldo",
            "Lewandowski",
            "Bellic",
            "Arnau",
            "Aspas",
            "Messi",
            "Mbappé"
        };

        Futbolista jugadors[] = new Futbolista[Futbolista.NUM_JUGADORS];
        for (int i = 0; i < Futbolista.NUM_JUGADORS; i++) {
            jugadors[i] = new Futbolista(nombres[i]);
        }

   for (Futbolista jugador : jugadors){
    jugador.start();
    }  

    System.out.println("*** Inici dels xuts ***");

    
    for (Futbolista jugador : jugadors) {
        try {
            jugador.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    System.out.println("!! Final dels xuts !!");

    System.out.println("Estadistiques");
    for (Futbolista jugador : jugadors){
        System.out.println(jugador.getName() + " > " + jugador.getNGols() + "gols");
    }

  }
}
