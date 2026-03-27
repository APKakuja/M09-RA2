import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BanyUnisex {
    public static final int BANY_BUIT = 0;
    public static final int BANY_AMB_HOMES = 1;
    public static final int BANY_AMB_DONES = 2;
    private int estatActual = BANY_BUIT;
    public int ocupants = 0;
    private static final int CAPACITAT_MAX = 3;
    private final Semaphore capacitat = new Semaphore(CAPACITAT_MAX, true);
    private final Lock lockEstat = new ReentrantLock();


    public void entraHome() {
        if (capacitat.tryAcquire()) {
            lockEstat.lock();
            try {
                if (estatActual == BANY_BUIT) {
                    estatActual = BANY_AMB_HOMES;
                }
                ocupants++;
                System.out.println("Entra home. Ocupants: " + ocupants + ", Estado: " + estatActual);
            } finally {
                lockEstat.unlock();
            }
        }
    }


     public void entraDona() {
        if (capacitat.tryAcquire()) {
            lockEstat.lock();
            try {
                if (estatActual == BANY_BUIT) {
                    estatActual = BANY_AMB_DONES;
                }
                ocupants++;
                System.out.println("Entran les dones. Ocupants: " + ocupants + ", Estado: " + estatActual);    
            } finally {
                lockEstat.unlock();
            }
        }
    }


    public void surtHome() {
        if (capacitat.tryAcquire()) {
            lockEstat.lock();
            try {
                if (estatActual == BANY_AMB_HOMES)
                    ocupants --;
                System.out.println("Sortint home. Ocupant: " + ocupants + ", Estado: " + estatActual);
            } finally {
                lockEstat.unlock();
            }
        }
    }
}
