package opcao2;

public class ExemploRunnable implements Runnable{
	private Thread minhaThread;
	
	public ExemploRunnable(String str) {
		this.minhaThread = new Thread(this, str);
		this.minhaThread.start();
	}

	public void run() {
		long inicio = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			System.out.println(i + " " + minhaThread.getName());
		}
		long fim = System.currentTimeMillis();
		System.out.println(fim - inicio);
		System.out.println("Termina thread " + minhaThread.getName());
	}

	public static void main(String[] args) {
		new ExemploRunnable("Vasco");
		new ExemploRunnable("Flamengo");
		new ExemploRunnable("Fluminense");
		new ExemploRunnable("Botafogo");
	}
}
