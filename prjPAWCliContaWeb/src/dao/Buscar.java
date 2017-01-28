package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import entity.Cliente;
import entity.Conta;
import entity.EstadoCivil;
import entity.Sexo;
import entity.TipoConta;
import exception.DaoException;

public class Buscar {
	
	public Buscar() {		
	}

	public Cliente getCliente(long cpfCliente) throws DaoException {
				
			try{
			String textoDoComando = "SELECT * FROM Cliente WHERE cpf = '" + cpfCliente + "'";
			Connection conexao = ConnectionFactory.createConnection ();
			PreparedStatement comando = conexao.prepareStatement(textoDoComando);
			
		    ResultSet resultado = comando.executeQuery(textoDoComando);
		    resultado.first();
		    int numLinhas = resultado.getRow();
		    
		    if(numLinhas != 0){
		    	Sexo sexo = null;
				if (resultado.getObject(4).equals("MASCULINO")){
					sexo = Sexo.MASCULINO;
				} else {
					if (resultado.getObject(4).equals("FEMININO")) {
					sexo = Sexo.FEMININO;
					}
				}

				EstadoCivil estadoCivil = null;
				if (resultado.getObject(5).equals("SOLTEIRO")) {
					estadoCivil = EstadoCivil.SOLTEIRO;
				} else {
					if (resultado.getObject(5).equals("CASADO")) {
						estadoCivil = EstadoCivil.CASADO;
					} else {
						if (resultado.getObject(5).equals("DIVORCIADO")) {
							estadoCivil = EstadoCivil.DIVORCIADO;
						} else{ 
							if (resultado.getObject(5) == EstadoCivil.OUTROS){
								estadoCivil = EstadoCivil.OUTROS;
						}
						}
						}
					}
			
					
				Cliente cliente = new Cliente(cpfCliente,
						(String)resultado.getObject(2),
						(String)resultado.getObject(3),
						sexo,
						estadoCivil,
						(String)resultado.getObject(6),
						(String)resultado.getObject(7));
				
				ArrayList<Conta> listaContas = buscarContaCliente(cpfCliente, cliente);
				
				cliente.setListaContas(listaContas);
				conexao.close();
				return cliente;
				
		    }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return null;
		}
	
	private ArrayList<Conta> buscarContaCliente(long cpfCliente, Cliente cliente) {
		ArrayList<Conta> listaContas = new ArrayList<Conta>();
		
		try{
			String textoDoComando = "SELECT * FROM Conta where cpf = '" + cpfCliente + "'";
			Connection conexao = ConnectionFactory.createConnection ();
			PreparedStatement comando = conexao.prepareStatement(textoDoComando);
		    ResultSet resultado = comando.executeQuery(textoDoComando);
		    resultado.last();
		    int numLinhas = resultado.getRow();
		    resultado.first();
				    if(numLinhas != 0){
				    	for (int i = 0; i < numLinhas; i++){
				   		    TipoConta tipo = null;
				   			   	if (resultado.getObject(4).equals("CORRENTE")) {
				   			   	  	tipo = TipoConta.CORRENTE;
				   			   	} else {
				   			   		tipo = TipoConta.POUPANCA;
				   			   	}
				   			Conta conta = new Conta(Integer.parseInt(resultado.getObject(1).toString()),
				   					(String)resultado.getObject(2),
				   					Float.parseFloat(resultado.getObject(3).toString()),
				   					tipo,
				   					cliente);
					    	listaContas.add(conta);
					    	resultado.next();
					    }
				    	conexao.close();
				    }
				} catch (SQLException e) {
					e.printStackTrace();
				}		    
		    	
		return listaContas;
	}

	public Conta getConta(int codConta) {
		
		try{	    
			
		String textoDoComando = "SELECT * FROM Conta WHERE codigo = '" + codConta + "'";
		Connection conexao = ConnectionFactory.createConnection ();
		PreparedStatement comando = conexao.prepareStatement(textoDoComando);
		
	    ResultSet resultado = comando.executeQuery(textoDoComando);
	    resultado.first();
	    int numLinhas = resultado.getRow();
	    
	    if(numLinhas != 0){
	    	   TipoConta tipo = null;
	   	    if (resultado.getObject(4).equals("CORRENTE")) {
	   	    	tipo = TipoConta.CORRENTE;
	   		} else {
	   			tipo = TipoConta.POUPANCA;
	   		}
	   	    
	   	    Cliente cliente = null;
	   		try {
	   			cliente = getCliente((long)resultado.getObject(5));
	   		} catch (DaoException e) {
	   			e.printStackTrace();
	   		}
	   		Conta conta = new Conta(codConta,
	   				(String)resultado.getObject(2),
	   				(float)resultado.getObject(3),
	   				tipo,
	   				cliente);
	   		conexao.close();
	   		return conta;
	    }
	    
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return null;
	
	}

	public Map<Long, Cliente> recuperarClientes() {
		Map<Long, Cliente> clientes;
		clientes = new HashMap<Long, Cliente>();
	
		try{	    
			String textoDoComando = "SELECT * FROM Cliente";
			Connection conexao = ConnectionFactory.createConnection ();
			PreparedStatement comando = conexao.prepareStatement(textoDoComando);
		    ResultSet resultado = comando.executeQuery(textoDoComando);
		    resultado.last();
		    int numLinhas = resultado.getRow();
		    resultado.first();
		    
		    if(numLinhas != 0){
		    	for (int i = 0; i < numLinhas; i++){
			    	 Sexo sexo = null;
						if (resultado.getObject(4).equals("MASCULINO")){
							sexo = Sexo.MASCULINO;
						} else {
							if (resultado.getObject(4).equals("FEMININO")) {
							sexo = Sexo.FEMININO;
							}
						}

						EstadoCivil estadoCivil = null;
						if (resultado.getObject(5).equals("SOLTEIRO")) {
							estadoCivil = EstadoCivil.SOLTEIRO;
						} else {
							if (resultado.getObject(5).equals("CASADO")) {
								estadoCivil = EstadoCivil.CASADO;
							} else {
								if (resultado.getObject(5).equals("DIVORCIADO")) {
									estadoCivil = EstadoCivil.DIVORCIADO;
								} else{ 
									if (resultado.getObject(5) == EstadoCivil.OUTROS){
										estadoCivil = EstadoCivil.OUTROS;
								}
								}
								
							}
						}
					Cliente cliente = new Cliente((long)resultado.getObject(1),
							(String)resultado.getObject(2),
							(String)resultado.getObject(3),
							sexo,
							estadoCivil,
							(String)resultado.getObject(6),
							(String)resultado.getObject(7));
			    	
			    	clientes.put(cliente.getCpf(), cliente);
			    	resultado.next();
			    }
		    }
		    conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}

	public Map<Integer, Conta> recuperarContas() {
		Map<Integer, Conta> contas;
		contas = new HashMap<Integer, Conta>();
		try{	    
			String textoDoComando = "SELECT * FROM Conta";
			Connection conexao = ConnectionFactory.createConnection ();
			PreparedStatement comando = conexao.prepareStatement(textoDoComando);
		    ResultSet resultado = comando.executeQuery(textoDoComando);
		    resultado.last();
		    int numLinhas = resultado.getRow();
		    resultado.first();
		    
		    if(numLinhas != 0){
		    	for (int i = 0; i < numLinhas; i++){
		   		    
		   		    TipoConta tipo = null;
		   			   	if (resultado.getObject(4).equals("CORRENTE")) {
		   			   	  	tipo = TipoConta.CORRENTE;
		   			   	} else {
		   			   		tipo = TipoConta.POUPANCA;
		   			   	}
		   			   	    
		   			   Cliente cliente = null;
		   			   try {
		   			   	cliente  = getCliente((long)resultado.getObject(5));
		   			   } catch (DaoException e) {
		   			   		e.printStackTrace();
		   			   }
		   			
		   			Conta conta = new Conta(Integer.parseInt(resultado.getObject(1).toString()),
		   					(String)resultado.getObject(2),
		   					Float.parseFloat(resultado.getObject(3).toString()),
		   					tipo,
		   					cliente);
			    	contas.put(conta.getCodigo(), conta);
			    	resultado.next();
			    }
		    }
		    conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contas;
	}

	public Collection<Conta> getContas() {
		Collection<Conta> contas2;
		contas2 = new ArrayList();
		try{	    
			String textoDoComando = "SELECT * FROM Conta";
			Connection conexao = ConnectionFactory.createConnection();
			PreparedStatement comando = conexao.prepareStatement(textoDoComando);
		    ResultSet resultado = comando.executeQuery(textoDoComando);
		    resultado.last();
		    int numLinhas = resultado.getRow();
		    resultado.first();
		    
		    if(numLinhas != 0){
		    	for (int i = 0; i < numLinhas; i++){
		   		    
		   		    TipoConta tipo = null;
		   			   	if (resultado.getObject(4).equals("CORRENTE")) {
		   			   	  	tipo = TipoConta.CORRENTE;
		   			   	} else {
		   			   		tipo = TipoConta.POUPANCA;
		   			   	}
		   			   	    
		   			   Cliente cliente = null;
		   			   try {
		   			   	cliente  = getCliente((long)resultado.getObject(5));
		   			   } catch (DaoException e) {
		   			   		e.printStackTrace();
		   			   }
		   			
		   			Conta conta = new Conta(Integer.parseInt(resultado.getObject(1).toString()),
		   					(String)resultado.getObject(2),
		   					Float.parseFloat(resultado.getObject(3).toString()),
		   					tipo,
		   					cliente);
			    	contas2.add(conta);
			    	resultado.next();
			    }
		    }
		    conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contas2;
	}

	public Collection<Cliente> getClientes() {
		Collection clientes2;
		clientes2 = new ArrayList();
	
		try{	    
			String textoDoComando = "SELECT * FROM Cliente";
			Connection conexao = ConnectionFactory.createConnection ();
			PreparedStatement comando = conexao.prepareStatement(textoDoComando);
		    ResultSet resultado = comando.executeQuery(textoDoComando);
		    resultado.last();
		    int numLinhas = resultado.getRow();
		    resultado.first();
		    
		    if(numLinhas != 0){
		    	for (int i = 0; i < numLinhas; i++){
			    	 Sexo sexo = null;
						if (resultado.getObject(4).equals("MASCULINO")){
							sexo = Sexo.MASCULINO;
						} else {
							if (resultado.getObject(4).equals("FEMININO")) {
							sexo = Sexo.FEMININO;
							}
						}

						EstadoCivil estadoCivil = null;
						if (resultado.getObject(5).equals("SOLTEIRO")) {
							estadoCivil = EstadoCivil.SOLTEIRO;
						} else {
							if (resultado.getObject(5).equals("CASADO")) {
								estadoCivil = EstadoCivil.CASADO;
							} else {
								if (resultado.getObject(5).equals("DIVORCIADO")) {
									estadoCivil = EstadoCivil.DIVORCIADO;
								} else{ 
									if (resultado.getObject(5) == EstadoCivil.OUTROS){
										estadoCivil = EstadoCivil.OUTROS;
								}
								}
								
							}
						}
					Cliente cliente = new Cliente((long)resultado.getObject(1),
							(String)resultado.getObject(2),
							(String)resultado.getObject(3),
							sexo,
							estadoCivil,
							(String)resultado.getObject(6),
							(String)resultado.getObject(7));
			    	
			    	clientes2.add(cliente);
			    	resultado.next();
			    }
		    }
		    conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes2;
	}

}
