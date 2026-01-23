
import java.util.Random;

public class Treballador extends Thread {

    private float soul_anual_brut;
    private int edat_inici_treball;
    private int edat_fi_treball;
    private int edat_actual;
    private float cobrat;
    private Random rnd;

    public Treballador(float sou, int inici, int fi, String nom) {

        super(nom);
        this.soul_anual_brut = sou;
        this.edat_inici_treball = inici;
        this.edat_fi_treball = fi;
        this.edat_actual = 0;
        this.cobrat = 0.0f;
        this.rnd = new Random();
    }

    public void cobra() {
        cobrat += soul_anual_brut / 12f;
    }

    public void pagaImpostos() {
        cobrat -= (soul_anual_brut / 12f) * 0.24f;
    }

    public void run() {
        while (edat_actual < edat_fi_treball) {
            if (edat_actual >= edat_inici_treball){
                for (int mes = 0; mes < 12; mes++) {
                    cobra();
                    pagaImpostos();

                    try {
                         Thread.sleep(rnd.nextInt(20) + 10); 
                        } catch (InterruptedException e) {}
                }
            }

            edat_actual++;

        }
    }
    public float getCobrat() { 
        return cobrat; 
    } 
    
    public int getEdat() { 
        return edat_actual; 
    }
}
