package control;

public class RaizQuadradaException extends Exception{

	private static final long serialVersionUID = -925799415562734918L;

	public RaizQuadradaException(double valor){
		super("O valor passado é inválido " + valor);
	}
}
