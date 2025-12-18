

public class PrincipalEstricte {
    public static void main(String[] args) {
        Fil juan = new Fil("Juan", 9, Thread.NORM_PRIORITY, 1, 10);
        Fil pepe = new Fil("Pepe", 9, Thread.NORM_PRIORITY, 1, 10);
        

        juan.start();
        pepe.start();
        
        
        System.out.println("Acaba thread main");
    }
}