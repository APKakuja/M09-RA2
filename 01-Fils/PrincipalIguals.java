public class PrincipalIguals {
    public static void main(String[] args) {

        Fil juan = new Fil("Juan", 9, Thread.NORM_PRIORITY, 1000, 0, false);
        Fil pepe = new Fil("Pepe", 9, Thread.NORM_PRIORITY, 1000, 0, false);

        pepe.start();
        juan.start();

        System.out.println("Acaba thread main");
    }
}
