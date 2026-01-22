public class Coet {

    private Motor[] motors = new Motor[4];

    public Coet() {
        for (int i = 0; i < motors.length; i++) {
            motors[i] = new Motor();
            motors[i].setName("Motor " + (i + 1));
        }
    }

    public void arranca() {
        for (Motor m : motors) {
            m.start();
        }
    }

    public void passaAPotencia(int p) {
        if (p < 0 || p > 10) {
            System.out.println("Error: potència fora de rang (0-10): " + p);
            return;
        }

        System.out.println("Passar a potència " + p);

        for (Motor m : motors) {
            m.setPotencia(p);
        }
    }

    public void mostraEstat() {
        for (Motor m : motors) {
            System.out.println(
                m.getName() + ": Objectiu " + m.potenciaObjectiu +
                " Actual: " + m.potenciaActual
            );
        }
    }

    public static void main(String[] args) {

    Coet coet = new Coet();

    coet.passaAPotencia(3);
    coet.arranca();

    try { Thread.sleep(15000); } catch (Exception e) {}

    coet.passaAPotencia(7);

    try { Thread.sleep(15000); } catch (Exception e) {}

    coet.passaAPotencia(0);

    try { Thread.sleep(15000); } catch (Exception e) {}
}

}
