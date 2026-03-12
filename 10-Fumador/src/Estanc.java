import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Estanc extends Thread {

    private final List<Tabac> tabac;
    private final List<Paper> paper;
    private final List<Llumi> llumi;
    private boolean obert = true;
    private final Random r = new Random();

    public Estanc() {
        tabac = new ArrayList<>();
        paper = new ArrayList<>();
        llumi = new ArrayList<>();
    }

    public synchronized void addTabac() {
        tabac.add(new Tabac());
        System.out.println("Afegint tabac");
        notifyAll();
    }

    public synchronized void addPaper() {
        paper.add(new Paper());
        System.out.println("Afegint Paper");
        notifyAll();
    }

    public synchronized void addLlumi() {
        llumi.add(new Llumi());
        System.out.println("Afegint Llumí");
        notifyAll();
    }

    public synchronized void nouSubministrament() {
        int num = r.nextInt(3);
        if (num == 0) {
            addTabac();
        } else if (num == 1) {
            addPaper();
        } else {
            addLlumi();
        }
    }

    public synchronized Tabac venTabac() {
        while (tabac.isEmpty() && obert) {
            try {
                wait();
            } catch (InterruptedException e) {
                return null;
            }
        }
        if (!obert || tabac.isEmpty()) return null;
        return tabac.remove(0);
    }

    public synchronized Paper venPaper() {
        while (paper.isEmpty() && obert) {
            try {
                wait();
            } catch (InterruptedException e) {
                return null;
            }
        }
        if (!obert || paper.isEmpty()) return null;
        return paper.remove(0);
    }

    public synchronized Llumi venLlumi() {
        while (llumi.isEmpty() && obert) {
            try {
                wait();
            } catch (InterruptedException e) {
                return null;
            }
        }
        if (!obert || llumi.isEmpty()) return null;
        return llumi.remove(0);
    }

    public void run() {
        System.out.println("Estanc obert");
        while (true) {
            synchronized (this) {
                if (!obert) break;
            }
            nouSubministrament();
            int temps = 500 + r.nextInt(1000); // 0.5–1.5 s
            try {
                Thread.sleep(temps);
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println("Estanc tancat");
    }

    public synchronized void tancarEstanc() {
        obert = false;
        notifyAll();
    }
}
