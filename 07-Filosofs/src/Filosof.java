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

    public void pensar() { 
        try { 
        System.out.println("Filòsof: " + nom + " pensant");
         Thread.sleep((long)(1000 + Math.random() * 1000)); 
    } catch (InterruptedException e) {} 

    }

    private void esperar() { 
        try { Thread.sleep((long)(500 + Math.random() * 500)); 
        } 
        catch (InterruptedException e) {}
     }

    public void menjar() {

    while (true) {

        if (!forquillaEsquerra.isenUs()) {
            forquillaEsquerra.setEnUs(true);
            System.out.println("Filòsof: " + nom + " agafa la forquilla esquerra " + forquillaEsquerra.getForquilla());
        } else {
            gana++;
            esperar();
            continue;
        }

        if (!forquillaDreta.isenUs()) {
            forquillaDreta.setEnUs(true);
            System.out.println("Filòsof: " + nom + " agafa la forquilla dreta " + forquillaDreta.getForquilla());
        } else {
            System.out.println("Filòsof: " + nom + " deixa l'esquerra(" + forquillaEsquerra.getForquilla() + ") i espera (dreta ocupada)");
            forquillaEsquerra.setEnUs(false);
            gana++;
            esperar();
            continue;
        }

        try {
            System.out.println("Filòsof: " + nom + " menja");
            gana = 0;
            Thread.sleep((long)(1000 + Math.random() * 1000)); // 1–2s
        } catch (InterruptedException e) {}

        forquillaEsquerra.setEnUs(false);
        forquillaDreta.setEnUs(false);

        System.out.println("Filòsof: " + nom + " ha acabat de menjar");
        break;
    }
}

@Override
public void run() {
    while (true) {
        pensar();
        menjar();
    }
}

}
