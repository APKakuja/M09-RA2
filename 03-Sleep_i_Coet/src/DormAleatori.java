

public class DormAleatori extends Thread {

    public int num_iteracio = 10;
    public static int dormilones = 2;


    public long temps_total;
    public long temps_creacio;

    public DormAleatori(String nom) {
        super(nom);
        this.temps_creacio = System.currentTimeMillis();
        
    }

@Override


public void run() {

    for(int i = 0; i < num_iteracio; i++){
    
       int interval_aleatori = (int)(Math.random() * 1000);

       temps_total = System.currentTimeMillis() - temps_creacio;

       System.out.println(getName() + "(" + i + ") a dormir " + interval_aleatori + "ms total " + temps_total + "ms");



       try {
        Thread.sleep(interval_aleatori);
       } catch (InterruptedException e) { 
        e.printStackTrace(); }


        }
    }

}



