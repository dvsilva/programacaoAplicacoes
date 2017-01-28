package entity;

import java.util.ArrayList;

public class Diretor {
	
	private int codigo;
	private String nome;
	private ArrayList<Filme> filmes;
	
	public Diretor(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
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

	public ArrayList<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(ArrayList<Filme> filmes) {
		this.filmes = filmes;
	}

	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
	
	
}
