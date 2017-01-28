package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import entity.Cliente;
import entity.Conta;
import entity.TipoConta;
import exception.DaoException;

public class Cadastrar {

	
	public Cadastrar() {
	}

	public void addCliente(Cliente cli) throws DaoException {
			try{
			String textoDoComando = "INSERT INTO Cliente (cpf, nome, sobrenome, sexo, estadoCivil, cep, endereco) " +
					"VALUES ('" + cli.getCpf() + "', '" + cli.getNome() + "', '" + cli.getSobrenome() + "', '" + cli.getSexo() + "', '" + cli.getEstadoCivil() + "', '" + cli.getCep() + "', '" + cli.getEndereco() + "')";
			Connection conexao = ConnectionFactory.createConnection();
			PreparedStatement comando = conexao.prepareStatement(textoDoComando);
			comando.execute();
			conexao.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
	
	public void addConta(Conta con) {
		try{
			String textoDoComando = "INSERT INTO Conta (codigo, agencia, saldo, tipo, cpf) " +
					"VALUES ('" + con.getCodigo() + "', '" + con.getAgencia() + "', '" + con.getSaldo() + "', '" + con.getTipo() + "', '" + con.getCliente().getCpf() + "')";
			Connection conexao = ConnectionFactory.createConnection ();
			PreparedStatement comando = conexao.prepareStatement(textoDoComando);
			comando.execute();
			conexao.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
