package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Conexao {

	public void main(String args[]) {

		String urlDeConexao = "jdbc:mysql://localhost:3307/livraria";
		String usuario = "root";
		String senha = "123456";
		Scanner entrada = new Scanner(System.in);

		try {
			System.out.println(" Abrindo conexão ... ");
			String stringDeConexao = null;
			Connection conexao = DriverManager.getConnection(stringDeConexao, usuario, senha);

			System.out.println(" Digite o nome da editora : ");

			String nome = entrada.nextLine();

			System.out.println(" Digite o email da editora : ");
			String email = entrada.nextLine();

			String sql = " INSERT INTO Editora (nome , email ) " + " VALUES (’" + nome + " ’, ’" + email + " ’)";

			PreparedStatement comando = conexao.prepareStatement(sql);

			System.out.println(" Executando comando ... ");
			comando.execute();

			System.out.println(" Fechando conexão ... ");
			conexao.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
