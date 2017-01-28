package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {

	private static final String URL_DE_CONEXAO = "jdbc:mysql://localhost:3307/bancopilares";
	private static final String USUARIO = "root";
	private static final String SENHA = "123456";

	public Conexao() {
	}

	public static Connection conectar() {
		String urlDeConexao = "jdbc:mysql://localhost:3307/bancopilares";
		String usuario = "root";
		String senha = "123456";
		
		Connection conexao = null;
		
		try  {
			conexao = DriverManager.getConnection(urlDeConexao, usuario, senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conexao;
	}
}
