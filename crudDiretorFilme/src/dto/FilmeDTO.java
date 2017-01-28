package dto;

public class FilmeDTO {
	
	private int codigo;
	private String nome;
	private int codDiretor;
	
	public FilmeDTO(int codigo, String nome, int codDiretor) {
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

	public int getcodDiretor() {
		return codDiretor;
	}

	public void setcodDiretor(int codDiretor) {
		this.codDiretor = codDiretor;
	}
	
	

}
