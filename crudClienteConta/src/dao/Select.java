package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import entity.Cliente;
import entity.Conta;
import entity.EstadoCivil;
import entity.Sexo;
import entity.TipoConta;
import exception.DaoException;

public class Select {
	private static Map<Long, Cliente> clientes;
	private static Map<Integer, Conta> contas;
	public Select() {
		
	}
	
	public Cliente selectCliente(long cpfCliente) {
		String textoDoComando = "SELECT * FROM Cliente WHERE cpf = " + cpfCliente + ";";
		Cliente cliente = new Cliente();
		ResultSet resultado = null;
		try {
			System.out.println("Conectando...");
			Connection conexao = Conexao.conectar();
			PreparedStatement comando = conexao.prepareStatement(textoDoComando);
			resultado = comando.executeQuery();
			cliente.setCpf(resultado.getLong("cpf"));
			cliente.setNome(resultado.getString("nome"));
			cliente.setSobrenome(resultado.getString("sobrenome"));
			cliente.setCep(resultado.getString("cep"));
			cliente.setEndereco(resultado.getString("endereco"));
			if(resultado.getString("sexo") == "MASCULINO")
				cliente.setSexo(Sexo.MASCULINO);
			else
				cliente.setSexo(Sexo.FEMININO);
			if(resultado.getString("estadoCivil") == "SOLTEIRO") 
				cliente.setEstadoCivil(EstadoCivil.SOLTEIRO);
			else {
				if(resultado.getString("estadoCivil") == "CASADO")
					cliente.setEstadoCivil(EstadoCivil.CASADO);
				else {
					if(resultado.getString("estadoCivil") == "DIVORCIADO")
						cliente.setEstadoCivil(EstadoCivil.DIVORCIADO);
					else
						cliente.setEstadoCivil(EstadoCivil.OUTROS);
				}
			}
				
			
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		return cliente;
	}
	
	public Conta selectConta(int codConta) {
		String textoDoComando = "SELECT * FROM Conta WHERE cpf = " + codConta + ";";
		Conta conta = new Conta();
		ResultSet resultado = null;
		try {
			System.out.println("Conectando...");
			Connection conexao = Conexao.conectar();
			PreparedStatement comando = conexao.prepareStatement(textoDoComando);
			resultado = comando.executeQuery();
			conta.setCodigo(resultado.getInt("codigo"));
			conta.setAgencia(resultado.getString("agencia"));
			conta.setSaldo(resultado.getFloat("saldo"));
			if(resultado.getString("tipo") == "CORRENTE")
				conta.setTipo(TipoConta.CORRENTE);
			else
				conta.setTipo(TipoConta.POUPANCA);
			try {
				conta.setCliente(BancoDAO.getInstance().getCliente(resultado.getLong("cpf")));
			} catch(DaoException e) {
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conta;
	}
	
	public void  selectClientes() {
		String textoDoComando = "SELECT * FROM Cliente ;";
		ResultSet resultado = null;
		try {
			System.out.println("Conectando...");
			Connection conexao = Conexao.conectar();
			PreparedStatement comando = conexao.prepareStatement(textoDoComando);
			resultado = comando.executeQuery();
			while(resultado.next()) {
				Cliente cliente = new Cliente();
				cliente.setCpf(resultado.getLong("cpf"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setSobrenome(resultado.getString("sobrenome"));
				cliente.setCep(resultado.getString("cep"));
				cliente.setEndereco(resultado.getString("endereco"));
				if(resultado.getString("sexo") == "MASCULINO")
					cliente.setSexo(Sexo.MASCULINO);
				else
					cliente.setSexo(Sexo.FEMININO);
				if(resultado.getString("estadoCivil") == "SOLTEIRO") 
					cliente.setEstadoCivil(EstadoCivil.SOLTEIRO);
				else {
					if(resultado.getString("estadoCivil") == "CASADO")
						cliente.setEstadoCivil(EstadoCivil.CASADO);
					else {
						if(resultado.getString("estadoCivil") == "DIVORCIADO")
							cliente.setEstadoCivil(EstadoCivil.DIVORCIADO);
						else
							cliente.setEstadoCivil(EstadoCivil.OUTROS);
					}
				}
				clientes.put(cliente.getCpf(), cliente);
			}
			
				
			
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void selectContas() {
		String textoDoComando = "SELECT * FROM Conta ;";
		
		ResultSet resultado = null;
		try {
			System.out.println("Conectando...");
			Connection conexao = Conexao.conectar();
			PreparedStatement comando = conexao.prepareStatement(textoDoComando);
			resultado = comando.executeQuery();
			while(resultado.next()) {
				Conta conta = new Conta();
				conta.setCodigo(resultado.getInt("codigo"));
				conta.setAgencia(resultado.getString("agencia"));
				conta.setSaldo(resultado.getFloat("saldo"));
				if(resultado.getString("tipo") == "CORRENTE")
					conta.setTipo(TipoConta.CORRENTE);
				else
					conta.setTipo(TipoConta.POUPANCA);
				try {
					conta.setCliente(BancoDAO.getInstance().getCliente(resultado.getLong("cpf")));
				} catch(DaoException e) {
					
				}
				contas.put(conta.getCodigo(), conta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	 
}
