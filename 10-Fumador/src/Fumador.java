public class Fumador extends Thread {

    private int id;
    private int tabac;
    private int paper;
    private int llumi;
    private int fumades;
    private Estanc estanc;

    public Fumador(int id, Estanc estanc) {
        this.id = id;
        this.estanc = estanc;
        this.tabac = 0;
        this.paper = 0;
        this.llumi = 0;
        this.fumades = 0;
    }

    public void compraTabac() {
        Tabac t = estanc.venTabac();
        if (t != null) {
            tabac++;
            System.out.println("Fumador " + id + " comprant Tabac");
        }
    }

    public void compraPaper() {
        Paper p = estanc.venPaper();
        if (p != null) {
            paper++;
            System.out.println("Fumador " + id + " comprant Paper");
        }
    }

    public void compraLlumi() {
        Llumi l = estanc.venLlumi();
        if (l != null) {
            llumi++;
            System.out.println("Fumador " + id + " comprant Llumí");
        }
    }

    private void fuma() {
        if (tabac >= 1 && paper >= 1 && llumi >= 1) {
            tabac--;
            paper--;
            llumi--;
            System.out.println("Fumador " + id + " fumant");
            int temps = 500 + (int)(Math.random() * 500); // 0.5–1 s
            try {
                Thread.sleep(temps);
            } catch (InterruptedException e) {
                return;
            }
            fumades++;
            System.out.println("Fumador " + id + " ha fumat " + fumades + " vegades");
        }
    }

    public void run() {
        while (fumades < 3) {
            compraTabac();
            compraPaper();
            compraLlumi();
            fuma();
        }
    }
}
