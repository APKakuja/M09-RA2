package src;


public class Futbolista extends Thread {

    private int NUM_JUGADORS = 11;
    private int NUM_TIRADES = 20;
    private float PROBABILITAT = 0.5f;
    
    private int ngols;
    private int ntirades;

    public Futbolista (String nom) {
        super(nom);
        this.ngols = 0;
        this.ntirades = 0;
    }


@Override

public void run() {

    for(int i = 0; i < NUM_TIRADES; i++) {
    ntirades ++;

    if (Math.random() < PROBABILITAT) {
        ngols ++;
    }

    }
}
}
