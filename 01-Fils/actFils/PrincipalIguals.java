package actFils;

public class PrincipalIguals {
 public static void main(String[] args) {

    Fil juan = new Fil("Juan", 9, Thread.MIN_PRIORITY, 0, 1000);
        
        Fil pepe = new Fil("Pepe", 9, Thread.MAX_PRIORITY, 0, 1000);
        
        pepe.start();
        juan.start();
        
        System.out.println("Acaba thread main");
     
 }
    
}
