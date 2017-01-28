package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
	
	public Delete() {
		
	}
	
	public void removeCliente(long cpfCliente) {
		String textoDoComando = "DELETE FROM Cliente WHERE cpf = " + cpfCliente + ";";
		
		try {
			System.out.println("Conectando...");
			Connection conexao = Conexao.conectar();
			PreparedStatement comando = conexao.prepareStatement(textoDoComando);
			System.out.println("Executando comando...");
			comando.execute();
			System.out.println("Fechando a conexão...");
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void removeconta(int codConta) {
		String textoDoComando = "DELETE FROM Conta WHERE cpf = " + codConta + ";";
		
		try {
			System.out.println("Conectando...");
			Connection conexao = Conexao.conectar();
			PreparedStatement comando = conexao.prepareStatement(textoDoComando);
			System.out.println("Executando comando...");
			comando.execute();
			System.out.println("Fechando a conexão...");
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
