package dao;

import java.io.FileOutputStream;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import entity.Estado;
import exception.DaoException;

public class EstadoDAO {

	private Map<Integer, Estado> estados;

	private static EstadoDAO instance;

	
	public EstadoDAO() {
		estados = new HashMap<Integer, Estado>();

		
		
		
	}

	public static EstadoDAO getInstance() {
		if (instance == null) {
			instance = new EstadoDAO();
		}
		return instance;
	}

	public void addEstado(Estado e) throws DaoException {
		estados.put(e.getCodigo(), e);
		getEstado(e.getCodigo());
	}

	public Estado updateEstado(Estado estadoNovo) throws DaoException {
		estados.put(estadoNovo.getCodigo(), estadoNovo);
		return estadoNovo;
	}

	public Estado getEstado(int codEstado) throws DaoException {
		if (estados.get(codEstado) == null) {
			throw new DaoException("");
		}
		Estado estado = estados.get(codEstado);
		return estado;

	}

	public void removeEstado(int codEstado) throws DaoException {
		if (estados.get(codEstado) == null) {
			throw new DaoException("");
		}
		estados.remove(codEstado);
	}

	public boolean persistir(ArrayList<Object> raizDePersistencia) throws Exception {	
		try {
			FileOutputStream arq = new FileOutputStream("./src/main/arquivo.dmb");
			ObjectOutputStream oos = new ObjectOutputStream(arq);
			oos.writeObject(raizDePersistencia);
			oos.close();
		} catch (IOException e){
			e.printStackTrace();
		}
		return true;
}
}


