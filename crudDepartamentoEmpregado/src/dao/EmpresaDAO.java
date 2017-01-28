package dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import entity.Departamento;
import entity.Empregado;
import exception.DaoException;

public class EmpresaDAO {

	private static Map<Integer, Departamento> departamentos;
	private Map<Integer, Empregado> empregados;

	private static EmpresaDAO instance;

	public EmpresaDAO() {
		departamentos = new HashMap<Integer, Departamento>();
		empregados = new HashMap<Integer, Empregado>();

		//criamos um departamento aqui para exercitar a operação de busca...
		Departamento departamento = new Departamento(01, "RH", "Recursos humanos");
		Empregado empregado = new Empregado(01, "Pedro" , "30" , departamento);
		try {
			this.addDepartamento(departamento);
			this.addEmpregado(empregado);

			
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

	public static EmpresaDAO getInstance() {
		if (instance == null) {
			instance = new EmpresaDAO();
		}
		return instance;
	}

	public void addDepartamento(Departamento d) throws DaoException {
		departamentos.put(d.getCodigo(), d);
		getDepartamento(d.getCodigo());
	}

	public Departamento updateDepartamento(Departamento departamentoNovo) throws DaoException {
		departamentos.put(departamentoNovo.getCodigo(), departamentoNovo);
		return departamentoNovo;
	}

	public static Departamento getDepartamento(int codDepartamento) throws DaoException {
		if (departamentos.get(codDepartamento) == null) {
			throw new DaoException("");
		}
		Departamento departamento = departamentos.get(codDepartamento);
		return departamento;

	}
	
	
	

	//Não utilizando ainda
	public Collection<Departamento> getDepartamentos() {
		return departamentos.values();
	}

	public void removeDepartamento(int codDepartamento) throws DaoException {
		if (departamentos.get(codDepartamento) == null) {
			throw new DaoException("");
		}
		departamentos.remove(codDepartamento);
	}
	
	
	
	//empregado...
	
	
	public void addEmpregado(Empregado e) throws DaoException {
		empregados.put(e.getCodigo(), e);
		getEmpregado(e.getCodigo());
	}

	public Empregado updateEmpregado(Empregado empregadoNovo) throws DaoException {
		empregados.put(empregadoNovo.getCodigo(), empregadoNovo);
		return empregadoNovo;
	}

	public Empregado getEmpregado(int codEmpregado) throws DaoException {
		if (empregados.get(codEmpregado) == null) {
			throw new DaoException("");
		}
		Empregado empregado = empregados.get(codEmpregado);
		return empregado;

	}

	//Não utilizando ainda
	public Collection<Empregado> getEmpregados() {
		return empregados.values();
	}

	public void removeEmpregado(int codEmpregado) throws DaoException {
		if (empregados.get(codEmpregado) == null) {
			throw new DaoException("");
		}
		departamentos.remove(codEmpregado);
	}
	
	
	

}