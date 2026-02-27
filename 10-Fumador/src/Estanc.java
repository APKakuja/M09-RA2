import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Estanc {
    

    private List<Tabac> tabaco;
    private List<Paper> paper;
    private List<Llumi> llumi;


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

    public List<?> getListaAleatoria() {
        List<List<?>> listas = List.of(tabaco,llumi, paper);
        Random r = new Random();
        return listas.get (r.nextInt(listas.size()));
    }

    public void nouSubministrament(Estanc e) {
        List Producte = e.getListaAleatoria();
            if (Producte == List.of(tabaco)) {
                tabaco.add(1);
            }
    } 
}

    
    


