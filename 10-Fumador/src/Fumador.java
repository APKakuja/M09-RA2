public class Fumador {
    
    private int id;
    private int tabac;
    private int paper;
    private int llumi;
    private int fumades;
    private Estanc estanc;


    public Fumador(int id, Estanc estanc) {
        id = this.id;
        estanc = this.estanc;
        this.tabac = 0;
        this.paper = 0;
        this.llumi = 0;
        this.fumades = 0;
    }

    public int getid() {
        return id;
    }

    public int gettabac() {
        return tabac;
    }

    public int getpaper() {
        return paper;
    }

    public int gellumi() {
        return llumi;
    }

    public int getfumades() {
        return fumades;
    }

    public Estanc getestanc() {
        return estanc;
    }

    public void compraTabac() {
        
    }

    private synchronized void fuma() {
        if (tabac >= 1 && paper >= 1 && llumi >= 1) { 
            int temps = 500 + (int)(Math.random() * 500);
            try {
            Thread.sleep(temps);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            fumades++;
        }
    }

}
