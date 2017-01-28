package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.Cliente;
import entity.Conta;

public class Update {
	
	public Update() {
		
	}
	
	public void updateCliente(Cliente clienteNovo) {
		String textoDoComando = "UPDATE Cliente SET " +
									"nome = " + clienteNovo.getNome() + "," +
									"sobrenome = " + clienteNovo.getSobrenome() + "," +
									"sexo = " + clienteNovo.getSexo() + "," +
									"estadoCivil = " + clienteNovo.getEstadoCivil() + "," +
									"cep = " + clienteNovo.getEndereco() + "," +
									"endereco = " + clienteNovo.getEndereco() +
								" WHERE cpf = " + clienteNovo.getCpf() + ";";
		
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
	
	public void updateConta(Conta contaNovo) {
		String textoDoComando = "UPDATE Conta SET " +
									"saldo = " + contaNovo.getSaldo() +
								" WHERE codigo = " + contaNovo.getCodigo() + ";";
		
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
