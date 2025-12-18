public class PrincipalEstricte {
    public static void main(String[] args) {

        Fil juan = new Fil("Juan", 9, Thread.NORM_PRIORITY, 0, 1, true);
        Fil pepe = new Fil("Pepe", 9, Thread.NORM_PRIORITY, 0, 1, true);

        juan.start();
        pepe.start();

        System.out.println("Termina thread main");
    }
}
