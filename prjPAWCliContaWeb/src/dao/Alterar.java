package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import entity.Cliente;
import entity.Conta;
import entity.TipoConta;
import exception.DaoException;

public class Alterar {
	
	public Alterar() {
	}
	
	public void updateCliente(Cliente clienteNovo) {
		try{
			String textoDoComando = "UPDATE Cliente set nome = '" + clienteNovo.getNome() + "', sobrenome = '" + clienteNovo.getSobrenome() + "', sexo = '" + clienteNovo.getSexo() + "', estadoCivil = '" + clienteNovo.getEstadoCivil() 
					+ "', cep = '" + clienteNovo.getCep() + "', endereco = '" + clienteNovo.getEndereco() + "' where cpf = '" + clienteNovo.getCpf() + "'";
			
			Connection conexao = ConnectionFactory.createConnection ();
			PreparedStatement comando = conexao.prepareStatement(textoDoComando);
			comando.execute();
			conexao.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateConta(Conta contaNovo) {
		try{
			String textoDoComando = " UPDATE Conta set agencia = '" + contaNovo.getAgencia() + "', saldo = '" + contaNovo.getSaldo() + "', tipo = '" + contaNovo.getTipo() + "', cpf = '" + contaNovo.getCliente().getCpf() 
					+ "' where codigo = '" + contaNovo.getCodigo() + "'";
			
			Connection conexao = ConnectionFactory.createConnection ();
			PreparedStatement comando = conexao.prepareStatement(textoDoComando);
			comando.execute();
			conexao.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
