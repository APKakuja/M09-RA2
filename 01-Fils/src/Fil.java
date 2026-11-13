public class Fil extends Thread {
    
    private String nom;
    private int delay;

    public Fil(String nom, int delay, int prioritat) {
        this.delay = delay;
        this.nom = nom;
        this.setPriority(prioritat);
    }


    @Override 

    public void run() {
            for (int i = 0; i < 1000; i++) {

                for (int j = 0; j < delay; j++) {

                }
                System.out.println(nom + " " + i);
            }
            System.out.println("Acaba el fil " + nom);
    }

}
