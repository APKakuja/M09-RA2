import java.util.concurrent.ThreadLocalRandom;

public class Dona extends Thread {
	private final String nom;
	private final BanyUnisex bany;

	public Dona(String nom, BanyUnisex bany) {
		this.nom = nom;
		this.bany = bany;
		setName(nom);
	}

	@Override
	public void run() {
		System.out.println(nom + " vol entrar al bany");
		bany.entraDona();

		try {
			utilitzaLavabo();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		} finally {
			bany.surtDona();
			System.out.println(nom + " ha acabat d'usar el bany");
		}
	}

	private void utilitzaLavabo() throws InterruptedException {
		Thread.sleep(ThreadLocalRandom.current().nextInt(2000, 3001));
	}
}
