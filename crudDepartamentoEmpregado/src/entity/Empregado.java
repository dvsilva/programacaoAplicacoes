package entity;

public class Empregado {
	
	private int codigo;
	private String nome;
	private String idade;
	private Departamento departamento;
	
	
	public Empregado(int codigo, String nome, String idade,
			Departamento departamento) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.idade = idade;
		this.departamento = departamento;
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

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}	
		
	
		
}

