import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Forquilla {

    private final int numero;
    private final Lock bloqueig = new ReentrantLock();

    public Forquilla(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void agafar() {
        bloqueig.lock();
    }

    public void deixar() {
        bloqueig.unlock();
    }
}
