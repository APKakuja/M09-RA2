public class Administracio {

    public int num_poblacio_activa = 50;
    public Treballador[] poblacio_activa;

    public Administracio() {
        poblacio_activa = new Treballador[num_poblacio_activa];

        for (int i = 0; i < num_poblacio_activa; i++) {
            poblacio_activa[i] = new Treballador(25000, 20, 65, "Ciutadà-" + (i + 1));
        }
    }
}
