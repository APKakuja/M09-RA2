public class Filosof extends Thread {

    private String nom;
    private int id;
    private Forquilla forquillaEsquerra;
    private Forquilla forquillaDreta;
    private int gana;



    public Filosof(int id, Forquilla esquerra, Forquilla dreta) {

        this.nom = "fil"+id;
        this.id = id;
        this.forquillaEsquerra = esquerra;
        this.forquillaDreta = dreta;
        this.gana = 0;
    }
    public String getNom() {
        return nom;
    }

    public Forquilla forquillaEsquerra() {
        return forquillaEsquerra;
    }

    public Forquilla forquillaDreta() {
        return forquillaDreta;
    }
    
    public synchronized void menjar() {

    }   

    public synchronized void pensar() {


    }

@Override
    public void run() {

    }
}
