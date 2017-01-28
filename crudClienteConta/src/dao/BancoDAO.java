package dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import service.ContaService;

import entity.Cliente;
import entity.Conta;
import entity.EstadoCivil;
import entity.Sexo;
import entity.TipoConta;
import exception.DaoException;

public class BancoDAO {

	private static Conexao conexao;
	private static Insert insert;
	private static Update update;
	private static Delete delete;
	private static Select select;
	static Map<Long, Cliente> clientes;
	static Map<Integer, Conta> contas;
	private static BancoDAO instance;

	public BancoDAO() {
		clientes = new HashMap<Long, Cliente>();
		contas = new HashMap<Integer, Conta>();
		conexao = new Conexao();
		insert = new Insert();
		update = new Update();
		select = new Select();

		//criamos um Cliente aqui para exercitar a operação de busca
		//criamos um Cliente aqui para exercitar a operação de busca
				Cliente cliente1 = new Cliente(14508011705L, "Danyllo",  "Valente da Silva", Sexo.MASCULINO, EstadoCivil.SOLTEIRO, "24525-223","Rua Danelson, 22");
				Conta conta1 = new Conta(1, "agencia", 12, TipoConta.CORRENTE, null);
				Cliente cliente2 = new Cliente( 10515029777L, "Felipe", "Santos Vieira", Sexo.MASCULINO, EstadoCivil.SOLTEIRO, "24525-224", "Rua Felinelson, 22");
				Conta conta2 = new Conta(2, "agencia", 23, TipoConta.CORRENTE, null);
				Cliente cliente3 = new Cliente(12345678910L, "Hugo", "Silva do Carmo", Sexo.MASCULINO, EstadoCivil.CASADO, "24525-225", "Rua Hugonelson, 22");
				Conta conta3 = new Conta(3, "agencia", 34, TipoConta.CORRENTE, null);
				//Conta conta4 = new Conta(4, "agencia", 45, TipoConta.POUPANCA, null);
		cliente1.adicionarConta(conta1);
		cliente2.adicionarConta(conta2);
		cliente3.adicionarConta(conta3);
		//cliente1.adicionarConta(conta4);
		conta1.setCliente(cliente1);
		conta2.setCliente(cliente2);
		conta3.setCliente(cliente3);
		//conta4.setCliente(cliente1);
		try {
			this.addCliente(cliente1);
			this.addConta(conta1);
			//this.addConta(conta4);
			this.addCliente(cliente2);
			this.addConta(conta2);
			this.addCliente(cliente3);
			this.addConta(conta3);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

	public static BancoDAO getInstance() {
		if (instance == null) {
			instance = new BancoDAO();
		}
		return instance;
	}

	public void addCliente(Cliente cli) throws DaoException {
		insert.addCliente(cli);
		clientes.put(cli.getCpf(), cli);
		getCliente(cli.getCpf());
	}

	public Cliente updateCliente(Cliente clienteNovo) throws DaoException {
		clientes.put(clienteNovo.getCpf(), clienteNovo);
		update.updateCliente(clienteNovo);
		return clienteNovo;
	}

	public Cliente getCliente(long cpfCliente) throws DaoException {
		if (clientes.get(cpfCliente) == null) {
			throw new DaoException("");
		}
		
		//Cliente cliente = clientes.get(cpfCliente);
		return select.selectCliente(cpfCliente);

	}

	
	public Collection<Cliente> getClientes() {
		select.selectClientes();
		return clientes.values();
	}

	public void removeCliente(long cpfCliente) throws DaoException {
		if (clientes.get(cpfCliente) == null) {
			throw new DaoException("");
		}
		delete.removeCliente(cpfCliente);
		clientes.remove(cpfCliente);
	}
	
	
	public void addConta(Conta con) throws DaoException {
		insert.addConta(con);
		contas.put(con.getCodigo(), con);
		getConta(con.getCodigo());
		//raizDePersistencia.add(con);
	}

	public Conta updateConta(Conta contaNovo) throws DaoException {
		contas.put(contaNovo.getCodigo(), contaNovo);
		update.updateConta(contaNovo);
		return contaNovo;
	}

	public Conta getConta(int codConta) throws DaoException {
		if (contas.get(codConta) == null) {
			throw new DaoException("");
		}
		//Conta conta = contas.get(codConta);
		return select.selectConta(codConta);

	}


	public Collection<Conta> getContas() {
		select.selectContas();
		return contas.values();
	}

	public void removeConta(int codConta) throws DaoException {
		if (contas.get(codConta) == null) {
			throw new DaoException("");
		}
		delete.removeconta(codConta);
		contas.remove(codConta);
	}
	
	public static void gravarCliente(Map<Long, Cliente> clientes){
		try {
			FileOutputStream arq = new FileOutputStream("./src/persistencia/clientes.txt");
			ObjectOutputStream oos = new ObjectOutputStream(arq);
			oos.writeObject(clientes);
			oos.close();
		} catch (IOException e) {
			System.out.println("Erro ao gravar clientes");
			e.printStackTrace();
		}
	}

	private static Map<Long, Cliente> recuperaCliente() {
		try {
			FileInputStream arq = new FileInputStream("./src/persistencia/clientes.txt");
			ObjectInputStream ois = new ObjectInputStream(arq);
			clientes = (Map<Long, Cliente>) ois.readObject();
			ois.close();
		} catch (IOException e) {
			System.out.println("Erro ao recuperar o arquivo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return clientes;
	}

	public void salvarClientes() {
		gravarCliente(clientes);
	}
	
	public void recuperarClientes() {
		recuperaCliente();
	}
	
	public static void gravarConta (Map<Integer, Conta> contas) {
		try {
			FileOutputStream arq = new FileOutputStream("./src/persistencia/contas.txt");
			ObjectOutputStream oos = new ObjectOutputStream(arq);
			oos.writeObject(contas);
			oos.close();
		} catch (IOException e) {
			System.out.println("Erro ao gravar contas");
			e.printStackTrace();
		}
	}
	
	public static Map<Integer, Conta> recuperaConta() {
		try {
			FileInputStream arq = new FileInputStream("./src/persistencia/contas.txt");
			ObjectInputStream ois = new ObjectInputStream(arq);
			contas = (Map<Integer, Conta>) ois.readObject();
			ois.close();
		} catch (IOException e) {
			System.out.println("Erro ao recuperar o arquivo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return contas;
	}
	
	public void salvarContas() {
		gravarConta(contas);
	}
	
	public void recuperarContas() {
		recuperaConta();
	}

		
}