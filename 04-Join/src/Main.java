public static void main(String[] args) {

    Administracio adm = new Administracio();

    for (Treballador t : adm.poblacio_activa) {
        t.start();
    }

    for (Treballador t : adm.poblacio_activa) {
        try { t.join(); } catch (Exception e) {}
    }

    for (Treballador t : adm.poblacio_activa) {
        System.out.printf("%s -> edat: %d / total: %.2f\n",
            t.getName(), t.getEdat(), t.getCobrat());
    }
}
