public class PrincipalDiferents {

    public static void main(String[] args) {

        Fil pepe = new Fil("Pepe", Thread.MIN_PRIORITY, 0);
        Fil juan = new Fil("Juan", Thread.MAX_PRIORITY, 0);

        pepe.start();
        juan.start();

        System.out.println("Acaba thread main");
    }
}