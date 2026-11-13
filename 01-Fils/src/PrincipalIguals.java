public class PrincipalIguals {

    public static void main(String[] args) {

        Fil juan = new Fil("Juan", Thread.MAX_PRIORITY, 0);
        Fil pepe = new Fil("Pepe", Thread.MAX_PRIORITY, 0);

        juan.start();
        pepe.start();

        System.out.println("Acaba thread main");
    }
}