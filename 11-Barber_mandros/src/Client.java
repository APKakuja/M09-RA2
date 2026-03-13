
public class Client extends Thread {

    private String nom;


    public String getNom() {
        return nom;
    }

    public Client(int id) {
        this.nom = "Client_" + id;
    }

    public void tallarseElCabell() {
        
    }
}