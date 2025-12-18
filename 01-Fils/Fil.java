public class Fil extends Thread {

    private String nom;
    private int iteracions;
    private int bucleSimulacio;
    private int delayMs;
    private boolean estricte;

    private static final Object lock = new Object();
    private static boolean tornJuan = true;

    public Fil(String nom, int iteracions, int prioritat, int bucleSimulacio, int delayMs, boolean estricte) {
        this.nom = nom;
        this.iteracions = iteracions;
        this.bucleSimulacio = bucleSimulacio;
        this.delayMs = delayMs;
        this.estricte = estricte;
        this.setPriority(prioritat);
    }

    @Override
    public void run() {
        if (estricte) {
            for (int i = 1; i <= iteracions; i++) {
                synchronized (lock) {
                    while ((nom.equals("Juan") && !tornJuan) || (nom.equals("Pepe") && tornJuan)) {
                        try { lock.wait(); } catch (InterruptedException e) {}
                    }
                    System.out.println(nom + " " + i);
                    tornJuan = !tornJuan;
                    lock.notifyAll();
                }
                try { Thread.sleep(delayMs); } catch (InterruptedException e) {}
            }
            System.out.println("Termina el fil " + nom);
            return;
        }

        for (int i = 1; i <= iteracions; i++) {
            for (int j = 0; j < bucleSimulacio; j++) {
                Math.sqrt(j * j + j); 
            }
            System.out.println(nom + " " + i);
            if (delayMs > 0) {
                try { Thread.sleep(delayMs); } catch (InterruptedException e) {}
            }
        }
        System.out.println("Acaba el fil " + nom);
    }
}
