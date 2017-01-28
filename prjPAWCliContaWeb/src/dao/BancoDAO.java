package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import entity.Cliente;
import entity.Conta;
import entity.EstadoCivil;
import entity.Sexo;
import entity.TipoConta;
import exception.DaoException;

public class BancoDAO {
	
	private static Map<Long, Cliente> clientes;
	private static Map<Integer, Conta> contas;
	private static BancoDAO instance;
	private static Buscar buscar;
	private static Cadastrar cadastrar;
	private static Alterar alterar;
	private static Excluir excluir;

	public BancoDAO() {
		this.clientes = new HashMap<Long, Cliente>();
		this.contas = new HashMap<Integer, Conta>();
				
		this.cadastrar = new Cadastrar();
		this.alterar = new Alterar();
		this.excluir = new Excluir();
		this.buscar = new Buscar();
		
	}

	public static BancoDAO getInstance() {
		if (instance == null) {
			instance = new BancoDAO();
		}
		return instance;
	}

	public void addCliente(Cliente cli) throws DaoException {
		cadastrar.addCliente(cli);
		getCliente(cli.getCpf());
	}

	public Cliente updateCliente(Cliente clienteNovo) throws DaoException {
		alterar.updateCliente(clienteNovo);
		return clienteNovo;
	}

	public Cliente getCliente(long cpfCliente) throws DaoException {
		if (buscar.getCliente(cpfCliente) == null) {
			throw new DaoException("");
		}
		Cliente cliente = buscar.getCliente(cpfCliente);
		return cliente;
	}

	//Não utilizando ainda
	public Collection<Cliente> getClientes() {
		return buscar.getClientes();
	}

	public void removeCliente(long cpfCliente) throws DaoException {
		if (buscar.getCliente(cpfCliente) == null) {
			throw new DaoException("");
		}
		excluir.removeCliente(cpfCliente);
	}
	
	
	public void addConta(Conta con) throws DaoException {
		cadastrar.addConta(con);
		getConta(con.getCodigo());
	}

	public Conta updateConta(Conta ContaNovo) throws DaoException {
		alterar.updateConta(ContaNovo);
		return ContaNovo;
	}

	public Conta getConta(int codConta) throws DaoException {
		if (buscar.getConta(codConta) == null) {
			throw new DaoException("");
		}
		Conta conta = buscar.getConta(codConta);
		return conta;

	}

	//Não utilizando ainda
	public Collection<Conta> getContas() {
		return buscar.getContas();
	}

	public void removeConta(int codConta) throws DaoException {
		if (buscar.getConta(codConta) == null) {
			throw new DaoException("");
		}
		excluir.removeConta(codConta);
	}

	private static Map<Long, Cliente> recuperaClientes() {
		clientes = buscar.recuperarClientes();
		return clientes;
	}
	
	public void recuperarClientes() {
		recuperaClientes();
	}
	
	
	public static Map<Integer, Conta> recuperaConta() {
		contas = buscar.recuperarContas();
		return contas;
	}
	
	public void recuperarContas() {
		recuperaConta();
	}
}