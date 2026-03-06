import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Estanc {
    

    private final List<Tabac> tabaco;
    private final List<Paper> paper;
    private final List<Llumi> llumi;
    private boolean obert = true;


    public Estanc() { 
        tabaco = new ArrayList<>(); 
        llumi = new ArrayList<>(); 
        paper = new ArrayList<>(); 
    }

    public List<Llumi> getLlumi() {
        return llumi;
    }

    public List<Tabac> getTabac() {
        return tabaco;
    }

    public List<Paper> getPaper() {
        return paper;
    }


    public void addTabac() {
        Tabac t = new Tabac();
        tabaco.add(t);
    }

   public void addPaper() {
        Paper p = new Paper();
        paper.add(p);
   }

   public void addLlumi() {
        Llumi l = new Llumi();
        llumi.add(l);
   }


    public void nouSubministrament() {
        Random r = new Random();
        int num = r.nextInt(3);

        if (num == 0 ) {
            addTabac();
        } else if (num == 1 ) {
            addPaper();
        } else 
            addLlumi();
    }


    public Tabac venTabac() {
    if (tabaco.isEmpty()) {
        return null;
    }

    Tabac t = tabaco.get(0);
    tabaco.remove(0);

    return t;
}

    public Paper venPaper() {
        if (paper.isEmpty()) {
            return null;
        }

        Paper p = paper.get(0);
        paper.remove(0);

        return p;
    }


public void run() {
    while (obert) {
        nouSubministrament();
         int temps = 500 + (int)(Math.random() * 500); 
        try {
            Thread.sleep(temps);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

 public void tancarEstanc() {
    obert = false;
}


}

    
    


