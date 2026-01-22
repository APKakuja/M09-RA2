public class Motor extends Thread {

    public int potenciaActual = 0;
    public int potenciaObjectiu = 0;

    public void setPotencia(int p) {
        potenciaObjectiu = p;
    }

    @Override
public void run() {
    while (true) {

        if (potenciaObjectiu == 0 && potenciaActual == 0) {
            System.out.println(getName() + ": FerRes Objectiu: 0 Actual: 0");
            break;
        }

        if (potenciaActual < potenciaObjectiu) {
            potenciaActual++;
            System.out.println(getName() + ": Incre. Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
        } 
        else if (potenciaActual > potenciaObjectiu) {
            potenciaActual--;
            System.out.println(getName() + ": Decre. Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
        } 
        else {
            System.out.println(getName() + ": FerRes Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
        }

        try {
            Thread.sleep((int)(Math.random() * 1000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

}
