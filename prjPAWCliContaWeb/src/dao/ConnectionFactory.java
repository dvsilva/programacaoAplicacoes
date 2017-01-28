package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

	public class ConnectionFactory {
		
		private static Connection singleton;

		public static Connection createConnection(){
			
			String urlDeConexao = "jdbc:mysql://localhost:3306/bancopilares";
			String usuario = "root";
			String senha = "123456";
			
			try{
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			Connection conexao = null ;
			
			 try {
			 conexao = DriverManager.getConnection(urlDeConexao , usuario , senha) ;
			 } catch ( SQLException e ) {
			 e . printStackTrace () ;
			 }
			
			 return conexao;
		}
		
		
		/*public static Connection getSingleton() {
			if (singleton == null) {
				singleton = new ConnectionFactory().createConnection();
			}
			return singleton;
		}*/

	

}
