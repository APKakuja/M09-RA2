

public class Fil extends Thread {
    private String nom;
    private int iteracions;
    private int bucleSimulacio;
    private int delayMs;
    
    public Fil(String nom, int iteracions, int prioritat, int bucleSimulacio, int delayMs) {
        this.nom = nom;
        this.iteracions = iteracions;
        this.bucleSimulacio = bucleSimulacio;
        this.delayMs = delayMs;
        this.setPriority(prioritat);
    }
    
    @Override
    public void run() {
        try {
            for (int i = 1; i <= iteracions; i++) {
                // Simular feina amb el bucle
                for (int j = 0; j < bucleSimulacio; j++) {
                    Math.sqrt(j * j + j);
                }
                
                System.out.println(nom + " " + i);
                
                // Delay si cal
                if (delayMs > 0) {
                    Thread.sleep(delayMs);
                    Thread.yield(); // Cedir explícitament el torn
                }
            }
            System.out.println("Acaba el fil " + nom);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}