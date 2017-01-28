package dto;

public class EmpregadoDTO {
	
	private int codigo;
	private String nome;
	private String idade;
	private int codDepartamento;
	
	
	public EmpregadoDTO(int codigo, String nome, String idade,
			int codDepartamento) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.idade = idade;
		this.codDepartamento = codDepartamento;
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
	
	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public int getCodDepartamento() {
		return codDepartamento;
	}

	public void setCodDepartamento(int codDepartamento) {
		this.codDepartamento = codDepartamento;
	}



}
