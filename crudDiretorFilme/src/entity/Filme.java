package entity;

public class Filme {
	
	private int codigo;
	private String nome;
	private int codDiretor;
	
	public Filme(int codigo, String nome, int codDiretor) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.codDiretor = codDiretor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodDiretor() {
		return codDiretor;
	}

	public void setCodDiretor(int codDiretor) {
		this.codDiretor = codDiretor;
	}

	public static Filme get(int codigo2) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
		
}
