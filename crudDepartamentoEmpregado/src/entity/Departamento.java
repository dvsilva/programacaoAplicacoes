package entity;

import java.util.ArrayList;

public class Departamento {
	
	private int codigo;
	private String nome;
	private String sigla;
	private ArrayList<Empregado> empregados;
	
	public Departamento(int codigo, String sigla, String nome) {
		super();
		this.codigo = codigo;
		this.sigla = sigla;
		this.nome = nome;
		this.empregados = new ArrayList<Empregado>();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Empregado> getEmpregados() {
		return empregados;
	}

	public void setEmpregados(ArrayList<Empregado> empregados) {
		this.empregados = empregados;
	}

	public boolean adicionarEmpregado(Empregado empregado) {
		if (this.empregados.contains(empregado))
			return false;
		this.empregados.add(empregado);
		empregado.setDepartamento(this);
		return true;
	}
	
	public boolean removerEmpregado(Empregado empregado) {
		if (!this.empregados.contains(empregado))
			return false;
		this.empregados.remove(empregado);
		empregado.setDepartamento(null);
		return true;
	}
	
	
	
}
