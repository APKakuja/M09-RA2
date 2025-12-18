

public class Fil extends Thread {
    private String nom;
    private int iteracions;
    private int prioritat;
    private int delayMs;
    private int bucleSimulacio;
   
    public Fil(String nom, int iteracions, int prioritat, int delayMs, int bucleSimulacio) {
        this.nom = nom;
        this.iteracions = iteracions;
        this.prioritat = prioritat;
        this.delayMs = delayMs;
        this.bucleSimulacio = bucleSimulacio;
        
        this.setPriority(prioritat);
    }
    
    @Override
    public void run() {
        try {
            for (int i = 1; i <= iteracions; i++) {
                
                for (int j = 0; j < bucleSimulacio; j++) {
                    Math.sqrt(j); 
                }
                
                System.out.println(nom + " " + i);
                
                if (delayMs > 0) {
                    Thread.sleep(delayMs);
                }
            }
            
            System.out.println("Acaba el fil " + nom);
            
        } catch (InterruptedException e) {
            System.err.println("El fil " + nom + " ha estat interromput");
        }
    }
}