public class Coet {
    private final Motor[] motors = new Motor[4];

    public Coet() {
        for (int i = 0; i < motors.length; i++) {
            motors[i] = new Motor(i);
            motors[i].setName("Motor " + (i + 1));
        }
    }

    public void arranca() {
        for (Motor motor : motors) {
            motor.start();
        }
    }

    public void passaAPotencia(int potencia) {
        if (potencia < 0 || potencia > 10) {
            System.out.println("Error: potència fora de rang (0-10): " + potencia);
            return;
        }

        System.out.println("Passar a potència " + potencia);

        for (Motor motor : motors) {
            motor.setPotencia(potencia);
        }
    }

    public void mostraEstat() {
        for (Motor motor : motors) {
            System.out.println(
                motor.getName() +
                ": Objectiu " + motor.getPotenciaObjectiu() +
                " Actual: " + motor.getPotenciaActual()
            );
        }
    }

    public void atura() {
        passaAPotencia(0);

        for (Motor motor : motors) {
            try {
                motor.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public static void main(String[] args) {
        Coet coet = new Coet();

        coet.arranca();
        coet.passaAPotencia(3);
        dormir(15000);

        coet.passaAPotencia(7);
        dormir(15000);

        coet.atura();
    }

    private static void dormir(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
