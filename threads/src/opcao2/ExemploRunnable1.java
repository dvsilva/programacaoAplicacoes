package opcao2;
public class ExemploRunnable1 implements Runnable {

	private Thread minhaThread;
	
	public ExemploRunnable1(String str) {
		this.minhaThread = new Thread(this, str);
		this.minhaThread.start();
	}

	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(i + " " + minhaThread.getName());
		}
		System.out.println("Termina thread " + minhaThread.getName());
	}

	public static void main(String[] args) {
		new ExemploRunnable1("Vasco");
		new ExemploRunnable1("Flamengo");
		new ExemploRunnable1("Fluminense");
		new ExemploRunnable1("Botafogo");
	}
}
