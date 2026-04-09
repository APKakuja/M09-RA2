import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class BanyUnisex {
    public static final int BANY_BUIT = 0;
    public static final int BANY_AMB_HOMES = 1;
    public static final int BANY_AMB_DONES = 2;
    public static final int CAPACITAT_MAX = 3;

    private int estatActual = BANY_BUIT;
    private int ocupants = 0;
    private final Semaphore capacitat = new Semaphore(CAPACITAT_MAX, true);
    private final ReentrantLock lockEstat = new ReentrantLock(true);


    public void entraHome() {
        while (true) {
            lockEstat.lock();
            try {
                if (estatActual == BANY_BUIT || estatActual == BANY_AMB_HOMES) {
                    if (capacitat.tryAcquire()) {
                        if (estatActual == BANY_BUIT) {
                            estatActual = BANY_AMB_HOMES;
                        }
                        ocupants++;
                        System.out.println("Home entra al bany. Ocupants: " + ocupants);
                        return;
                    }
                }
            } finally {
                lockEstat.unlock();
            }

            esperaBreu();
        }
    }


    public void entraDona() {
        while (true) {
            lockEstat.lock();
            try {
                if (estatActual == BANY_BUIT || estatActual == BANY_AMB_DONES) {
                    if (capacitat.tryAcquire()) {
                        if (estatActual == BANY_BUIT) {
                            estatActual = BANY_AMB_DONES;
                        }
                        ocupants++;
                        System.out.println("Dona entra en el bany. Ocupants: " + ocupants);
                        return;
                    }
                }
            } finally {
                lockEstat.unlock();
            }

            esperaBreu();
        }
    }


    private void esperaBreu() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


    public void surtHome() {
        lockEstat.lock();
        try {
            ocupants--;
            System.out.println("Home surt del bany. Ocupants: " + ocupants);
            capacitat.release();
            if (ocupants == 0) {
                estatActual = BANY_BUIT;
                System.out.println("El bany està buit");
            }
        } finally {
            lockEstat.unlock();
        }
    }


    public void surtDona() {
        lockEstat.lock();
        try {
            ocupants--;
            System.out.println("Dona surt del bany. Ocupants: " + ocupants);
            capacitat.release();
            if (ocupants == 0) {
                estatActual = BANY_BUIT;
                System.out.println("El bany està buit");
            }
        } finally {
            lockEstat.unlock();
        }
    }


    public static void main(String[] args) {
        BanyUnisex bany = new BanyUnisex();
        Thread[] fils = new Thread[10];

        for (int i = 0; i < 5; i++) {
            fils[i] = new Home("Home-" + i, bany);
            fils[i + 5] = new Dona("Dona-" + i, bany);
        }

        for (Thread fil : fils) {
            fil.start();
        }

        for (Thread fil : fils) {
            try {
                fil.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
