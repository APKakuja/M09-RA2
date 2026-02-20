public class Filosof {
    
    private final String nom;
    private final int id;
    private final Forquilla esquerra;
    private final Forquilla dreta;
    private int gana;

    public Filosof(int id, Forquilla esquerra, Forquilla dreta) {
        this.id = id;
        this.nom = "Fil" + id;
        this.esquerra = esquerra;
        this.dreta = dreta;
        this.gana = 0;
    }
}
