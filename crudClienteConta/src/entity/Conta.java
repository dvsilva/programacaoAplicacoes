package entity;

import java.io.Serializable;

/**
 * @author Danyllo, Felipe e Hugo
 * @version 1.0
 */
public class Conta implements Serializable{
	/**
	 * c�digo da conta
	 */
	private int codigo;
	/**
	 * c�digo alfa-num�rico da ag�ncia
	 */
	private String agencia;
	/**
	 * valor em R$ do saldo
	 */
	private float saldo;
	/**
	 * atributo que aponta para enumeration do tipo da conta
	 */
	private TipoConta tipo;
	/**
	 * atributo de relacionamento
	 */
	private Cliente cliente;
	/**
	 * construtor default
	 */
	public Conta(){
	
	}
	/**
	 * construtor da conta com seus dados obrigat�rios
	 * @param codigo da conta
	 * @param agencia do cliente
	 * @param saldo da conta
	 * @param tipo da conta
	 */
	public Conta(int codigo, String agencia, float saldo, TipoConta tipo, Cliente cli) {
		super();
		this.codigo = codigo;
		this.agencia = agencia;
		this.saldo = saldo;
		this.tipo = tipo;
		this.setCliente(cli);
	}
	/**
	 * pegar o c�digo da conta
	 * @return
	 */
	public int getCodigo() {
		return codigo;
	}
	/**
	 * alterar o c�digo da conta
	 * @param codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	/**
	 * pegar o identificador da ag�ncia
	 * @return
	 */
	public String getAgencia() {
		return agencia;
	}
	/**
	 * alterar o identificador da ag�ncia
	 * @param agencia
	 */
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	/**
	 * pegar o saldo da conta
	 * @return
	 */
	public float getSaldo() {
		return saldo;
	}
	/**
	 * alterar o saldo da conta
	 * @param saldo
	 */
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	/**
	 * pegar o tipo da conta
	 * @return
	 */
	public TipoConta getTipo() {
		return tipo;
	}
	/**
	 * alterar o tipo da conta
	 * @param tipo
	 */
	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}
	/**
	 * @param cliente the cliente to set
	 */
	public boolean setCliente(Cliente cli) {
		if (this.cliente == cli)
			return false;
		if (cli == null) {
			Cliente anterior = this.cliente;
			anterior.removerConta(this);
			return true;
		}
		if (this.cliente != null) {
			this.cliente.removerConta(this);
		}
		this.cliente = cli;
		cli.adicionarConta(this);
		return true;
	}
	

}
