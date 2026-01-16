public class main {

    public static void main(String[] args) {
        
        String[] noms = {
            "Joan",
            "Pep"
        };

        DormAleatori dormilon[] = new DormAleatori[DormAleatori.dormilones];
        for (int i = 0; i < DormAleatori.dormilones; i++) {
            dormilon[i] = new DormAleatori(noms[i]);
        }

        for (DormAleatori duerme : dormilon){
            duerme.start();
        }

        System.out.println(" -- Fi de main -- ");

    }
}
