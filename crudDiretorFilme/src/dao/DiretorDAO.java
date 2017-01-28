package dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import entity.Diretor;
import entity.Filme;
import exception.DaoException;

public class DiretorDAO {

	private Map<Integer, Diretor> diretores;

	private static DiretorDAO instance;

	public DiretorDAO() {

		diretores = new HashMap<Integer, Diretor>();

	}

	public void addDiretor(Diretor d) throws DaoException{
		diretores.put(d.getCodigo(), d);
		getDiretor(d.getCodigo());
	}
	public static DiretorDAO getInstance() {
		if (instance == null) {
			instance = new DiretorDAO();
		}
		return instance;
	}

	public Diretor updateDiretor(Diretor diretorNovo) {
		diretores.put(diretorNovo.getCodigo(), diretorNovo);
		return diretorNovo;
	}

	public Diretor getDiretor(int codDiretor) throws DaoException {
		if (diretores.get(codDiretor) == null
				|| diretores.get(codDiretor).equals("")) {
			throw new DaoException("Nenhum Diretor Encontrado");
		} else {
		Diretor diretor = diretores.get(getDiretores());
		return diretor;
		}
	}

	public Collection<Diretor> getDiretores() {
		return diretores.values();
	}

	public void removeDiretor(int codDiretor) throws DaoException {
		if (diretores.get(codDiretor) == null
				|| diretores.get(codDiretor).equals("")) {
			throw new DaoException("Nenhum Diretor Encontrado");
		} else
			diretores.remove(codDiretor);
	}
}