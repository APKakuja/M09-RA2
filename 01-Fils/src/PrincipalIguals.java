public class PrincipalIguals {

    public static void main(String[] args) {

        Fil juan = new Fil("Juan", 1000, Thread.NORM_PRIORITY);
        Fil pepe = new Fil("Pepe", 1000, Thread.NORM_PRIORITY);

        juan.start();
        pepe.start();

        System.out.println("Acaba thread main");
    }
}