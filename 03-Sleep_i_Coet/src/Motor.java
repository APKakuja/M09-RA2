public class Motor extends Thread {
    private volatile int potenciaActual = 0;
    private volatile int potenciaObjectiu = 0;
    private volatile boolean aturat = false;
    private boolean ferResMostrat = false;
    private final int numeroMotor;

    public Motor(int numeroMotor) {
        this.numeroMotor = numeroMotor;
    }

    public void setPotencia(int p) {
        if (p < 0 || p > 10) {
            return;
        }

        potenciaObjectiu = p;
        if (p == 0) {
            aturat = true;
        }
    }

    public int getPotenciaActual() {
        return potenciaActual;
    }

    public int getPotenciaObjectiu() {
        return potenciaObjectiu;
    }

    public void run() {
        while (!aturat || potenciaActual != 0) {
            if (potenciaActual < potenciaObjectiu) {
                potenciaActual++;
                ferResMostrat = false;
                System.out.println(
                    "Motor " + numeroMotor +
                    ": Incre. Objectiu: " + potenciaObjectiu +
                    " Actual: " + potenciaActual
                );
            } else if (potenciaActual > potenciaObjectiu) {
                potenciaActual--;
                ferResMostrat = false;
                System.out.println(
                    "Motor " + numeroMotor +
                    ": Decre. Objectiu: " + potenciaObjectiu +
                    " Actual: " + potenciaActual
                );
            } else if (potenciaObjectiu != 0 && !ferResMostrat) {
                System.out.println(
                    "Motor " + numeroMotor +
                    ": FerRes Objectiu: " + potenciaObjectiu +
                    " Actual: " + potenciaActual
                );
                ferResMostrat = true;
            }

            try {
                int temps = (int)(Math.random() * 1001) + 1000;
                Thread.sleep(temps);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}