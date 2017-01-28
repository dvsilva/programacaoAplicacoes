package dao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import entity.Pais;
import exception.DaoException;

public class PaisDAO  {

	private Map<Integer, Pais> paises;

	private static PaisDAO instance;
	private ArrayList<Object> raizDePersistencia;

	public PaisDAO() {
		paises = new HashMap<Integer, Pais>();

		//criamos um curso aqui para exercitar a operação de busca
		//Estado curso = new Curso(99, "SI");
		//try {
		//	this.addEstado(estado);
		//} catch (DaoException e) {
		//	e.printStackTrace();
		//}
	}

	public static PaisDAO getInstance() {
		if (instance == null) {
			instance = new PaisDAO();
		}
		return instance;
	}

	public void addPais(Pais p) throws DaoException {
		paises.put(p.getCodigo(), p);
		getPais(p.getCodigo());
	}

	public Pais updatePais(Pais paisNovo) throws DaoException {
		paises.put(paisNovo.getCodigo(), paisNovo);
		return paisNovo;
	}

	public Pais getPais(int codPais) throws DaoException {
		if (paises.get(codPais) == null) {
			throw new DaoException("");
		}
		Pais pais = paises.get(codPais);
		return pais;

	}

	public void removePais(int codPais) throws DaoException {
		if (paises.get(codPais) == null) {
			throw new DaoException("");
		}
		paises.remove(codPais);
	}
	
	
	public boolean persistir(ArrayList<Object> raizDePersistencia) throws Exception {	
		try {
			FileOutputStream arq = new FileOutputStream("./src/main/arquivo1.dmb");
			ObjectOutputStream oos = new ObjectOutputStream(arq);
			oos.writeObject(raizDePersistencia);
			oos.close();
		} catch (IOException e){
			e.printStackTrace();
		}
		return true;
}
}



