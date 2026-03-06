import java.util.ArrayList;
import java.util.List;

public class Barri {

    private final List<Fumador> fumadors = new ArrayList<>();
    public Barri(int nFumadors) {
        Estanc e = new Estanc();

        Fumador f1 = new Fumador(1, e);
        Fumador f2 = new Fumador(2, e);
        Fumador f3 = new Fumador(3, e);

        e.run();

        e.tancarEstanc();
    }
}
