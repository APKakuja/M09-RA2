public class Fil extends Thread {
    
    private String nom;
    private int delay;


    public Fil(String nom,int prioritat, int delay) {
        this.nom = nom;
        this.setPriority(prioritat);
        this.delay = delay;
    }

    
@Override
public void run() {

    for (int i = 1; i <= 1000; i++) {

        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
        }

        System.out.println(nom + " " + i);
    }

    System.out.println("Acaba el fil " + nom);
}

}
