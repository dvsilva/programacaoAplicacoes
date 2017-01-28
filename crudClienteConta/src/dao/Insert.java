package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.Cliente;
import entity.Conta;

public class Insert {
	
	public Insert() {
		
	}
	
	public void addCliente(Cliente cli) {
		String textoDoComando = "INSERT INTO Cliente (cpf, nome, sobrenome, sexo, estadoCivil, cep, endereco) " +
					"VALUES ('" + cli.getCpf() + "', '" + cli.getNome() + "', '" + cli.getSobrenome() + "', '" + cli.getSexo() + "', '" + cli.getEstadoCivil() + "', '" + cli.getCep() + "', '" + cli.getEndereco() + "')";
		
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

	public void addConta(Conta con) {
		String textoDoComando = "INSERT INTO Conta (codigo, agencia, saldo, tipo, cpf) " +
					"VALUES ('" + con.getCodigo() + "', '" + con.getAgencia() + "', '" + con.getSaldo() + "', '" + con.getTipo() + "', '" + con.getCliente().getCpf() + "')";
		
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