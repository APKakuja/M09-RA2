public class Barber extends Thread {
    private String nom;
    private Barberia barberia;
    
    public Barber(String nom, Barberia barberia) {
        this.nom = nom;
        this.barberia = barberia;
    }


    @Override
public void run() {
    while (true) {
        Client cliente = barberia.seguentClient();
        
        if (cliente != null) {
            System.out.println(nom + " está cortando a " + cliente.getNom());
            
            try {
                long tiempo = 900 + (long)(Math.random() * 100);
                Thread.sleep(tiempo);
                
                cliente.tallarseElCabell(); 
                
            } catch (InterruptedException e) {}
            
        } else {
            synchronized(barberia.condBarber) {
                try {
                    System.out.println(nom + " está durmiendo...");
                    barberia.condBarber.wait(); 
                    
                } catch (InterruptedException e) {}
            }
        }
    }
}
}