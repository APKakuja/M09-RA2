public class Forquilla {

    public static final int LLIURE = -1;

    private final int numero;      
    private int propietari;     

    public Forquilla(int numero) {
        this.numero = numero;
        this.propietari = LLIURE;
    }

    public int getNumero() {
        return numero;
    }

    public synchronized int getPropietari() {
        return propietari;
    }

    public synchronized void setPropietari(int propietari) {
        this.propietari = propietari;
    }

    public synchronized boolean isEnUs() {
        return propietari != LLIURE;
    }

    public synchronized void agafar(int id) throws InterruptedException {
        while (propietari != LLIURE) {
            wait();
        }
        propietari = id;
    }

    public synchronized void deixar() {
        propietari = LLIURE;
        notifyAll();
    }
}
