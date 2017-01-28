package dao;

import java.util.Collection;
import java.util.HashMap;

import entity.Filme;



public class FilmeDAO {
	
	private static FilmeDAO instance;
	private HashMap<Integer, Filme> filmes;
	private Object codFilme;
	

	public FilmeDAO() {
		filmes = new HashMap<Integer, Filme>();

		//Filme filme = new Filme(01, "Era do Gelo");
	}

	public static FilmeDAO getInstance() {
		if (instance == null) {
			instance = new FilmeDAO();
		}
		return instance;
		
	}

	public void addFilme(Filme f){
		filmes.put(f.getCodigo(), f);
		getFilme(f.getCodigo());
	}

	public Filme updateFilme(Filme filmeNovo) {
		filmes.put(filmeNovo.getCodigo(), filmeNovo);
		return filmeNovo;
	}

	public Filme getFilme(int codigo) {
		if (filmes.get(codFilme) == null) {
			Filme filmes = Filme.get(codigo);
		return filmes;
		}
		return null;
	}

	//Não utilizando ainda
	public Collection<Filme> getFilme() {
		return filmes.values();
	}

	public void removeFilme(int codFilme) {
		if (filmes.get(codFilme) == null)
			
		filmes.remove(codFilme);
	}

}
