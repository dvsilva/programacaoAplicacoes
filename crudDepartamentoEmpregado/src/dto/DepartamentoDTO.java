package dto;

import java.util.ArrayList;


public class DepartamentoDTO {

	private int codigo;
	private String nome;
	private String sigla;
	private ArrayList<Integer> codEmpregados;
	
	public DepartamentoDTO(int codigo, String sigla, String nome) {
		super();
		this.codigo = codigo;
		this.sigla = sigla;
		this.nome = nome;
		this.codEmpregados = new ArrayList<Integer>();
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

	public void setSigla (String sigla) {
		this.sigla = sigla;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the codContas
	 */
	public ArrayList<Integer> getCodContas() {
		return codEmpregados;
	}

	/**
	 * @param codContas the codContas to set
	 */
	public void setCodContas(ArrayList<Integer> codEmpregados) {
		this.codEmpregados = codEmpregados;
	}

	public boolean adicionarDepartamentoDTO(Integer codEmpregados) {
		if (this.codEmpregados.contains(codEmpregados))
			return false;
		this.codEmpregados.add(codEmpregados);
		return true;
	}
	
	public boolean removerDepartamentoDTO(Integer codConta) {
		if (!this.codEmpregados.contains(codConta))
			return false;
		this.codEmpregados.remove(codConta);
		return true;
	}

}
