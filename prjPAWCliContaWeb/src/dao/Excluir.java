package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import entity.Cliente;
import entity.Conta;
import entity.TipoConta;
import exception.DaoException;

public class Excluir {
	
	public Excluir() {
	}
	
	public void removeCliente(long cpfCliente) throws DaoException {
			try{
			String textoDoComando = "DELETE FROM Cliente WHERE cpf = '" + cpfCliente + "'";
			Connection conexao = ConnectionFactory.createConnection();
			PreparedStatement comando = conexao.prepareStatement(textoDoComando);
			comando.execute();
			conexao.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
	
	public void removeConta(int codConta) {
		try{
			String textoDoComando = "DELETE FROM Conta WHERE codigo = '" + codConta + "'";
			Connection conexao = ConnectionFactory.createConnection();
			PreparedStatement comando = conexao.prepareStatement(textoDoComando);
			comando.execute();
			conexao.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
